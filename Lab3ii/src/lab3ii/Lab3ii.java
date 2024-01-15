package lab3ii;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Lab3ii{
    private JTextField num1TextField;
    private JTextField num2TextField;
    private JLabel resultLabel;
    
    private void createAndShowGUI() {
        JFrame frame = new JFrame("Sum Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(4, 2));

        JLabel num1Label = new JLabel("Enter Number 1:");
        num1TextField = new JTextField();

        JLabel num2Label = new JLabel("Enter Number 2:");
        num2TextField = new JTextField();

        JButton calculateButton = new JButton("Calculate Sum");
        calculateButton.addActionListener(new Lab3ii.CalculateButtonListener());

        resultLabel = new JLabel("Sum will be displayed here.");
        frame.add(num1Label);
        frame.add(num1TextField);
        frame.add(num2Label);
        frame.add(num2TextField);
        frame.add(new JLabel());
        frame.add(calculateButton);
        frame.add(new JLabel());
        frame.add(resultLabel);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Lab3ii gui = new Lab3ii();
        gui.createAndShowGUI();
    }
    
    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                double num1 = Double.parseDouble(num1TextField.getText());
                double num2 = Double.parseDouble(num2TextField.getText());

                double sum = num1 + num2;

                resultLabel.setText("Sum: " + sum);

                insertIntoDatabase(num1, num2, sum);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input. Please enter valid numbers.");
            }
        }
    }
    private void insertIntoDatabase(double num1, double num2, double sum) {
            String jdbcUrl = "jdbc:mysql://localhost/sum";
            String username = "root";
            String password = "";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

                String insertQuery = "INSERT INTO sumresult (num1, num2, sum) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

                preparedStatement.setDouble(1, num1);
                preparedStatement.setDouble(2, num2);
                preparedStatement.setDouble(3, sum);

                preparedStatement.executeUpdate();

                preparedStatement.close();
                connection.close();
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
        }
}
