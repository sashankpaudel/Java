package lab2h;
import javax.swing.*;

public class Lab2h {
    private void createAndShowGUI() {
        JFrame frame = new JFrame("Dialog Box Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new java.awt.FlowLayout());

        JButton messageBoxButton = new JButton("Show Message Dialog");
        JButton inputDialogButton = new JButton("Show Input Dialog");
        JButton confirmDialogButton = new JButton("Show Confirm Dialog");
        JButton optionDialogButton = new JButton("Show Option Dialog");
        
        frame.add(optionDialogButton);
        frame.add(messageBoxButton);
        frame.add(inputDialogButton);
        frame.add(confirmDialogButton);
 
        JOptionPane.showMessageDialog(null, "This is a message dialog.", "Message Dialog", JOptionPane.INFORMATION_MESSAGE);

        String userInput = JOptionPane.showInputDialog(null, "Enter something:", "Input Dialog", JOptionPane.QUESTION_MESSAGE);
        if (userInput != null) {
            System.out.println("User entered: " + userInput);
        } else {
            System.out.println("User canceled the input dialog.");
        }

        int result = JOptionPane.showConfirmDialog(null, "Do you want to proceed?", "Confirm Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            System.out.println("User clicked YES.");
        } else if (result == JOptionPane.NO_OPTION) {
            System.out.println("User clicked NO.");
        } else {
            System.out.println("User clicked CANCEL or closed the dialog.");
        }

        Object[] options = {"Option 1", "Option 2", "Option 3"};
        result = JOptionPane.showOptionDialog(null, "Choose an option:", "Option Dialog", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (result >= 0) {
            System.out.println("User selected: " + options[result]);
        } else {
            System.out.println("User closed the option dialog.");
        }

        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Lab2h gui = new Lab2h();
        gui.createAndShowGUI();
        
    }
}