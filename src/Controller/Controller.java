package Controller;

import Model.Board;
import Model.Piece.ImmovablePiece.Flag;
import Model.Piece.ImmovablePiece.Trap;
import Model.Piece.MoveablePiece.*;
import Model.Piece.MoveablePiece.SpecialMoveablePiece.Dwarf;
import Model.Player1;
import Model.Player2;
import View.View_Board;

import java.util.ArrayList;

/**
 * Controller is the master of the game and controls all the operations executed
 *
 * @author csd4988
 * @version 1.0
 */
public class Controller {

    public static boolean original_rules;
    public static ArrayList<Piece> pieces_ingame_p1 = new ArrayList<Piece>();
    public static ArrayList<Piece> pieces_ingame_p2 = new ArrayList<Piece>();
    public static ArrayList<Piece> pieces_out_of_the_game_p1 = new ArrayList<Piece>();
    public static ArrayList<Piece> pieces_out_of_the_game_p2 = new ArrayList<Piece>();

    public static Player1 p1;
    public static Player2 p2;

    /**
     * Cosntructor
     * <b>Postcondition:</b> player1, player2 and board have been created</p>
     */
    public Controller() {
        p1 = new Player1(true);
        p2 = new Player2(false);
        int[] brd = new int[80];
        new Board(brd);
        StartGame();

        new View.Display_Pieces();


        Move move = new Move();
        for (int i = 0; i < 80; i++)
            View_Board.buttons.get(i).addActionListener(move);


    }


    /**
     * <b>Transformer</b>: Creates a new Board with true or false if the block is full and new instances of pieces
     * Board show us if a block in the game (like (1,1) and (5,3) has already a piece on it<br />
     * <b>Postcondition:</b> Creates a new Board which represents the positions of the pieces in the game and creates
     * new pieces
     */
    void StartGame() {
        int i;
        boolean temp;

        //ftiaxnoume ta katallila pionia
        BeastRider[] beastrider = new BeastRider[6];
        Dwarf[] dwarf = new Dwarf[10];
        Dragon[] dragon = new Dragon[2];
        Elf[] elf = new Elf[4];
        Knight[] knight = new Knight[4];
        LavaBeast[] lavabeast = new LavaBeast[2];
        Yeti[] yeti = new Yeti[2];
        Mage[] mage = new Mage[2];
        Scout[] scout = new Scout[8];
        Slayer[] slayer = new Slayer[2];
        Sorceress[] sorceress = new Sorceress[4];
        Trap[] trap = new Trap[12];
        Flag[] flag = new Flag[2];


        //ftiaxnoume ta pionia tou paikti 1 stis katalliles theseis
        int pos;
        for (i = 0; i < 30; i++) {
            do {
                temp = false;
                pos = 1 + (int) (Math.random() * 30);
                if (Board.brd[pos - 1] == 1) {
                    temp = true;     //brethike oti i thesi einai gemati
                }
            } while (temp);

            Board.brd[pos - 1] = 1;  //to keli einai pleon gemato

            if (i < 1) {
                dragon[0] = new Dragon(1, pos - 1);
                pieces_ingame_p1.add(dragon[i]);
            } else if (i < 2) {
                mage[i - 1] = new Mage(1, pos - 1);
                pieces_ingame_p1.add(mage[i - 1]);
            } else if (i < 4) {
                knight[i - 2] = new Knight(1, pos - 1);
                pieces_ingame_p1.add(knight[i - 2]);
            } else if (i < 7) {
                beastrider[i - 4] = new BeastRider(1, pos - 1);
                pieces_ingame_p1.add(beastrider[i - 4]);
            } else if (i < 9) {
                sorceress[i - 7] = new Sorceress(1, pos - 1);
                pieces_ingame_p1.add(sorceress[i - 7]);
            } else if (i < 11) {
                lavabeast[i - 9] = new LavaBeast(1, pos - 1);
                pieces_ingame_p1.add(lavabeast[i - 9]);
            } else if (i < 13) {
                elf[i - 11] = new Elf(1, pos - 1);
                pieces_ingame_p1.add(elf[i - 11]);
            } else if (i < 18) {
                dwarf[i - 13] = new Dwarf(1, pos - 1);
                pieces_ingame_p1.add(dwarf[i - 13]);
            } else if (i < 22) {
                scout[i - 18] = new Scout(1, pos - 1);
                pieces_ingame_p1.add(scout[i - 18]);
            } else if (i < 23) {
                slayer[i - 22] = new Slayer(1, pos - 1);
                pieces_ingame_p1.add(slayer[i - 22]);
            } else if (i < 29) {
                trap[i - 23] = new Trap(1, pos - 1);
                pieces_ingame_p1.add(trap[i - 23]);
            } else {
                flag[i - 29] = new Flag(1, pos - 1);
                pieces_ingame_p1.add(flag[i - 29]);
            }
        }

        //ftiaxnoume ta pionia tou paikti 2 stis katalliles theseis
        for (i = 50; i < 80; i++) {
            do {
                temp = false;
                pos = 51 + (int) (Math.random() * 30);
                if (Board.brd[pos - 1] == 2) {
                    temp = true;     //brethike oti i thesi einai gemati apo ton 1
                }
            } while (temp);

            Board.brd[pos - 1] = 2;  //to keli einai pleon gemato apo pioni tou paikti 2

            if (i < 51) {
                dragon[i - 50 + 1] = new Dragon(2, pos - 1);
                pieces_ingame_p2.add(dragon[i - 50 + 1]);
            } else if (i < 52) {
                mage[i - 51 + 1] = new Mage(2, pos - 1);
                pieces_ingame_p2.add(mage[i - 51 + 1]);
            } else if (i < 54) {
                knight[i - 52 + 2] = new Knight(2, pos - 1);
                pieces_ingame_p2.add(knight[i - 52 + 2]);
            } else if (i < 57) {
                beastrider[i - 54 + 3] = new BeastRider(2, pos - 1);
                pieces_ingame_p2.add(beastrider[i - 54 + 3]);
            } else if (i < 59) { //-1
                sorceress[i - 57 + 2] = new Sorceress(2, pos - 1);
                pieces_ingame_p2.add(sorceress[i - 57 + 2]);
            } else if (i < 61) {
                yeti[i - 59] = new Yeti(2, pos - 1);
                pieces_ingame_p2.add(yeti[i - 59]);
            } else if (i < 63) {
                elf[i - 61 + 2] = new Elf(2, pos - 1);
                pieces_ingame_p2.add(elf[i - 61 + 2]);
            } else if (i < 68) {
                dwarf[i - 63 + 5] = new Dwarf(2, pos - 1);
                pieces_ingame_p2.add(dwarf[i - 63 + 5]);
            } else if (i < 72) {
                scout[i - 68 + 4] = new Scout(2, pos - 1);
                pieces_ingame_p2.add(scout[i - 68 + 4]);
            } else if (i < 73) {
                slayer[1] = new Slayer(2, pos - 1);
                pieces_ingame_p2.add(slayer[i - 72 + 1]);
            } else if (i < 79) {
                trap[i - 73 + 6] = new Trap(2, pos - 1);
                pieces_ingame_p2.add(trap[i - 73 + 6]);
            } else {
                flag[1] = new Flag(2, pos - 1);
                pieces_ingame_p2.add(flag[i - 79 + 1]);
            }
        }
    }

