package _01_joined_pattern;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bikes")
public class Bike extends Vehicle {

    private static final String TYPE = "BIKE";
    private int gearCount;

    public Bike(int gearCount) {
        super(TYPE, 400);
        this.gearCount = gearCount;
    }

    public Bike() {

    }

    public int getGearCount() {
        return gearCount;
    }

    public void setGearCount(int gearCount) {
        this.gearCount = gearCount;
    }

    public static String getBikeType() {
        return TYPE;
    }

}
