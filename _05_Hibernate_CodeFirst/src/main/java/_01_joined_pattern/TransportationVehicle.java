package _01_joined_pattern;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
/*за да не създаваме отделна таблица с TransportationVehicle, @MappedSuperclass ни позволява да запишем информацията от класа,
 който наследява TransportationVehicle във Vehicles*/
public abstract class TransportationVehicle extends Vehicle {

    private int loadCapacity;

    public TransportationVehicle(String type, double price, int loadCapacity) {
        super(type, price);
        this.loadCapacity = loadCapacity;
    }

    public TransportationVehicle() {
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
