package Model;

/**
 * Contains methods signatures needed for creating a Piece
 *
 * @author csd4988
 * @version 1.0
 */
public abstract class Player {
    private int aixmalotiseis;
    public int diasoseis;
    public static int round;  //giros pou briskomaste
    private int success_attacks_p1;     //pithos epitiximenon epitheseon player 1
    private int success_attacks_p2;     //pithos epitiximenon epitheseon player 2
    private int attacks_p1;         //plithos epitheseon
    private int attacks_p2;         //plithos epitheseon
    private float percent_success_attack;  //pososto epitiximenon epitheseon

    /**
     * <b>constructor</b>: Creates a new Player <br />
     * <b>postconditions</b>: Creates a new Player
     */
    public Player() {
        this.aixmalotiseis = 0;
        this.diasoseis = 0;
        round = 1;
        this.success_attacks_p1 = 0;
        this.success_attacks_p2 = 0;
        this.attacks_p1 = 0;
        this.attacks_p2 = 0;
        this.percent_success_attack = 0;
    }

    /**
     * <b>Accessor</b>:Returns the number of attacks of a player <br />
     *
     * @return percent_success_attack
     */
    public float getPercent_success_attack_p1(int success_attacks_p1, int attacks) {
        this.attacks_p1 = attacks;
        this.success_attacks_p1 = success_attacks_p1;
        if (this.attacks_p1 == 0) return -0;
        percent_success_attack = (float) this.success_attacks_p1 / this.attacks_p1;
        return percent_success_attack * 100;
    }

    /**
     * <b>Accessor</b>:Returns the number of attacks of a player <br />
     *
     * @return percent_success_attack
     */
    public float getPercent_success_attack_p2(int success_attacks_p2, int attacks) {
        this.attacks_p2 = attacks;
        this.success_attacks_p2 = success_attacks_p2;
        if (this.attacks_p2 == 0) return -0;
        percent_success_attack = (float) this.success_attacks_p2 / this.attacks_p2;
        return percent_success_attack * 100;
    }

    /**
     * <b>Accessor</b>:Returns the number of successful attacks of a player <br />
     * <b>Postcondition:</b> the number of successful attacks of a player have been returned</p>
     *
     * @return successful attacks
     */
    public int getSuccess_attack_p1() {      //Epistrefoun tis analoges times
        return success_attacks_p1;
    }

    public int getSuccess_attacks_p2() {      //Epistrefoun tis analoges times
        return success_attacks_p2;
    }

    public void setSuccess_attacks_p1(int success_attacks_p1) {      //Epistrefoun tis analoges times
        this.success_attacks_p1 = success_attacks_p1;
    }

    public void setSuccess_attacks_p2(int success_attacks_p2) {      //Epistrefoun tis analoges times
        this.success_attacks_p2 = success_attacks_p2;
    }

    public void setAttacks(int attacks) {      //Epistrefoun tis analoges times
        if (Player1.turn) this.attacks_p1 = attacks;
        else this.attacks_p2 = attacks;
    }

    public int getAttacks() {      //Epistrefoun tis analoges times
        if (Player1.turn) return attacks_p1;
        else return attacks_p2;
    }

    /**
     * <b>Tansformer</b>:Sets the number of diasoseis of a player <br />
     * <b>Postcondition:</b> the number of diasoseis of a player have been set</p>
     **/
    public void setDiasoseis(int diasoseis) {
        this.diasoseis = diasoseis;
    }

    /**
     * <b>Accessor</b>:Returns the number of diasoseis of a player <br />
     * <b>Postcondition:</b> the number of diasoseis of a player have been returned</p>
     *
     * @return diasoseis
     */
    public int getDiasoseis() {
        return diasoseis;
    }

    /**
     * <b>Tansformer</b>:Sets the number of aixmalotiseis of a player <br />
     * <b>Postcondition:</b> the number of aixmalotiseis of a player have been set</p>
     */
    public void setAixmalotiseis(int aixmalotiseis) {
        this.aixmalotiseis = aixmalotiseis;
    }

    /**
     * <b>Accessor</b>:Returns the number of aixmalotiseis of a player <br />
     * <b>Postcondition:</b> the number of aixmalotiseis of a player have been returned</p>
     *
     * @return aixmalotiseis
     */
    public int getAixmalotiseis() {
        return aixmalotiseis;
    }
}