package View;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;

public class View_Board {
    public static JFrame frame = new JFrame("Stratego");
    final int width_screen = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    final int height_screen = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2;
    public static Vector<JButton> buttons = new Vector<>(80);

    /**
     * <b>constructor</b>: Creates a new Board Window  <br />
     * <b>postconditions</b>: Creates a new Board Window
     */
    public View_Board() {
        frame.setBounds(0, 0, width_screen, height_screen);
        frame.setVisible(true);
        final int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2;

        View_Board.frame.setLayout(null);

        int i;
        for (i = 0; i < 80; i++)
            buttons.add(new JButton());


        //left forbidden area
        buttons.get(42).setBackground(Color.yellow);
        buttons.get(42).setBounds(width - 240, 320, 80, 80);
        frame.add(buttons.get(42));
        buttons.get(32).setBackground(Color.yellow);
        buttons.get(32).setBounds(width - 240, 400, 80, 80);
        frame.add(buttons.get(32));
        buttons.get(43).setBackground(Color.yellow);
        buttons.get(43).setBounds(width - 160, 320, 80, 80);
        frame.add(buttons.get(43));
        buttons.get(33).setBackground(Color.yellow);
        buttons.get(33).setBounds(width - 160, 400, 80, 80);
        frame.add(buttons.get(33));

        //right forbidden area
        buttons.get(46).setBackground(Color.yellow);
        buttons.get(46).setBounds(width + 80, 320, 80, 80);
        frame.add(buttons.get(46));
        buttons.get(47).setBackground(Color.yellow);
        buttons.get(47).setBounds(width + 160, 320, 80, 80);
        frame.add(buttons.get(47));
        buttons.get(36).setBackground(Color.yellow);
        buttons.get(36).setBounds(width + 80, 400, 80, 80);
        frame.add(buttons.get(36));
        buttons.get(37).setBackground(Color.yellow);
        buttons.get(37).setBounds(width + 160, 400, 80, 80);
        frame.add(buttons.get(37));

        buttons.get(40).setBounds(width - 400, 320, 80, 80);
        buttons.get(40).setBackground(Color.white);
        frame.add(buttons.get(40));
        buttons.get(30).setBounds(width - 400, 400, 80, 80);
        buttons.get(30).setBackground(Color.white);
        frame.add(buttons.get(30));
        buttons.get(41).setBounds(width - 320, 320, 80, 80);
        buttons.get(41).setBackground(Color.white);
        frame.add(buttons.get(41));
        buttons.get(31).setBounds(width - 320, 400, 80, 80);
        buttons.get(31).setBackground(Color.white);
        frame.add(buttons.get(31));
        buttons.get(44).setBounds(width - 80, 320, 80, 80);
        buttons.get(44).setBackground(Color.white);
        frame.add(buttons.get(44));
        buttons.get(34).setBounds(width - 80, 400, 80, 80);
        buttons.get(34).setBackground(Color.white);
        frame.add(buttons.get(34));
        buttons.get(45).setBounds(width, 320, 80, 80);
        buttons.get(45).setBackground(Color.white);
        frame.add(buttons.get(45));
        buttons.get(35).setBounds(width, 400, 80, 80);
        buttons.get(35).setBackground(Color.white);
        frame.add(buttons.get(35));
        buttons.get(48).setBounds(width + 240, 320, 80, 80);
        buttons.get(48).setBackground(Color.white);
        frame.add(buttons.get(48));
        buttons.get(38).setBounds(width + 240, 400, 80, 80);
        buttons.get(38).setBackground(Color.white);
        frame.add(buttons.get(38));
        buttons.get(49).setBounds(width + 320, 320, 80, 80);
        buttons.get(49).setBackground(Color.white);
        frame.add(buttons.get(49));
        buttons.get(39).setBounds(width + 320, 400, 80, 80);
        buttons.get(39).setBackground(Color.white);
        frame.add(buttons.get(39));

        View_Board.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}