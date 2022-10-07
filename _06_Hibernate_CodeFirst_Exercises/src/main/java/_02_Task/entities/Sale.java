package _02_Task.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "sales")
@NoArgsConstructor
@Getter
@Setter
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime date;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "location_id",referencedColumnName = "id")
    private StoreLocation location;

    public Sale(Product product, Customer customer, StoreLocation location) {
        this.product = product;
        this.customer = customer;
        this.location = location;
        this.date = LocalDateTime.now();
    }
}
