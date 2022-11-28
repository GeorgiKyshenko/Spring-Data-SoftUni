package com.example.gamestore.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter@Setter
public class Order extends BaseEntity {

    @ManyToOne
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Game> games;

    public Order() {
        games = new HashSet<>();
    }

    public Order(User user, Set<Game> games) {
        this();
        this.user = user;
        this.games = games;
    }
}
