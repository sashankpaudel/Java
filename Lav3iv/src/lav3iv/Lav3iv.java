package lav3iv;
import java.sql.*;

public class Lav3iv {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/acd";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            insertRecord(connection, "Naruto", "Uzumaki", 25);
            updateRecord(connection, 1, "Jane");
            queryAllRecords(connection);
            deleteRecord(connection, 1);
            queryAllRecords(connection);

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    private static void insertRecord(Connection connection, String firstName, String lastName, int age) throws SQLException {
        String insertSQL = "INSERT INTO employees (first_name, last_name, age) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " record(s) inserted.");
        }
    }
    private static void updateRecord(Connection connection, int id, String newFirstName) throws SQLException {
        String updateSQL = "UPDATE employees SET first_name = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
            preparedStatement.setString(1, newFirstName);
            preparedStatement.setInt(2, id);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " record(s) updated.");
        }
    }
    private static void queryAllRecords(Connection connection) throws SQLException {
        String querySQL = "SELECT * FROM employees";
        try (PreparedStatement preparedStatement = connection.prepareStatement(querySQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            System.out.println("All Records:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id")
                        + ", First Name: " + resultSet.getString("first_name")
                        + ", Last Name: " + resultSet.getString("last_name")
                        + ", Age: " + resultSet.getInt("age"));
            }
        }
    }
    private static void deleteRecord(Connection connection, int id) throws SQLException {
        String deleteSQL = "DELETE FROM employees WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " record(s) deleted.");
        }
    }
}
