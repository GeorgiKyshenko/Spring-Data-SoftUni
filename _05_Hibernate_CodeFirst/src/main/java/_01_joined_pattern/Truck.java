package _01_joined_pattern;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "trucks")
public class Truck extends TransportationVehicle {

    private static final String TYPE = "TRUCK";

    public Truck(int loadCapacity) {
        super(TYPE, 4500, loadCapacity);
    }

    public Truck() {

    }
}
