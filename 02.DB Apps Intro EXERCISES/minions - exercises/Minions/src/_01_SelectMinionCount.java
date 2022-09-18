import java.sql.*;
import java.util.Properties;

public class _01_SelectMinionCount {
    public static void main(String[] args) throws SQLException {

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "silistar");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db",properties);

        PreparedStatement statement = connection.prepareStatement("""
                select name, count(distinct mv.minion_id) as minion_count
                from villains as v
                join minions_villains as mv on mv.villain_id = v.id
                group by mv.villain_id
                having minion_count > ?
                order by minion_count desc;""");

        statement.setInt(1,15);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String villainName = resultSet.getString("name");
            int minionCount = resultSet.getInt("minion_count");
            System.out.println(villainName + " " + minionCount);
        }

        connection.close();
    }
}