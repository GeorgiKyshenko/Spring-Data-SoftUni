package com.example.gamestore.constants;

import com.example.gamestore.DTOs.gameDTOs.AddGameDTO;

public enum Validation {
    ;
    public static final String EMAIL_PATTERN = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,63})$";
    public static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";
    public static final String EMAIL_NOT_INVALID_MESSAGE = "Incorrect email.";
    public static final String USERNAME_OR_PASSWORD_INVALID_MESSAGE = "Incorrect username / password";
    public static final String PASSWORD_MISS_MATCH_INVALID_MESSAGE = "Passwords are not matching";
    public static final String COMMAND_NOT_FOUND = "Command not found";

}
