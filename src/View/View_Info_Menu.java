package View;

import Controller.Controller;
import Model.Player;
import Model.Player1;
import Model.Player2;

import java.awt.*;
import javax.swing.*;


/**
 * @author dxanthak - mountanton
 * @version 1.0
 */
public class View_Info_Menu extends JFrame {
    public JPanel panel = new JPanel();

    /**
     * <b>constructor</b>: Creates a new Menu Window  <br />
     * <b>postconditions</b>: Creates a new Menu Window
     * starting a new Menu
     */
    public View_Info_Menu() {
        setTitle("Info Menu");

        setSize(300, 950);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Ενδεικτικοί κανόνες");
        Font font = new Font("Ενδικτικοί κανόνες", Font.BOLD, 21);
        label.setFont(font);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);


        JPanel greyPanel1 = new JPanel();
        greyPanel1.setBackground(Color.GRAY);
        greyPanel1.setPreferredSize(new Dimension(200, 100));
        panel.add(greyPanel1);


        JLabel label1 = new JLabel("Στατιστικά");
        Font font1 = new Font("Στατιστικά", Font.BOLD, 21);
        label1.setFont(font1);
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label1);


        JPanel greyPanel2 = new JPanel();
        greyPanel2.setBackground(Color.GRAY);
        greyPanel2.setPreferredSize(new Dimension(200, 100));


        JLabel label3;
        if (Player1.turn) label3 = new JLabel("Player 1 turn");
        else label3 = new JLabel("Player 2 turn");
        greyPanel1.add(label3);
        Font font3 = new Font("turn", Font.BOLD, 17);
        label3.setFont(font3);
        panel.add(greyPanel2);

        JLabel label2;
        if (Player1.turn)
            label2 = new JLabel("Ποσοστό επιτυχ. επίθεσης: " + Controller.p1.getPercent_success_attack_p1(Controller.p1.getSuccess_attack_p1(), Controller.p1.getAttacks()) + "%");
        else
            label2 = new JLabel("Ποσοστό επιτυχ. επίθεσης: " + Controller.p2.getPercent_success_attack_p2(Controller.p2.getSuccess_attacks_p2(), Controller.p2.getAttacks()) + "%");

        greyPanel2.add(label2);
        Font font2 = new Font("percent", Font.BOLD, 17);
        label2.setFont(font2);

        panel.add(greyPanel2);

        JLabel label4;
        if (Player1.turn) label4 = new JLabel("Διασώσεις: " + Controller.p1.getDiasoseis());
        else label4 = new JLabel("Διασώσεις: " + Controller.p2.getDiasoseis());
        greyPanel2.add(label4);
        Font font4 = new Font("diasoseis", Font.BOLD, 17);
        label4.setFont(font4);
        JLabel label7 = new JLabel("Γύρος: " + Player.round);
        Font font7 = new Font("Γύρος", Font.BOLD, 17);
        label7.setFont(font7);
        greyPanel2.add(label7);
        panel.add(greyPanel2);


        JLabel label5 = new JLabel("Αιχμαλωτίσεις");
        Font font5 = new Font("Αιχμαλωτίσεις", Font.BOLD, 21);
        label5.setFont(font5);
        label5.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label5);

        JPanel greyPanel3 = new JPanel();
        greyPanel3.setBackground(Color.GRAY);
        greyPanel3.setPreferredSize(new Dimension(200, 100));
        panel.add(greyPanel3);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 30));
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3, 10));
        if (Controller.pieces_out_of_the_game_p1.size() > 0 && Player2.turn) {
            Player1.turn = true;            // gia na bgalei sosta to xroma sto find_img
            Player2.turn = false;

            for (int i = 0; i < Controller.pieces_out_of_the_game_p1.size(); i++) {
                panel1.add(new JLabel(new ImageIcon(View_Pieces.find_img(Controller.pieces_out_of_the_game_p1.get(i).get_power()).getImage())));
            }

            if (Controller.pieces_out_of_the_game_p1.size() > 0) greyPanel3.add(panel1);

            Player1.turn = false;           // gia na sinexisei sosta to programma
            Player2.turn = true;

        } else if (Controller.pieces_out_of_the_game_p2.size() > 0 && Player1.turn) {
            Player1.turn = false;       // gia na bgalei sosta to xroma sto find_img
            Player2.turn = true;

            for (int i = 0; i < Controller.pieces_out_of_the_game_p2.size(); i++) {
                panel2.add(new JLabel(new ImageIcon(View_Pieces.find_img(Controller.pieces_out_of_the_game_p2.get(i).get_power()).getImage())));
            }

            if (Controller.pieces_out_of_the_game_p2.size() > 0) greyPanel3.add(panel2);

            Player1.turn = true;        // gia na sinexisei sosta to programma
            Player2.turn = false;
        }

        JLabel label6;
        if (Player1.turn) label6 = new JLabel("Συνολικές Αιχμαλωτίσεις: " + Controller.p1.getAixmalotiseis());
        else label6 = new JLabel("Συνολικές Αιχμαλωτίσεις: " + Controller.p2.getAixmalotiseis());
        label6.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        greyPanel3.add(label6);

        add(panel);

        setVisible(true);
    }

    /**
     * This method is called whenever the info menu has to change.
     */
    public void update() {
        //this.repaint();
        this.dispose();
        new View_Info_Menu();
    }
}