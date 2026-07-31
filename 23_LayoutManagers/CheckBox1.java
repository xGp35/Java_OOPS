import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckBox1 implements ItemListener{
    private JCheckBox check;

    public static void main(String[] args) {
        CheckBox1 gui = new CheckBox1();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

        check = new JCheckBox("Goes to 11");
        check.addItemListener(this);

        panel.add(check);
        frame.add(panel);

        frame.setSize(350, 300);
        frame.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String onOrOff = "off";
        if (check.isSelected()) {
            onOrOff = "on";
        }
        System.out.println("Check box is " + onOrOff);
    }
}