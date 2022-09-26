package _02_singele_table_pattern;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "car")
public class Car2 extends Vehicle2 {

    private static final String TYPE = "CAR";
    private int doorCount;

    public Car2(int doorCount) {
        super(TYPE, 2500);
        this.doorCount = doorCount;
    }

    public Car2() {

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
