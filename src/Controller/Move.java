package Controller;

import Model.Board;
import Model.Player;
import Model.Player1;
import Model.Player2;
import View.View_Board;
import View.View_Info_Menu;
import View.View_Pieces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Move implements ActionListener {
    View_Info_Menu vim;
    public static int current_pos = -1, next_pos = -1;
    Icon arxiko_button;
    Icon teliko_button;


    /**
     * <b>Transformer(mutative)</b>: Diasozei to pioni pou thelei o paiktis an afto einai efikto <br />
     */
    void Diasosi() {
        int position, power;
        int thesi, temp_pos;  //thesi ston pinaka me ta kommatia pou einai ektos kai temp_pos deixnei an to keli einai idi gemato
        System.out.println("Give the power of the piece you want to rescue.");
        do {
            Scanner in = new Scanner(System.in);
            power = in.nextInt();
            if (power == -1) {
                System.out.println("You cannot rescue a trap Please give power again.");
            }
            thesi = -1;
            if (Player1.turn) {
                for (int i = 0; i < Controller.pieces_out_of_the_game_p1.size(); i++) {
                    if (Controller.pieces_out_of_the_game_p1.get(i).get_power() == power) {
                        thesi = i;
                        break;
                    }
                }
            } else {
                for (int i = 0; i < Controller.pieces_out_of_the_game_p2.size(); i++) {
                    if (Controller.pieces_out_of_the_game_p2.get(i).get_power() == power) {
                        thesi = i;
                        break;
                    }
                }
            }
            if (thesi == -1) {
                System.out.println("There is no piece with this power. Try again.");
            }

            System.out.println("Give the position of the piece.");
            do {
                Scanner in1 = new Scanner(System.in);
                position = in1.nextInt();
                if (position == 32 || position == 33 || position == 36 || position == 37 || position == 42 || position == 43 || position == 46 || position == 47) {
                    System.out.println("You cannot place a piece in forbidden area. Try another position.");
                    in1 = new Scanner(System.in);
                    position = in1.nextInt();
                }
            } while (position == 32 || position == 33 || position == 42 || position == 43 || position == 36 || position == 37 || position == 46 || position == 47);

            if (Board.brd[position] == 1 || Board.brd[position] == 2) {
                System.out.println("This position is already occupied. Try again and give the power again.");
                temp_pos = -1;
            } else {
                temp_pos = 1;
            }

        } while (power == -1 || thesi == -1 || temp_pos == -1);

        if (Player1.turn) {
            Controller.pieces_ingame_p1.add(Controller.pieces_out_of_the_game_p1.get(thesi));
            Controller.pieces_out_of_the_game_p1.remove(thesi);
            Controller.pieces_ingame_p1.get(Controller.pieces_ingame_p1.size() - 1).set_position(position);
            View_Board.buttons.get(position).setIcon(View_Pieces.find_img(Controller.pieces_ingame_p1.get(Controller.pieces_ingame_p1.size() - 1).get_power()));
            Controller.p1.setAixmalotiseis(Controller.p1.getAixmalotiseis() - 1);
        } else {
            Controller.pieces_ingame_p2.add(Controller.pieces_out_of_the_game_p2.get(thesi));
            Controller.pieces_out_of_the_game_p2.remove(thesi);
            Controller.pieces_ingame_p2.get(Controller.pieces_ingame_p2.size() - 1).set_position(position);
            View_Board.buttons.get(position).setIcon(View_Pieces.find_img(Controller.pieces_ingame_p2.get(Controller.pieces_ingame_p2.size() - 1).get_power()));
            Controller.p2.setAixmalotiseis(Controller.p2.getAixmalotiseis() - 1);
        }
        if (Player1.turn) Board.brd[position] = 1;
        else Board.brd[position] = 2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (vim == null) vim = new View_Info_Menu();
        if (Player1.turn) {
            for (int i = 0; i < 80; i++) {

                if (current_pos != -1 && next_pos != -1) {
                    current_pos = -1;
                    next_pos = -1;
                }

                if (e.getSource() == View_Board.buttons.get(i) && current_pos == -1) {      //briskoume to pioni pou tha kinithei
                    current_pos = i;

                } else if (e.getSource() == View_Board.buttons.get(i) && current_pos != -1) {       //briskoume tin thesi pou thelei na kinithei
                    next_pos = i;
                }

                if (current_pos != -1 && next_pos != -1) {
                    //briskoume tin thesi tou pioniou pou tha kinithei ston vector ton pionion pou einai sto paixnidi
                    // gia ton 1o paikti (gia na allaxoume stoixeia opos i thesi tou)
                    int cp = 0;
                    while (cp < Controller.pieces_ingame_p1.size() && Controller.pieces_ingame_p1.get(cp).get_position() != current_pos) {
                        cp++;
                    }
                    //briskoume tin thesi tou pioniou pou tha kinithei ston vector ton pionion pou einai sto paixnidi
                    // gia ton 2o paikti (gia na allaxoume stoixeia opos i thesi tou)
                    int np = 0;
                    while (np < Controller.pieces_ingame_p2.size() && Controller.pieces_ingame_p2.get(np).get_position() != next_pos) {
                        np++;
                    }

                    if (cp == Controller.pieces_ingame_p1.size()) {
                        System.out.println("You did not select a piece");
                        continue;
                    }

                    if (Controller.pieces_ingame_p1.get(cp).get_position() == next_pos) {
                        System.out.println("You cannot move to the same position");
                        continue;
                    }

                    if (!Controller.pieces_ingame_p1.get(cp).getValidMove(current_pos, next_pos, Controller.pieces_ingame_p1.get(cp).get_power())) {
                        System.out.println("You cannot move to this position");
                        continue;
                    }


                    //int cptemp = current_pos % 10;
                    int nptemp = next_pos % 10;

                    if (next_pos >= 30 && next_pos <= 49 && (nptemp == 2 || nptemp == 3 || nptemp == 6 || nptemp == 7))
                        continue;
                    else {
                        View_Board.buttons.get(current_pos).setBackground(Color.white);
                    }

                    if (np != Controller.pieces_ingame_p2.size()) {
                        if (Attack.result(Controller.pieces_ingame_p1.get(cp).get_power(), Controller.pieces_ingame_p2.get(np).get_power()) == 1) {
                            teliko_button = View_Board.buttons.get(next_pos).getIcon();
                            View_Board.buttons.get(next_pos).setIcon(View_Board.buttons.get(current_pos).getIcon());
                            View_Board.buttons.get(current_pos).setIcon(null);
                            View_Board.buttons.get(current_pos).setBackground(Color.white);
                            Controller.pieces_out_of_the_game_p2.add(Controller.pieces_ingame_p2.get(np));
                            Controller.pieces_ingame_p2.remove(np);
                            Controller.pieces_ingame_p1.get(cp).set_position(next_pos); // give the new position to the piece
                            Controller.p1.setAixmalotiseis(Controller.p1.getAixmalotiseis() + 1);
                            Board.brd[current_pos] = 0;
                            Board.brd[next_pos] = 1;
                            Controller.p1.setAttacks(Controller.p1.getAttacks() + 1);
                            Controller.p1.setSuccess_attacks_p1(Controller.p1.getSuccess_attack_p1() + 1);
                        } else if (Attack.result(Controller.pieces_ingame_p1.get(cp).get_power(), Controller.pieces_ingame_p2.get(np).get_power()) == 2) {
                            View_Board.buttons.get(current_pos).setIcon(null);
                            View_Board.buttons.get(current_pos).setBackground(Color.white);
                            Controller.pieces_out_of_the_game_p1.add(Controller.pieces_ingame_p1.get(cp));
                            Controller.pieces_ingame_p1.remove(cp);
                            Controller.p2.setAixmalotiseis(Controller.p2.getAixmalotiseis() + 1);
                            Board.brd[current_pos] = 0;
                            Controller.p1.setAttacks(Controller.p1.getAttacks() + 1);
                        } else if (Attack.result(Controller.pieces_ingame_p1.get(cp).get_power(), Controller.pieces_ingame_p2.get(np).get_power()) == -1) {
                            View_Board.buttons.get(current_pos).setIcon(null);
                            View_Board.buttons.get(next_pos).setIcon(null);
                            View_Board.buttons.get(current_pos).setBackground(Color.white);
                            View_Board.buttons.get(next_pos).setBackground(Color.white);
                            Controller.pieces_out_of_the_game_p1.add(Controller.pieces_ingame_p1.get(cp));
                            Controller.pieces_out_of_the_game_p2.add(Controller.pieces_ingame_p2.get(np));
                            Controller.pieces_ingame_p1.remove(cp);
                            Controller.pieces_ingame_p2.remove(np);
                            Controller.p1.setAixmalotiseis(Controller.p1.getAixmalotiseis() + 1);
                            Controller.p2.setAixmalotiseis(Controller.p2.getAixmalotiseis() + 1);
                            Board.brd[current_pos] = 0;
                            Board.brd[next_pos] = 0;
                            Controller.p1.setAttacks(Controller.p1.getAttacks() + 1);
                        }
                    } else {
                        arxiko_button = View_Board.buttons.get(current_pos).getIcon();     //kanoume swap tis eikones / periptosi pou den yparxei pioni stin thesi pou thelei na kinithei
                        teliko_button = View_Board.buttons.get(next_pos).getIcon();
                        View_Board.buttons.get(current_pos).setIcon(teliko_button);
                        View_Board.buttons.get(next_pos).setIcon(arxiko_button);
                        Controller.pieces_ingame_p1.get(cp).set_position(next_pos); // give the new position to the piece
                        Board.brd[current_pos] = 0;
                        Board.brd[next_pos] = 1;
                    }
                    // if the piece is not flag
                    if (Player1.turn && next_pos / 10 == 7 && Controller.pieces_out_of_the_game_p1.size() > 0 &&
                            Controller.pieces_ingame_p1.get(cp).getDiasoseis() < 1 && Controller.pieces_ingame_p1.get(cp).get_power() != 2
                            && current_pos < 70 && Controller.p1.getDiasoseis() < 2
                            && (np == Controller.pieces_ingame_p2.size() || Controller.pieces_ingame_p2.get(np).get_power() != -2) ){
                        Diasosi();
                        Controller.p1.setDiasoseis(Controller.p1.getDiasoseis() + 1);
                        Controller.pieces_ingame_p1.get(cp).setDiasoseis(Controller.pieces_ingame_p1.get(cp).getDiasoseis() + 1);
                    }
                }
                int j;
                if (next_pos != -1) {
                    Player1.turn = false;
                    Player2.turn = true;
                    vim.update();
                    for (int v = 0; v < 80; v++) {
                        if (Board.brd[v] == 1) {
                            View_Board.buttons.get(v).setIcon(View_Pieces.img[0]);
                        }
                        if (Board.brd[v] == 2) {
                            for (j = 0; j < Controller.pieces_ingame_p2.size(); j++) {
                                if (Controller.pieces_ingame_p2.get(j).get_position() == v) {
                                    break;
                                }
                            }

                            View_Board.buttons.get(v).setIcon(new ImageIcon(View_Pieces.find_img(Controller.pieces_ingame_p2.get(j).get_power()).getImage()));
                        }
                    }
                }
            }
        } else {    //if it is player 2's turn
            for (int i = 0; i < 80; i++) {
                if (current_pos != -1 && next_pos != -1) {
                    current_pos = -1;
                    next_pos = -1;
                }

                if (e.getSource() == View_Board.buttons.get(i) && current_pos == -1) {
                    //briskoume to pioni pou tha kinithei
                    current_pos = i;

                } else if (e.getSource() == View_Board.buttons.get(i) && current_pos != -1) {       //briskoume tin thesi pou thelei na kinithei
                    next_pos = i;
                }

                if (current_pos != -1 && next_pos != -1) {
                    //briskoume tin thesi tou pioniou pou tha kinithei ston vecto ton pionion pou einai sto paixnidi gia ton 2o paikti (gia na allaxoume stoixeia opos i thesi tou)
                    int cp = 0;
                    while (cp < Controller.pieces_ingame_p2.size() && Controller.pieces_ingame_p2.get(cp).get_position() != current_pos) {
                        cp++;
                    }
                    int np = 0;
                    while (np < Controller.pieces_ingame_p1.size() && Controller.pieces_ingame_p1.get(np).get_position() != next_pos) {
                        np++;
                    }

                    if (cp == Controller.pieces_ingame_p2.size()) {
                        System.out.println("You did not select a piece");
                        continue;
                    }

                    if (Controller.pieces_ingame_p2.get(cp).get_position() == next_pos) {
                        System.out.println("You cannot move to the same position");
                        continue;
                    }

                    if (!Controller.pieces_ingame_p2.get(cp).getValidMove(current_pos, next_pos, Controller.pieces_ingame_p2.get(cp).get_power())) {
                        System.out.println("You cannot move to this position");
                        continue;
                    }


                    //int cptemp = current_pos % 10;
                    int nptemp = next_pos % 10;

                    if (next_pos >= 30 && next_pos <= 49 && (nptemp == 2 || nptemp == 3 || nptemp == 6 || nptemp == 7))
                        continue;
                    else {
                        View_Board.buttons.get(current_pos).setBackground(Color.white);
                    }

                    if (np != Controller.pieces_ingame_p1.size()) {
                        if (Attack.result(Controller.pieces_ingame_p2.get(cp).get_power(), Controller.pieces_ingame_p1.get(np).get_power()) == 1) {
                            teliko_button = View_Board.buttons.get(next_pos).getIcon();
                            View_Board.buttons.get(next_pos).setIcon(View_Board.buttons.get(current_pos).getIcon());
                            View_Board.buttons.get(current_pos).setIcon(null);
                            View_Board.buttons.get(current_pos).setBackground(Color.white);
                            Controller.pieces_out_of_the_game_p1.add(Controller.pieces_ingame_p1.get(np));
                            Controller.pieces_ingame_p1.remove(np);
                            Controller.pieces_ingame_p2.get(cp).set_position(next_pos); // give the new position to the piece
                            Controller.p2.setAixmalotiseis(Controller.p1.getAixmalotiseis() + 1);
                            Board.brd[next_pos] = 2;
                            Board.brd[current_pos] = 0;
                            Controller.p2.setAttacks(Controller.p2.getAttacks() + 1);
                            Controller.p2.setSuccess_attacks_p2(Controller.p2.getSuccess_attacks_p2() + 1);

                        } else if (Attack.result(Controller.pieces_ingame_p2.get(cp).get_power(), Controller.pieces_ingame_p1.get(np).get_power()) == 2) {
                            View_Board.buttons.get(current_pos).setIcon(null);
                            View_Board.buttons.get(current_pos).setBackground(Color.white);
                            Controller.pieces_out_of_the_game_p2.add(Controller.pieces_ingame_p2.get(cp));
                            Controller.pieces_ingame_p2.remove(cp);
                            Controller.p1.setAixmalotiseis(Controller.p1.getAixmalotiseis() + 1);
                            Board.brd[next_pos] = 1;
                            Board.brd[current_pos] = 0;
                            Controller.p2.setAttacks(Controller.p2.getAttacks() + 1);
                        } else if (Attack.result(Controller.pieces_ingame_p2.get(cp).get_power(), Controller.pieces_ingame_p1.get(np).get_power()) == -1) {
                            View_Board.buttons.get(current_pos).setIcon(null);
                            View_Board.buttons.get(next_pos).setIcon(null);
                            View_Board.buttons.get(current_pos).setBackground(Color.white);
                            View_Board.buttons.get(next_pos).setBackground(Color.white);
                            Controller.pieces_out_of_the_game_p2.add(Controller.pieces_ingame_p2.get(cp));
                            Controller.pieces_out_of_the_game_p1.add(Controller.pieces_ingame_p1.get(np));
                            Controller.pieces_ingame_p2.remove(cp);
                            Controller.pieces_ingame_p1.remove(np);
                            Controller.p1.setAixmalotiseis(Controller.p1.getAixmalotiseis() + 1);
                            Controller.p2.setAixmalotiseis(Controller.p2.getAixmalotiseis() + 1);
                            Board.brd[current_pos] = 0;
                            Board.brd[next_pos] = 0;
                            Controller.p2.setAttacks(Controller.p2.getAttacks() + 1);
                        }
                    } else {
                        arxiko_button = View_Board.buttons.get(current_pos).getIcon();     //kanoume swap tis eikones / periptosi pou den yparxei pioni stin thesi pou thelei na kinithei
                        teliko_button = View_Board.buttons.get(next_pos).getIcon();
                        View_Board.buttons.get(current_pos).setIcon(teliko_button);
                        View_Board.buttons.get(next_pos).setIcon(arxiko_button);
                        Controller.pieces_ingame_p2.get(cp).set_position(next_pos); // give the new position to the piece
                        Board.brd[next_pos] = 2;
                        Board.brd[current_pos] = 0;
                    }

                    if (Player2.turn && next_pos / 10 == 0 && Controller.pieces_out_of_the_game_p2.size() > 0 &&
                            Controller.pieces_ingame_p2.get(cp).getDiasoseis() < 1 && Controller.pieces_ingame_p2.get(cp).get_power() != 2
                            && current_pos > 10 && Controller.p2.getDiasoseis() < 2
                            && (np == Controller.pieces_ingame_p1.size() || Controller.pieces_ingame_p1.get(np).get_power() != -2) ){
                        Diasosi();
                        Controller.p2.setDiasoseis(Controller.p2.getDiasoseis() + 1);
                        Controller.pieces_ingame_p2.get(cp).setDiasoseis(Controller.pieces_ingame_p2.get(cp).getDiasoseis() + 1);
                    }

                    int j;
                    if (next_pos != -1) {
                        Player1.turn = true;
                        Player2.turn = false;
                        Player.round++;
                        vim.update();
                        for (int v = 0; v < 80; v++) {
                            if (Board.brd[v] == 2) {
                                View_Board.buttons.get(v).setIcon(View_Pieces.img[13]);
                            }
                            if (Board.brd[v] == 1) {
                                for (j = 0; j < Controller.pieces_ingame_p1.size(); j++) {
                                    if (Controller.pieces_ingame_p1.get(j).get_position() == v) {
                                        break;
                                    }
                                }
                                View_Board.buttons.get(v).setIcon(new ImageIcon(View_Pieces.find_img(Controller.pieces_ingame_p1.get(j).get_power()).getImage()));
                            }
                        }
                    }
                }
            }
            if (Controller.end_game()) {
                System.out.println("Game Over");
                System.exit(0);
            }
        }
    }
}