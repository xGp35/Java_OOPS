import javax.swing.*;

public class SimpleGui1 {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        JButton button = new JButton("click me");
        JRadioButton radioButton = new JRadioButton("choose me");
        JCheckBox checkBox = new JCheckBox("check me out");
        JLabel label = new JLabel("label me");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Makes the program quit as soon as you close the window
        // Without this, it will just sit there on the screen till shutdown.

        frame.getContentPane().add(button);
        //frame.getContentPane().add(radioButton);
        //frame.getContentPane().add(checkBox);
        frame.getContentPane().add(label);
    
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}