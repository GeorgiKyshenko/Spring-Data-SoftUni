package com.example.springdata_lab.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "users")
@NoArgsConstructor
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;

    @Column(unique = true, nullable = false)
    @Getter
    private String username;
    @Getter
    private int age;
    @OneToMany(targetEntity = Account.class, mappedBy = "user")
    private Set<Account> accounts;


    public User(String username, int age) {
        this.username = username;
        this.age = age;
        this.accounts = new HashSet<>();
    }

    public Set<Account> getAccounts() {
        return Collections.unmodifiableSet(accounts);
    }
}
