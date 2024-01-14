import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseTest {
    public static void main(String[] args) {
        // Database connection parameters
        String jdbcUrl = "jdbc:mysql://localhost:3306/sakila?serverTimezone=UTC&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&zeroDateTimeBehavior=CONVERT_TO_NULL";
        String username = "masan";
        String password = "19961996m";

        // Create a connection
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Database connection successful!");

            // You can perform database operations here

            // Close the connection when done
            connection.close();
            System.out.println("Database connection closed.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Database connection failed.");
        }
    }
}
