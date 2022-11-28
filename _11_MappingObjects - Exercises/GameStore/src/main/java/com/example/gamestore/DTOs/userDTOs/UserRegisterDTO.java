package com.example.gamestore.DTOs.userDTOs;

import com.example.gamestore.entities.User;
import lombok.Getter;
import lombok.Setter;

import java.util.regex.Pattern;

import static com.example.gamestore.constants.Validation.*;

@Getter
public class UserRegisterDTO {

    @Setter
    private String email;

    private final String password;

    @Setter
    private String confirmPassword;

    @Setter
    private String fullName;


    public UserRegisterDTO(String email, String password, String confirmPassword, String fullName) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.fullName = fullName;
        validate();
    }

    private void validate() throws IllegalArgumentException {

        final boolean isEmailValid = Pattern.matches(EMAIL_PATTERN, this.email);
        if (!isEmailValid) {
            throw new IllegalArgumentException(EMAIL_NOT_INVALID_MESSAGE);
        }

        final boolean isPasswordValid = Pattern.matches(PASSWORD_PATTERN, this.password);
        if (!isPasswordValid) {
            throw new IllegalArgumentException(USERNAME_OR_PASSWORD_INVALID_MESSAGE);
        }

        if (!password.equals(confirmPassword)) {
            throw new IllegalArgumentException(PASSWORD_MISS_MATCH_INVALID_MESSAGE);
        }
    }

    // използва се в случай, че не използваме ModelMapper.
    public User toUser() {
        return new User(email, password, fullName);
    }

    public String successfulRegister() {
        return String.format("%s was registered!", fullName);
    }
}
