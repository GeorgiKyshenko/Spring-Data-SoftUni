package BookShop.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

@Entity(name = "books")
@NoArgsConstructor
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;

    @Column(nullable = false, length = 50)
    @Getter
    private String title;

    @Column(length = 1000)
    @Getter
    private String description;

    @Column(name = "editions_type", nullable = false)
    @Getter
    private EditionType editionType;


    @Column(nullable = false)
    @Getter
    private double price;
    @Getter
    private int copies;

    @Column(name = "release_date")
    @Getter
    private LocalDate releaseDate;

    @Column(name = "age_restrction", nullable = false)
    @Getter
    private AgeRestriction ageRestriction;

    @ManyToOne
    @Getter
    private Author author;

    @ManyToMany
    private Set<Category> categories;

    public Book(String title, EditionType editionType, double price, int copies, LocalDate releaseDate, AgeRestriction ageRestriction,
                Author author, Set<Category> categories) {
        this.title = title;
        this.editionType = editionType;
        this.price = price;
        this.copies = copies;
        this.releaseDate = releaseDate;
        this.ageRestriction = ageRestriction;
        this.author = author;
        this.categories = categories;
    }

    public Set<Category> getCategories() {
        return Collections.unmodifiableSet(categories);
    }
}
