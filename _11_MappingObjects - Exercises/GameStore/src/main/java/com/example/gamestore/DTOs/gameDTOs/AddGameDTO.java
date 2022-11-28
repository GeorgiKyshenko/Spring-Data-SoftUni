package com.example.gamestore.DTOs.gameDTOs;

import com.example.gamestore.entities.Game;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class AddGameDTO {

    private String title;
    private BigDecimal price;
    private float size;
    private String trailerID;

    private String imageURL;

    private String description;

    private LocalDate releaseDate;

    public AddGameDTO(String title, BigDecimal price, float size, String trailerID, String imageURL, String description, LocalDate releaseDate) {
        setTitle(title);
        setPrice(price);
        setSize(size);
        setTrailerID(trailerID);
        setImageURL(imageURL);
        setDescription(description);
        setReleaseDate(releaseDate);
    }

    public void setTitle(String title) {
        if (title == null || !Character.isUpperCase(title.charAt(0))
                || title.length() < 3
                || title.length() > 100) {
            throw new IllegalArgumentException("Not a valid game title");
        }
        this.title = title;
    }

    public void setTrailerID(String trailerID) {
        if (trailerID == null || trailerID.length() != 11) {
            throw new IllegalArgumentException("Trailer ID should be exactly 11 symbols");
        }
        this.trailerID = trailerID;
    }

    public void setImageURL(String imageURL) {
        if (imageURL != null && (imageURL.startsWith("http://") || imageURL.startsWith("https://"))) {
            this.imageURL = imageURL;
        } else {
            throw new IllegalArgumentException("Link should begin with http:// or https://");
        }
    }

    public void setSize(float size) {
        if (size < 0 || size == 0) {
            throw new IllegalArgumentException("Size should be positive value");
        }
        this.size = size;
    }

    public void setPrice(BigDecimal price) {
        if (price == null || price.doubleValue() < 0) {
            throw new IllegalArgumentException("Price should be positive number");
        }
        this.price = price;
    }

    public void setDescription(String description) {
        if (description == null || description.length() < 20) {
            throw new IllegalArgumentException("Description should be at least 20 symbols");
        }
        this.description = description;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Game toGame() {
        return new Game(title, price, size, trailerID, imageURL, description, releaseDate);
    }
}
