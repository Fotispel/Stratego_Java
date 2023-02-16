package Controller;

/**
 * Contains method for return the result of the attack
 *
 * @author csd4988
 * @version 1.0
 */
public class Attack {
    /**
     * <b>Oberver:</b> Return the result of the attack <br />
     * <b>Postcondition:</b> The result of the attack is returned</p>
     *
     * @return 1 if the attacker wins, 0 if the defender wins, -1 if the attacker and the defender are equal
     */
    static int result(int power_attacker, int power_defender) {
        if (power_defender == -1 && power_attacker == 3) // dwarf attacks trap
            return 1;   //dwarf wins
        else if (power_defender == -1)
            return 2;   //trap wins
        else if (power_attacker == 1 && power_defender == 10)
            return 1;   //slayer wins dragon
        else if (power_attacker > power_defender)
            return 1;  //attacker wins
        else if (power_attacker < power_defender)
            return 2;  //defender wins

        return -1;  //draw (afairountai kai ta dio)
    }
}