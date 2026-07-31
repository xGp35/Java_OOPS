import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGui3 implements ActionListener {
    private JFrame frame;

    public static void main(String[] args){
        SimpleGui3 gui = new SimpleGui3();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Change colors");
        button.addActionListener(this);

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.CENTER,drawPanel);
        frame.getContentPane().add(BorderLayout.SOUTH,button);

        frame.setSize(500,500);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        frame.repaint();
    }
}