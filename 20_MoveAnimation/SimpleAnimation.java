import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

class SimpleAnimation {
    private JFrame frame;
    private JLabel label;
    private int xPos;
    private int yPos;

    public static void main(String[] args) {
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawCirclePanel drawCircle = new DrawCirclePanel();

        frame.getContentPane().add(BorderLayout.CENTER,drawCircle);
        frame.setSize(300,300);
        frame.setVisible(true);

        for (int i = 0; i < 130; i++) {
            xPos++;
            yPos++;

            drawCircle.repaint();

            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class DrawCirclePanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            g.setColor(Color.orange);
            g.fillOval(xPos,yPos,40,40);
        }
    }
}