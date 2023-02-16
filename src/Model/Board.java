package Model;

/**
 * Contains method to check if a position is full or empty
 *
 * @author csd4988
 * @version 1.0
 */
public class Board {
    public static int[] brd;

    /**
     * <b>Transformer:</b> Creates the board and fill it with false values <br />
     * <b>Postcondition:</b> The board is created and filled with false values
     */
    public Board(int[] brd) {
        Board.brd = brd;
        for (int i = 0; i < 80; i++) {
            Board.brd[i] = 0;    //adeio keli
        }
    }
}