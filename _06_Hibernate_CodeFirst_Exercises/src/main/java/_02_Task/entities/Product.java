package _02_Task.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int quantity;
    private BigDecimal price;

    @OneToMany(targetEntity = Sale.class, mappedBy = "product")
    private Set<Sale> sales;



    public Product(String name, int quantity, BigDecimal price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
