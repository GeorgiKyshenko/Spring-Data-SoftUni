package com.example.gamestore;

import com.example.gamestore.services.game.GameService;
import com.example.gamestore.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.example.gamestore.constants.Command.*;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private static final Scanner scanner = new Scanner(System.in);
    private final UserService userService;
    private final GameService gameService;

    @Autowired
    public ConsoleRunner(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public void run(String... args) throws Exception {

        String input = scanner.nextLine();

        while (!input.equals("close")) {

            final String[] inputParts = input.split("\\|");
            final String command = inputParts[0];

            String output = switch (command) {
                case REGISTER_USER -> userService.registerUser(inputParts);
                case LOGIN_USER -> userService.loginUser(inputParts);
                case LOGOUT_USER -> userService.logoutUser();
                case ADD_GAME -> gameService.addGame(inputParts);
                default -> "Command not found";
            };
            System.out.println(output);

            input = scanner.nextLine();
        }
    }
}
