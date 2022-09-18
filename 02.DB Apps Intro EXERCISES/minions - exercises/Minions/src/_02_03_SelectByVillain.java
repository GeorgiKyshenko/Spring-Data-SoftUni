import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _02_03_SelectByVillain {
    public static void main(String[] args) throws SQLException {

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "silistar");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        Scanner scanner = new Scanner(System.in);
        int id = Integer.parseInt(scanner.nextLine());

        PreparedStatement villainStatement = connection.prepareStatement("SELECT name FROM villains WHERE id = ?");
        villainStatement.setInt(1, id);

        ResultSet villainSet = villainStatement.executeQuery();

        if (villainSet.next()) {
            System.out.println("Villain: " + villainSet.getString("name"));
        } else {
            System.out.printf("No villain with ID %d exists in the database", id);
            return;
        }

        PreparedStatement minionStatement = connection.prepareStatement("""
                SELECT name, age FROM minions AS m
                JOIN minions_villains AS mv ON mv.minion_id = m.id
                WHERE mv.villain_id = ?;""");

        minionStatement.setInt(1, id);

        ResultSet minionSet = minionStatement.executeQuery();

        for (int i = 1; minionSet.next(); i++) {
            String name = minionSet.getString("name");
            int age = minionSet.getInt("age");
            System.out.printf("%d. %s %d%n", i, name, age);

        }


    }
}
