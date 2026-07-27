import javax.swing.*;

public class SimpleGui1 {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        JButton button = new JButton("click me");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Makes the program quit as soon as you close the window
        // Without this, it will just sit there on the screen till shutdown.

        frame.getContentPane().add(button);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}