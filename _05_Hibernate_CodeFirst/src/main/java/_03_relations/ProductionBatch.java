package _03_relations;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "productions")
public class ProductionBatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate createdAt;

    @OneToMany(mappedBy = "productionBatch", targetEntity = BasicShampoo.class,
     fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<BasicShampoo> shampoos;

    public ProductionBatch(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public ProductionBatch() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Set<BasicShampoo> getShampoos() {
        return shampoos;
    }

    public void setShampoos(Set<BasicShampoo> shampoos) {
        this.shampoos = shampoos;
    }
}
