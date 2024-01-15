package lab3iii;
import java.sql.*;

public class Lab3iii {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/acd";
        String username = "root";
        String password = "";
        String createTableSQL = "CREATE TABLE IF NOT EXISTS employees ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "first_name VARCHAR(50),"
                + "last_name VARCHAR(50),"
                + "age INT"
                + ")";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            Statement statement = connection.createStatement();
            statement.executeUpdate(createTableSQL);
            System.out.println("Table 'employees' created successfully.");
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
