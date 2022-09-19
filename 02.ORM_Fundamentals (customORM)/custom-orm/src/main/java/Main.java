import Entities.User;
import ORM.EntityManager;
import ORM.MyConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException {

        MyConnector.createConnection("root", "silistar", "custom-orm");

        Connection connection = MyConnector.getConnection();

        EntityManager<User> userEntityManager = new EntityManager<>(connection);

        User user = new User("Ivan", 27, LocalDate.now());

        userEntityManager.persist(user);

    }
}
