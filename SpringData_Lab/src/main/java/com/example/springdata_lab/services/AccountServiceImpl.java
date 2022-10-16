package com.example.springdata_lab.services;

import com.example.springdata_lab.models.Account;
import com.example.springdata_lab.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal amount, Integer id) {
        Account account = accountRepository.findById(id).orElseThrow();
        if (account.getBalance().equals(amount) || account.getBalance().compareTo(amount) > 0) {
            account.setBalance(account.getBalance().subtract(amount));
        } else {
            throw new IllegalArgumentException("You Have No Balance In Your Bank Account");
        }
        accountRepository.save(account);
    }

    @Override
    public void transferMoney(BigDecimal amount, Integer id) {
        Account account = accountRepository.findById(id).orElseThrow();
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            account.setBalance(account.getBalance().add(amount));
        } else {
            throw new IllegalArgumentException("You Tried To Deposit Negative Amount. Try Again");
        }
        accountRepository.save(account);
    }

    @Override
    public void addAccount(Account account) {
        accountRepository.save(account);
    }
}
