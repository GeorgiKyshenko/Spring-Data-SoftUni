package com.example.gamestore.services.user;

import com.example.gamestore.DTOs.userDTOs.UserLoginDTO;
import com.example.gamestore.DTOs.userDTOs.UserRegisterDTO;
import com.example.gamestore.entities.User;
import com.example.gamestore.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.gamestore.constants.Validation.USERNAME_OR_PASSWORD_INVALID_MESSAGE;

@Service
public class UserServiceImpl implements UserService {

    private User loggedInUser;

    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public String registerUser(String[] args) {

        String email = args[1];
        String password = args[2];
        String confirmPassword = args[3];
        String fullName = args[4];


        UserRegisterDTO userRegisterDTO;
        try {
            userRegisterDTO = new UserRegisterDTO(email, password, confirmPassword, fullName);
        } catch (IllegalArgumentException exception) {
            return exception.getMessage();
        }


        User user = mapper.map(userRegisterDTO, User.class);

//        // мапване, без ModelMapper
//        User userWithoutMapper = userRegisterDTO.toUser();

        if (this.userRepository.count() == 0) {
            user.setIsAdmin(true);
        }

        boolean isUserFound = this.userRepository.findByEmail(user.getEmail()).isPresent();

        // същотот като горното, само че с boolean метод в userRepository.
        boolean isUserEmailFound = userRepository.existsUserByEmail(user.getEmail());

        if (isUserFound) {
//            throw new IllegalArgumentException("Email already exists");
            return "Email already exists";
        }

        userRepository.save(user);
        return userRegisterDTO.successfulRegister();
    }

    @Override
    public String loginUser(String[] args) {

        String email = args[1];
        String password = args[2];

        UserLoginDTO userLoginDTO;

        try {
            userLoginDTO = new UserLoginDTO(email, password);
        } catch (IllegalArgumentException exception) {
            return exception.getMessage();
        }

        Optional<User> existingUser = userRepository.findByEmail(userLoginDTO.getEmail());

        //TODO email validation. If the email exists in the database!

        //Ако потребителя съществува в системата И ако не е логнат И ако паролата на съществуващият е равна на подадената отвън.
        if (existingUser.isPresent() && this.loggedInUser == null && existingUser.get().getPassword().equals(userLoginDTO.getPassword())) {
            this.loggedInUser = userRepository.findByEmail(userLoginDTO.getEmail()).get();
            return "Successfully logged in " + this.loggedInUser.getFullName();

        }
        return USERNAME_OR_PASSWORD_INVALID_MESSAGE;
    }

    @Override
    public String logoutUser() {
        if (this.loggedInUser == null) {
            return "Cannot log out. No user was logged in";
        }

        String output = String.format("User %s successfully logged out", this.loggedInUser.getFullName());

        this.loggedInUser = null;

        return output;
    }

    @Override
    public User getLoggedInUser() {
        return this.loggedInUser;
    }

}
