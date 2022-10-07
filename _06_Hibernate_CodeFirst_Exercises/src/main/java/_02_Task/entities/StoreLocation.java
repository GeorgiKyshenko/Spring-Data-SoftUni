package _02_Task.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "store_location")
public class StoreLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "location_name", nullable = false)
    private String locationName;

    @OneToMany(targetEntity = Sale.class, mappedBy = "location")
    private Set<Sale> sales;

    public StoreLocation(String locationName) {
        this.locationName = locationName;
    }
}
