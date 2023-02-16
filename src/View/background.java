package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class background extends JFrame {
    /**
     * <b>constructor</b>: Set the borders of the main window and place the piece in the board <br />
     * <b>postconditions</b>: Creates a new Window
     */
    public background() {
        Image backgroundImage;
        try {
            backgroundImage = ImageIO.read(new File("..\\Stratego_Java\\images\\background.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JLabel label = new JLabel(new ImageIcon(backgroundImage));
        View_Board.frame.setContentPane(label);

        View_Board.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
