package Model.Piece.ImmovablePiece;

import Model.Piece.MoveablePiece.Piece;

/**
 * Contains methods signatures needed for creating a Flag
 *
 * @author csd4988
 * @version 1.0
 */
public class Trap extends Piece {

    /**
     * Constructor
     * <b>Postcondition:</b> Creates a new Trap with the given player and position
     */
    public Trap(int player, int position) {
        super(-1, player, position);
    }

}