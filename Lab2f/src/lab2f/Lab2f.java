package lab2f;

import javax.swing.*;
import java.awt.*;

public class Lab2f extends JFrame {

    public Lab2f() {
        setTitle("Registration Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,900);

        JTextField usernameField = new JTextField(10);
        JPasswordField passwordField = new JPasswordField(20);
        JRadioButton maleRadio = new JRadioButton("Male");
        JRadioButton femaleRadio = new JRadioButton("Female");
        JCheckBox subscribe = new JCheckBox("Subscribe to our newsletter");
        String[] countries = {"Select", "USA", "Canada", "Australia", "Other"};
        JComboBox<String> country = new JComboBox<>(countries);
        JTextArea address = new JTextArea(5, 20);

        ImageIcon logo = new ImageIcon("Z:\\Projects\\Java\\JavaLab\\3.jpg");
        JLabel imageLabel = new JLabel(logo);

        JPanel panel = new JPanel(new GridLayout(8, 2, 5, 5));

        panel.add(new JLabel("Username: ")); 
        panel.add(usernameField);
        
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        
        panel.add(new JLabel("Gender: "));
        panel.add(maleRadio);
        
        panel.add(new JLabel(""));
        panel.add(femaleRadio);

        panel.add(new JLabel("Country: "));
        panel.add(new JScrollPane(country));
        
        panel.add(new JLabel("Address:"));
        panel.add(new JScrollPane(address));

        panel.add(new JLabel("Subscribe: "));
        panel.add(subscribe);
        
        panel.add(new JLabel("Image:"));
        panel.add(imageLabel);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        
        add(panel);
        
        setLayout(new FlowLayout(FlowLayout.CENTER));
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new Lab2f();
    }
}