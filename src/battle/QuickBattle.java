package battle;

import java.io.FileNotFoundException;

public class QuickBattle {
    public static void startQuickBattle() throws FileNotFoundException, InterruptedException {
        Party party1 = new Party();
        Party party2 = new Party();

        party1 = party1.createParty();
        party2 = party2.createParty();

        Battle battle = new Battle(party1.getParty(), party2.getParty());
        battle.fight();
    }
}
