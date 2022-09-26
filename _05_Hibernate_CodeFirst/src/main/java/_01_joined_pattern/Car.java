package _01_joined_pattern;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car extends Vehicle {

    private static final String TYPE = "CAR";
    private int doorCount;

    public Car(int doorCount) {
        super(TYPE, 2500);
        this.doorCount = doorCount;
    }

    public Car() {

    }

    public int getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }

    public static String getCarType() {
        return TYPE;
    }
}
