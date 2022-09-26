package _02_singele_table_pattern;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "vehicles")
@DiscriminatorColumn(name = "type")
// когато InheritanceType е JOINED, Vehicle класа вече се създава като таблица в SQL и можем да го анотираме с @Table и да посочим име!
public abstract class Vehicle2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column(insertable = false, updatable = false)
    private String type;
    private double price;


    public Vehicle2() {
    }

    public Vehicle2(String type, double price) {
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
