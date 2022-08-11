package battle;

import characters.Character;
import utils.Logger;
import utils.TypeOfMessages;
import java.util.List;

public class Graveyard {

    private List<Character> graveyard;

    public void addToGraveyard(Character character){
        graveyard.add(character);
        Logger.logToScreen("Character " + character.getName() + " added to the graveyard", TypeOfMessages.DEATH);
    }
}
