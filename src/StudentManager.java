import java.sql.*;

public class StudentManager {
    public static void addStudent(String name, String email, String phone, String address) {
        try (Connection conn = DatabaseConnection.connect()) {
            if (conn != null) {
                String query = "INSERT INTO student (name, email, phone, address) VALUES (?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setString(1, name);
                    stmt.setString(2, email);
                    stmt.setString(3, phone);
                    stmt.setString(4, address);
                    stmt.executeUpdate();
                    System.out.println("Student added successfully!");
                }
            } else {
                System.out.println("Database connection failed!");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Example of adding a student
        addStudent("John Doe", "john@example.com", "1234567890", "123 Street, City");
    }
}
