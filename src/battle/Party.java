package battle;

import characters.Character;
import utils.Logger;
import utils.TypeOfMessages;
import java.util.List;


public class Party {

    private List<Character> party;

    public void addToParty(Character character){
        party.add(character);
        Logger.logToScreen("Character " + character.getName() + " added to the party", TypeOfMessages.PARTY_JOINED);
    }
}
