package com.example.gamestore.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "games")
@AllArgsConstructor
@Getter
@Setter
public class Game extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private float size;

    @Column(name = "trailer_id")
    private String trailerID;

    @Column(name = "image_URL")
    private String imageURL;


    private String description;

    @Column(nullable = false)
    private LocalDate releaseDate;


    public Game() {
    }
}
