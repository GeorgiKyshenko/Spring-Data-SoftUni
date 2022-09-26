package _02_singele_table_pattern;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
/*за да не създаваме отделна таблица с TransportationVehicle, @MappedSuperclass ни позволява да запишем информацията от класа,
 който наследява TransportationVehicle във Vehicles*/
public abstract class TransportationVehicle2 extends Vehicle2 {

    private int loadCapacity;

    public TransportationVehicle2(String type, double price, int loadCapacity) {
        super(type, price);
        this.loadCapacity = loadCapacity;
    }

    public TransportationVehicle2() {
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
