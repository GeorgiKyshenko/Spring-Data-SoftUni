package _03_relations;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ingredients")
public class BasicIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private double quantity;

    private String type;

    @ManyToMany(mappedBy = "basicIngredient", targetEntity = BasicIngredient.class)
    private Set<BasicShampoo> shampoos;


    public BasicIngredient(double quantity, String type) {
        this.quantity = quantity;
        this.type = type;
    }

    public BasicIngredient() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<BasicShampoo> getShampoos() {
        return shampoos;
    }

    public void setShampoos(Set<BasicShampoo> shampoos) {
        this.shampoos = shampoos;
    }
}
