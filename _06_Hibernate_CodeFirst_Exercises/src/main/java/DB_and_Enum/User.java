package DB_and_Enum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING) //EnumType.STRING използва value стойностите на полетата в enum класа, иначе в базата се изписват индексите на полетата в enum класа!
    @Column(nullable = false)
    private AccountType type;

    public User(String name, AccountType type) {
        this.name = name;
        this.type = type;
    }
}
