package com.example.springdata_lab.services;

import com.example.springdata_lab.models.Account;

import java.math.BigDecimal;

public interface AccountService {

    void withdrawMoney(BigDecimal amount, Integer id);
    void transferMoney(BigDecimal amount, Integer id);

    void addAccount(Account account);
}
