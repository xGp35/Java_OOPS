    import javax.swing.*;

    public class JFrame_Test {
        public static void main(String[] args) {
            
            // Make a Frame
            JFrame frame = new JFrame();

            // Make a widget
            JPanel myPanel = new MyDrawPanel();

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // Makes the program quit as soon as you close the window
            // Without this, it will just sit there on the screen till shutdown.

            //Add the widget to the Frame
            frame.getContentPane().add(myPanel);

            frame.setSize(300,300);
            frame.setVisible(true);
        }
    }