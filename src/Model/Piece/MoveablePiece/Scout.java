package Model.Piece.MoveablePiece;

import Model.Board;
import Model.Player1;
import Model.Player2;

public class Scout extends Piece {
    /**
     * Constructor
     * <b>Postcondition:</b> Creates a new Scout with the given player and position
     */
    public Scout(int player, int position) {
        super(2, player, position);
    }


    /**
     * <b>Observer:</b> Check if the move is valid <br />
     * <b>Postcondition:</b> The move is valid or not</p>
     *
     * @return true if the move is valid, false otherwise
     */
    public static boolean ValidMove(int current_position, int next_position) {
        return (next_position != 32 && next_position != 33 && next_position != 36 && next_position != 37       //prepei na balo kai tin periptosi pou diaperna tin apagorevmeni perioxi
                && next_position != 42 && next_position != 43 && next_position != 46 && next_position != 47)
                && (next_position % 10 == current_position % 10 || next_position / 10 == current_position / 10)
                && kanenas_apo_idia_omada(next_position)
                && den_perna_pano_apo_tin_apagorevmeni_perioxi(current_position, next_position);
    }

    private static boolean kanenas_apo_idia_omada(int nextPosition) {   //elegxei an stin sigkekrimeni thesi uparxei kapoios apo tin idia omada
        if (Player1.turn)
            return (Board.brd[nextPosition] != 1); //den iparxei pioni apo tin omada tou stin nea thesi
        else if (Player2.turn)
            return Board.brd[nextPosition] != 2;

        return false;
    }

    protected static boolean den_perna_pano_apo_tin_apagorevmeni_perioxi(int current_position, int new_position) {
        int cptemp = current_position % 10;
        int nptemp = new_position % 10;
        int diafora = Math.abs(cptemp - nptemp);
        return (current_position < 30 || current_position > 49 || diafora <= 2);
    }
}