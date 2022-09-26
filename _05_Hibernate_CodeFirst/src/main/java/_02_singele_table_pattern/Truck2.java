package _02_singele_table_pattern;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "truck")
public class Truck2 extends TransportationVehicle2 {

    private static final String TYPE = "TRUCK";

    public Truck2(int loadCapacity) {
        super(TYPE, 4500, loadCapacity);
    }

    public Truck2() {

    }
}
