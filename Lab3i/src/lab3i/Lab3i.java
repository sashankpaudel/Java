package lab3i;
import java.sql.*;
import java.io.*;

public class Lab3i {

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = null;
            con = DriverManager.getConnection("jdbc:mysql://localhost/acd", "root", "");
            System.out.println("Database connected!!");
            Statement stmt = con.createStatement();
            String q1 = "INSERT INTO ACDtest (name,roll,address) values ('Manish',03311,'BKT')";
            stmt.executeUpdate(q1);
            String q3 = "UPDATE ACDtest \n" +
                        "SET name = 'Alfred Schmidt', address = 'PKR'\n" +
                        "WHERE roll = 01111 ;";
            stmt.executeUpdate(q3);
            ResultSet rs = stmt.executeQuery("select * from acdtest");
            while (rs.next())
                System.out.println(rs.getString("name") + "  " + rs.getInt("roll") + "  " + rs.getString("address"));
            con.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
