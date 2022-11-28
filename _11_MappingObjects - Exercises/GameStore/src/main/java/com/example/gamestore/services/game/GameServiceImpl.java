package com.example.gamestore.services.game;

import com.example.gamestore.DTOs.gameDTOs.AddGameDTO;
import com.example.gamestore.entities.Game;
import com.example.gamestore.repositories.GameRepository;
import com.example.gamestore.services.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final UserService userService;
    private final ModelMapper mapper;

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, UserService userService, ModelMapper mapper) {
        this.gameRepository = gameRepository;
        this.userService = userService;
        this.mapper = mapper;
    }

    @Override
    public String addGame(String[] args) {

        if (this.userService.getLoggedInUser() != null && this.userService.getLoggedInUser().getIsAdmin()) {

            String title = args[1];
            BigDecimal price = BigDecimal.valueOf(Double.parseDouble(args[2]));
            float size = Float.parseFloat(args[3]);
            String trailerID = args[4];
            String imageURL = args[5];
            String description = args[6];
            LocalDate releaseDate = LocalDate.parse(args[7], dateTimeFormatter);

            AddGameDTO addGameDTO;
            try {
                addGameDTO = new AddGameDTO(title, price, size, trailerID, imageURL, description, releaseDate);
            } catch (IllegalArgumentException exception) {
                return exception.getMessage();
            }

//            Game addedGame1 = mapper.map(addGameDTO, Game.class); проблем с мапване на trailerID(String) към Long ?!?!

            Game addedGame = addGameDTO.toGame();
            gameRepository.save(addedGame);

            return String.format("Added %s", addedGame.getTitle());
        }
        return "Impossible command";
    }


    @Override
    public String editGame(String[] args) {
        return null;
    }

    @Override
    public String deleteGame(Long id) {
        return null;
    }
}
