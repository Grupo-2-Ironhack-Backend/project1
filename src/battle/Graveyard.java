package battle;

import characters.Character;
import utils.Logger;
import utils.TypeOfMessages;

import java.util.ArrayList;
import java.util.List;

public class Graveyard {

    private List<Character> graveyard;

    public Graveyard() {
        graveyard = new ArrayList<>();
    }

    public void addToGraveyard(Character character){
        graveyard.add(character);
        Logger.logToScreen(character.getName() + " IS DEAD! WHERE'S A NECROMANCEER!?", TypeOfMessages.DEATH);
    }

    public List<Character> getGraveyard() {
        return graveyard;
    }

    public void setGraveyard(List<Character> graveyard) {
        this.graveyard = graveyard;
    }

    @Override
    public String toString() {
        return "Graveyard{" +
                "graveyard=" + graveyard +
                '}';
    }
}
