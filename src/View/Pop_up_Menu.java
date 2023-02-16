package View;

import Controller.Controller;

import java.awt.*;
import javax.swing.*;


public class Pop_up_Menu extends JFrame {
    public static JFrame f = new JFrame("Rules");

    /**
     * <b>constructor</b>: Creates a new Menu Window  <br />
     * <b>postconditions</b>: Creates a new Menu Window
     */
    public Pop_up_Menu() {
        f.setBounds(400, 400, 550, 150);
        // set layout of frame
        f.setLayout(new FlowLayout());

        // create checkbox
        JCheckBox c1 = new JCheckBox("Θα θέλατε να παίξεται με τους κλασσικούς κανόνες; Αν ναι τικάρετε το checkbox");
        JButton button = new JButton("Save");

        // create a new panel
        JPanel p = new JPanel();

        // add checkbox to panel
        p.add(c1);
        p.add(button);

        // add panel to frame
        f.add(p);

        button.setBounds(200, 200, 90, 50);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // adds button in JFrame
        f.add(button);

        //close the pop-up menu
        button.addActionListener(evt -> f.dispose());

        Controller.original_rules = c1.isSelected();

        f.setVisible(true);
    }
}