    /**
     * <b>Accessor</b>: Check if the game is over
     *
     * @return true if the game is over, false otherwise
     */
    public static boolean end_game() {
        int i;
        int temp_p1 = 0, temp_p2 = 0;
        for (Piece value : pieces_ingame_p1) {          //elegxei an i flag tou paikti 1 einai mesa sto paixnidi
            if (value.get_power() == -2) {
                temp_p1 = 1;
                break;
            }
        }
        for (Piece piece : pieces_ingame_p2) {
            if (piece.get_power() == -2) {              //elegxei an i flag tou paikti 2 einai mesa sto paixnidi
                temp_p2 = 1;
                break;
            }
        }

        if (temp_p1 == 1 && temp_p2 == 0) {
            System.out.println("Player 1 wins!");     //an i flag tou paikti 1 einai mesa sto paixnidi kai i flag tou paikti 2 den einai tote o paikths 1 kerdizei
            return true;
        } else if (temp_p1 == 0 && temp_p2 == 1) {
            System.out.println("Player 2 wins!");       //an i flag tou paikti 2 einai mesa sto paixnidi kai i flag tou paikti 1 den einai tote o paikths 2 kerdizei
            return true;
        }

        temp_p1 = 0;
        for (Piece piece : pieces_ingame_p1) {
            if (piece.get_power() != -1 && piece.get_power() != -2) {    //elegxei an to mono pou exei meinei einai flag kai traps gia ton player 1
                temp_p1 = 1;
                break;
            }
        }
        if (temp_p1 == 1) {
            temp_p2 = 0;
            for (Piece piece : pieces_ingame_p2) {
                if (piece.get_power() != -1 && piece.get_power() != -2) {    //elegxei an to mono pou exei meinei einai flag kai traps gia ton player 2
                    temp_p2 = 1;
                    break;
                }
            }
        }

        if (temp_p1 == 0) {
            System.out.println("Player 2 wins because player 1 has only traps and flag!");
            return true;
        } else if (temp_p2 == 0) {
            System.out.println("Player 1 wins because player 2 has only traps and flag!");
            return true;
        }

        temp_p1 = 0;
        temp_p2 = 0;
        for (i = 0; i < pieces_ingame_p1.size(); i++) {
            for (int v = 0; v < 80; v++) {
                if (Piece.getValidMove(Controller.pieces_ingame_p1.get(i).get_position(), v, Controller.pieces_ingame_p1.get(i).get_power())) {     //elegxei an o paikths 1 mporei na kanei kapoio kinhsh
                    temp_p1 = 1;
                }
            }
        }
        for (i = 0; i < pieces_ingame_p2.size(); i++) {
            for (int j = 0; j < 80; j++) {
                if (Piece.getValidMove(Controller.pieces_ingame_p2.get(i).get_position(), j, Controller.pieces_ingame_p2.get(i).get_power())) {     //elegxei an o paikths 2 mporei na kanei kapoio kinhsh
                    temp_p2 = 1;
                }
            }
        }

        if (temp_p1 == 0) {
            System.out.println("Player 1 wins because player 2 has no pieces to move!");
            return true;
        } else if (temp_p2 == 0) {
            System.out.println("Player 2 wins because player 1 has no pieces to move!");
            return true;
        }

        return false;
    }
}