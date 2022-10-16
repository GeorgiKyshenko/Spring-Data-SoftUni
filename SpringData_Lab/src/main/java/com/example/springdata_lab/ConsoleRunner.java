package com.example.springdata_lab;

import com.example.springdata_lab.models.Account;
import com.example.springdata_lab.models.User;
import com.example.springdata_lab.repositories.AccountRepository;
import com.example.springdata_lab.services.AccountService;
import com.example.springdata_lab.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private UserService userService;
    private AccountService accountService;

    @Autowired
    public ConsoleRunner(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("Georgi", 29);
        userService.registerUser(user1);

        Account account1 = new Account(BigDecimal.valueOf(5634.45), user1);
        accountService.addAccount(account1);

        User user2 = new User("Martin", 27);
        userService.registerUser(user2);

        Account account2 = new Account(BigDecimal.valueOf(3624.95), user2);
        accountService.addAccount(account2);


        User user3 = new User("Georgi", 29);
        userService.registerUser(user3);
    }
}
