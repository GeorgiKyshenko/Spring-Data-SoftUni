package _01_joined_pattern;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "vehicles")
// когато InheritanceType е JOINED, Vehicle класа вече се създава като таблица в SQL и можем да го анотираме с @Table ида посочим име!
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE) //при JOINED не е проблем ако strategy = GenerationType.IDENTITY!
    private int id;
    @Basic
    private String type;
    private double price;


    public Vehicle() {
    }

    public Vehicle(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
