package View;

import javax.swing.*;

public class Display_Pieces extends JFrame {
    /**
     * <b>constructor</b>: Set the borders of the main window and place the piece in the board <br />
     * <b>postconditions</b>: Creates a new Window
     */
    public Display_Pieces() {
        View_Pieces vp = new View_Pieces();
        View_Board.frame.add(vp);   //Add the piece in the board

        View_Board.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);   //set the window to full screen

        View_Board.frame.setVisible(true);  //make the window visible

        View_Board.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //close the window when the user clicks the X button
    }
}