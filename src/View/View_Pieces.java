package View;

import Model.Player1;
import Controller.*;
import Model.Player2;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class View_Pieces extends JButton {
    public static ImageIcon[] img = new ImageIcon[26];
    private static final int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2;

    public View_Pieces() {
        img[0] = new ImageIcon("..\\Stratego_Java\\images\\RedPieces\\redHidden.png");
        img[1] = new ImageIcon("..\\Stratego_Java\\images\\RedPieces\\dragonR.png");
        img[2] = new ImageIcon("..\\Stratego_Java\\images\\RedPieces\\dwarfR.png");
        img[3] = new ImageIcon("..\\Stratego_Java\\images\\RedPieces\\elfR.png");
        img[4] = new ImageIcon("..\\Stratego_Java\\images\\RedPieces\\beastRiderR.png");
        img[5] = new ImageIcon("..\\Stratego_Java\\images\\RedPieces\\flagR.png");
        img[6] = new ImageIcon("..\\Stratego_Java\\images\\RedPieces\\knightR.png");
        img[7] = new ImageIcon("..\\Stratego_Java\\images\\RedPieces\\lavaBeast.png");
        img[8] = new ImageIcon("..\\Stratego_Java\\images\\RedPieces\\mageR.png");
        img[9] = new ImageIcon("..\\Stratego_Java\\images\\RedPieces\\scoutB.png");
        img[10] = new ImageIcon("..\\Stratego_Java\\images\\RedPieces\\slayerR.png");
        img[11] = new ImageIcon("..\\Stratego_Java\\images\\RedPieces\\sorceressR.png");
        img[12] = new ImageIcon("..\\Stratego_Java\\images\\RedPieces\\trapR.png");

        img[13] = new ImageIcon("..\\Stratego_Java\\images\\bluePieces\\blueHidden.png");
        img[14] = new ImageIcon("..\\Stratego_Java\\images\\bluePieces\\dragonB.png");
        img[15] = new ImageIcon("..\\Stratego_Java\\images\\bluePieces\\dwarfB.png");
        img[16] = new ImageIcon("..\\Stratego_Java\\images\\bluePieces\\elfB.png");
        img[17] = new ImageIcon("..\\Stratego_Java\\images\\bluePieces\\beastRiderB.png");
        img[18] = new ImageIcon("..\\Stratego_Java\\images\\bluePieces\\flagB.png");
        img[19] = new ImageIcon("..\\Stratego_Java\\images\\bluePieces\\knightB.png");
        img[20] = new ImageIcon("..\\Stratego_Java\\images\\bluePieces\\yeti.png");
        img[21] = new ImageIcon("..\\Stratego_Java\\images\\bluePieces\\mageB.png");
        img[22] = new ImageIcon("..\\Stratego_Java\\images\\bluePieces\\scoutB.png");
        img[23] = new ImageIcon("..\\Stratego_Java\\images\\bluePieces\\slayerB.png");
        img[24] = new ImageIcon("..\\Stratego_Java\\images\\bluePieces\\sorceressB.png");
        img[25] = new ImageIcon("..\\Stratego_Java\\images\\bluePieces\\trapB.png");

        fillpieces_red();
        blueS();
    }

    /**
     * <b>Transformer:</b> Fills the red pieces <br />
     */
    public void fillpieces_red() {
        int current_pos, posx, posy, i, power, pos;
        for (i = 0; i < 30; i++) {
            current_pos = Controller.pieces_ingame_p1.get(i).get_position();
            posx = positiontox(current_pos);
            posy = positiontoy(current_pos);
            pos = Controller.pieces_ingame_p1.get(i).get_position();

            power = Controller.pieces_ingame_p1.get(i).get_power();

            ImageIcon itemp = find_img(power);

            View_Board.frame.setLayout(null);

            View_Board.buttons.get(pos).setIcon(new ImageIcon(itemp.getImage()));
            View_Board.buttons.get(current_pos).setBounds(posx, posy, 80, 80);

            View_Board.frame.add(View_Board.buttons.get(current_pos));
        }
    }

    /**
     * <b>Transformer:</b> Fills the board with blue S (hidden) <br />
     */
    public void blueS() {
        View_Board.buttons.add(new JButton());

        View_Board.frame.setLayout(null);

        View_Board.buttons.set(50, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(50).setBounds(width - 400, 240, 80, 80);
        View_Board.buttons.set(51, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(51).setBounds(width - 320, 240, 80, 80);
        View_Board.buttons.set(52, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(52).setBounds(width - 240, 240, 80, 80);
        View_Board.buttons.set(53, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(53).setBounds(width - 160, 240, 80, 80);
        View_Board.buttons.set(54, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(54).setBounds(width - 80, 240, 80, 80);
        View_Board.buttons.set(55, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(55).setBounds(width, 240, 80, 80);
        View_Board.buttons.set(56, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(56).setBounds(width + 80, 240, 80, 80);
        View_Board.buttons.set(57, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(57).setBounds(width + 160, 240, 80, 80);
        View_Board.buttons.set(58, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(58).setBounds(width + 240, 240, 80, 80);
        View_Board.buttons.set(59, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(59).setBounds(width + 320, 240, 80, 80);

        View_Board.buttons.set(60, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(60).setBounds(width - 400, 160, 80, 80);
        View_Board.buttons.set(61, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(61).setBounds(width - 320, 160, 80, 80);
        View_Board.buttons.set(62, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(62).setBounds(width - 240, 160, 80, 80);
        View_Board.buttons.set(63, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(63).setBounds(width - 160, 160, 80, 80);
        View_Board.buttons.set(64, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(64).setBounds(width - 80, 160, 80, 80);
        View_Board.buttons.set(65, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(65).setBounds(width, 160, 80, 80);
        View_Board.buttons.set(66, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(66).setBounds(width + 80, 160, 80, 80);
        View_Board.buttons.set(67, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(67).setBounds(width + 160, 160, 80, 80);
        View_Board.buttons.set(68, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(68).setBounds(width + 240, 160, 80, 80);
        View_Board.buttons.set(69, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(69).setBounds(width + 320, 160, 80, 80);

        View_Board.buttons.set(70, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(70).setBounds(width - 400, 80, 80, 80);
        View_Board.buttons.set(71, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(71).setBounds(width - 320, 80, 80, 80);
        View_Board.buttons.set(72, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(72).setBounds(width - 240, 80, 80, 80);
        View_Board.buttons.set(73, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(73).setBounds(width - 160, 80, 80, 80);
        View_Board.buttons.set(74, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(74).setBounds(width - 80, 80, 80, 80);
        View_Board.buttons.set(75, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(75).setBounds(width, 80, 80, 80);
        View_Board.buttons.set(76, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(76).setBounds(width + 80, 80, 80, 80);
        View_Board.buttons.set(77, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(77).setBounds(width + 160, 80, 80, 80);
        View_Board.buttons.set(78, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(78).setBounds(width + 240, 80, 80, 80);
        View_Board.buttons.set(79, new JButton(new ImageIcon(img[13].getImage())));
        View_Board.buttons.get(79).setBounds(width + 320, 80, 80, 80);

        View_Board.frame.add(View_Board.buttons.get(50));
        View_Board.frame.add(View_Board.buttons.get(51));
        View_Board.frame.add(View_Board.buttons.get(52));
        View_Board.frame.add(View_Board.buttons.get(53));
        View_Board.frame.add(View_Board.buttons.get(54));
        View_Board.frame.add(View_Board.buttons.get(55));
        View_Board.frame.add(View_Board.buttons.get(56));
        View_Board.frame.add(View_Board.buttons.get(57));
        View_Board.frame.add(View_Board.buttons.get(58));
        View_Board.frame.add(View_Board.buttons.get(59));

        View_Board.frame.add(View_Board.buttons.get(60));
        View_Board.frame.add(View_Board.buttons.get(61));
        View_Board.frame.add(View_Board.buttons.get(62));
        View_Board.frame.add(View_Board.buttons.get(63));
        View_Board.frame.add(View_Board.buttons.get(64));
        View_Board.frame.add(View_Board.buttons.get(65));
        View_Board.frame.add(View_Board.buttons.get(66));
        View_Board.frame.add(View_Board.buttons.get(67));
        View_Board.frame.add(View_Board.buttons.get(68));
        View_Board.frame.add(View_Board.buttons.get(69));

        View_Board.frame.add(View_Board.buttons.get(70));
        View_Board.frame.add(View_Board.buttons.get(71));
        View_Board.frame.add(View_Board.buttons.get(72));
        View_Board.frame.add(View_Board.buttons.get(73));
        View_Board.frame.add(View_Board.buttons.get(74));
        View_Board.frame.add(View_Board.buttons.get(75));
        View_Board.frame.add(View_Board.buttons.get(76));
        View_Board.frame.add(View_Board.buttons.get(77));
        View_Board.frame.add(View_Board.buttons.get(78));
        View_Board.frame.add(View_Board.buttons.get(79));
    }



    /**
     * Converts the position of the image in Board (e.g. 0,2,3,...,79) to x-axis
     */

    public static int positiontox(int pos) {
        int posx = -1;
        if (pos % 10 == 0)
            posx = width - 400;
        else if (pos % 10 == 1)
            posx = width - 320;
        else if (pos % 10 == 2)
            posx = width - 240;
        else if (pos % 10 == 3)
            posx = width - 160;
        else if (pos % 10 == 4)
            posx = width - 80;
        else if (pos % 10 == 5)
            posx = width;
        else if (pos % 10 == 6)
            posx = width + 80;
        else if (pos % 10 == 7)
            posx = width + 160;
        else if (pos % 10 == 8)
            posx = width + 240;
        else if (pos % 10 == 9)
            posx = width + 320;

        return posx;
    }

    /**
     * Converts the position of the image in Board (e.g. 0,2,3,...,79) to y-axis
     */

    public static int positiontoy(int pos) {
        int posy = -1;
        if (pos >= 0 && pos < 10) posy = 640;
        else if (pos < 20) posy = 560;
        else if (pos < 30) posy = 480;
        else if (pos < 40) posy = 400;
        else if (pos < 50) posy = 320;
        else if (pos < 60) posy = 240;
        else if (pos < 70) posy = 160;
        else if (pos < 80) posy = 80;

        return posy;
    }

    /**
     * Relate the power of the element to the right image
     *
     * @return the integer of the image in vector img
     */

    public static ImageIcon find_img(int power) {
        ImageIcon itemp = img[0];
        if (power == -2 && Player1.turn) itemp = img[5];   //FLAGR
        else if (power == -2 && Player2.turn) itemp = img[18];   //FLAGB

        else if (power == -1 && Player1.turn) itemp = img[12]; //TRAPR
        else if (power == -1 && Player2.turn) itemp = img[25]; //TRAPB

        else if (power == 1 && Player1.turn) itemp = img[10]; //SLAYERR
        else if (power == 1 && Player2.turn) itemp = img[23];  //SLAYERB

        else if (power == 2 && Player1.turn) itemp = img[9]; //SCOUTR
        else if (power == 2 && Player2.turn) itemp = img[22]; //SCOUTB

        else if (power == 3 && Player1.turn) itemp = img[2]; //DWARFR
        else if (power == 3 && Player2.turn) itemp = img[15]; //DWARFB

        else if (power == 4 && Player1.turn) itemp = img[3]; //ELFR
        else if (power == 4 && Player2.turn) itemp = img[16];

        else if (power == 5 && Player1.turn) itemp = img[7]; //LAVA BEAST
        else if (power == 5 && Player2.turn) itemp = img[20]; //YETI

        else if (power == 6 && Player1.turn) itemp = img[11]; //SORCERESSR
        else if (power == 6 && Player2.turn) itemp = img[24];

        else if (power == 7 && Player1.turn) itemp = img[4]; //BEAST RIDERR
        else if (power == 7 && Player2.turn) itemp = img[17];

        else if (power == 8 && Player1.turn) itemp = img[6]; //KNIGHTR
        else if (power == 8 && Player2.turn) itemp = img[19];

        else if (power == 9 && Player1.turn) itemp = img[8]; //MAGER
        else if (power == 9 && Player2.turn) itemp = img[21];

        else if (power == 10 && Player1.turn) itemp = img[1]; //ARCHERR
        else if (power == 10 && Player2.turn) itemp = img[14];


        return itemp;
    }
}