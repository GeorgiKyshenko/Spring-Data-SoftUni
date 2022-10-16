package com.example.springdata_lab.models;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "accounts")
@NoArgsConstructor
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private BigDecimal balance;
    @ManyToOne
    private User user;

    public Account(BigDecimal balance, User user) {
        this.balance = balance;
        this.user = user;
    }
}
