package Model.Piece.MoveablePiece.SpecialMoveablePiece;

import Controller.Controller;
import Model.Board;
import Model.Piece.MoveablePiece.Piece;
import Model.Player1;
import Model.Player2;

/**
 * Contains methods signatures needed for creating a Dwarf
 *
 * @author csd4988
 * @version 1.0
 */
public class Dwarf extends Piece {
    /**
     * Constructor
     * <b>Postcondition:</b> Creates a new Dwarf with the given player and position
     */
    public Dwarf(int player, int position) {
        super(3, player, position);
    }

    /**
     * <b>Observer:</b> Check if the move is valid <br />
     * <b>Postcondition:</b> The move is valid or not</p>
     *
     * @return true if the move is valid, false otherwise
     */
    public static boolean ValidMove(int current_position, int next_position) {
        return (next_position == current_position + 1
                || next_position == current_position - 1
                || next_position == current_position - 10
                || next_position == current_position + 10)
                && next_position != 32 && next_position != 33 && next_position != 36 && next_position != 37
                && next_position != 42 && next_position != 43 && next_position != 46 && next_position != 47
                && kanenas_apo_idia_omada(next_position);
    }

    private static boolean kanenas_apo_idia_omada(int nextPosition) {   //elegxei an stin sigkekrimeni thesi uparxei kapoios apo tin idia omada
        if (Player1.turn)
            return (Board.brd[nextPosition] != 1); //den iparxei pioni apo tin omada tou stin nea thesi
        else if (Player2.turn)
            return Board.brd[nextPosition] != 2;

        return false;
    }
}