package Model.Piece.MoveablePiece;

import Model.Piece.MoveablePiece.SpecialMoveablePiece.Dwarf;

/**
 * Contains the basic methods signatures needed for creating a piece
 *
 * @author csd4988
 * @version 1.0
 */
public abstract class Piece {
    public int power;
    public int diasoseis;
    private int player;
    private int position;

    /**
     * Constructor
     * <b>Postcondition:</b> Creates a new Piece with the given power, player, position, rescue_from_others and Rescue_others
     */
    public Piece(int power, int player, int position) {
        this.power = power;
        this.position = position;
        this.player = player;
        this.diasoseis = 0;
    }

    /**
     * </b>Transformer:</b> sets diasoseis of a specific piece <br />
     * <b>Postcondition:</b> diasoseis of a specific piece have been set</p>
     *
     */
    public void setDiasoseis(int diasoseis) {
        this.diasoseis = diasoseis;
    }

    /**
     * <b>Accessor</b>:Returns the diasoseis of a piece <br />
     * <b>Postcondition:</b> the diasoseis of a piece have been returned</p>
     *
     * @return diasoseis
     */
    public int getDiasoseis() {
        return diasoseis;
    }




    /**
     * <b>Accessor</b>:Sets the owner of the piece <br />
     * <b>Postcondition:</b> the owner of the piece has been set</p>
     */
    public void setPlayer(int player) {
        this.player = player;
    }


    /**
     * <b>Accessor</b>:Sets the position of the piece <br />
     * <b>Postcondition:</b> the position of the piece has been set</p>
     *
     */
    public void set_position(int position) {
        this.position = position;
    }

    /**
     * <b>Accessor</b>:Returns the position of the piece <br />
     * <b>Postcondition:</b> the position of the piece has been returned</p>
     *
     * @return position
     */
    public int get_position() {
        return this.position;
    }

    public int get_power() {
        return power;
    }

    public static boolean getValidMove(int current_position, int new_position, int power) {
        if (power == 1) return Slayer.ValidMove(current_position, new_position);
        else if (power == 2) return Scout.ValidMove(current_position, new_position);
        else if (power == 3) return Dwarf.ValidMove(current_position, new_position);
        else if (power == 4) return Elf.ValidMove(current_position, new_position);
        else if (power == 5) return LavaBeast.ValidMove(current_position, new_position);  // LavaBeast / Yeti
        else if (power == 6) return Sorceress.ValidMove(current_position, new_position);
        else if (power == 7) return BeastRider.ValidMove(current_position, new_position);
        else if (power == 8) return Knight.ValidMove(current_position, new_position);
        else if (power == 9) return Mage.ValidMove(current_position, new_position);
        else if (power == 10) return Dragon.ValidMove(current_position, new_position);

        return false;
    }
}