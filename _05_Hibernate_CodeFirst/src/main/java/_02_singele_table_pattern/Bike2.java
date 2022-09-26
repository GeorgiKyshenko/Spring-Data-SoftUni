package _02_singele_table_pattern;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "bike")
public class Bike2 extends Vehicle2 {

    private static final String TYPE = "BIKE";
    private int gearCount;

    public Bike2(int gearCount) {
        super(TYPE, 400);
        this.gearCount = gearCount;
    }

    public Bike2() {

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
