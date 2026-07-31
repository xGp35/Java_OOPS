import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyGui implements ActionListener {
    private JFrame frame;
    private JLabel label;
    private JButton colorButton;
    private JButton labelButton;

    public static void main(String[] args){
        MyGui gui = new MyGui();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("I'm a label");
        colorButton = new JButton("Change colors");
        labelButton = new JButton("Change label");       

        colorButton.addActionListener(this);
        labelButton.addActionListener(this);

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.WEST,label);
        frame.getContentPane().add(BorderLayout.CENTER,drawPanel);
        frame.getContentPane().add(BorderLayout.SOUTH,colorButton);
        frame.getContentPane().add(BorderLayout.EAST,labelButton);

        frame.setSize(500,500);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        // This works but not a good OO design. Single method doing many different things
        if (e.getSource() == colorButton) {
            frame.repaint();
        } else {
            label.setText("That hurt!");
        }
        
    }
}