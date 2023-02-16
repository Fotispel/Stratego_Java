package Model.Piece.ImmovablePiece;

import Model.Piece.MoveablePiece.Piece;

/**
 * Contains methods signatures needed for creating a Flag
 *
 * @author csd4988
 * @version 1.0
 */
public class Flag extends Piece {
    /**
     * Constructor
     * <b>Postcondition:</b> Creates a new Flag with the given player and position
     */
    public Flag(int player, int position) {
        super(-2, player, position);
    }
}