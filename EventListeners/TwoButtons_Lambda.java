import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoButtons {
    private JFrame frame;
    private JLabel label;

    public static void main(String[] args) {
        TwoButtons gui = new TwoButtons();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change label");
        labelButton.addActionListener(event -> label.setText("Ouch!"));
        // Instead of passing "this" (which is an object of class TwoButtons),
        // we pass appropriate Inner Class object

        JButton colorButton = new JButton("Change circle");
        colorButton.addActionListener(new ColorListener());
        // Same here

        label = new JLabel("I'm a label");
        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.WEST,label);
        frame.getContentPane().add(BorderLayout.CENTER,drawPanel);
        frame.getContentPane().add(BorderLayout.SOUTH,colorButton);
        frame.getContentPane().add(BorderLayout.EAST,labelButton);

        frame.setSize(500,400);
        frame.setVisible(true);

    }
}