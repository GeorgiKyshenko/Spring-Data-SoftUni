package _02_Task.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@NoArgsConstructor
@Getter
@Setter
@Entity(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(name = "credit_card_number", nullable = false)
    private String creditCardNumber;

    @OneToMany(targetEntity = Sale.class, mappedBy = "customer")
    private Set<Sale> sales;

    public Customer(String name, String email, String creditCardNumber) {
        this.name = name;
        this.email = email;
        this.creditCardNumber = creditCardNumber;
    }
}
