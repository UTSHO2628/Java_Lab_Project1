import java.sql.*;

public class DatabaseConnection {
    public static Connection connect() {
        try {
            // Load MySQL JDBC driver manually
            Class.forName("com.mysql.cj.jdbc.Driver");

            // JDBC URL with SSL disabled and correct timezone
            String url = "jdbc:mysql://localhost:3306/student_management?useSSL=false&serverTimezone=UTC";
            String username = "root"; // MySQL default username
            String password = ""; // MySQL default password (empty)

            // Establishing the connection
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful!");
            return conn;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
