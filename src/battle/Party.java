package battle;

import characters.Character;
import characters.Warrior;
import characters.Wizard;
import utils.Logger;
import utils.TypeOfMessages;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.random;


public class Party {

    private List<Character> party;

    public Party(List<Character> party) {
        this.party = party;
    }

    public List<Character> getParty() {
        return party;
    }

    public void setParty(List<Character> party) {
            this.party = party;
    }

    public Party() {
        party = new ArrayList<>();
    }

    public void addToParty(Character character){
        party.add(character);
        Logger.logToScreen("Character " + character.getName() + " has joined the party", TypeOfMessages.PARTY_JOINED);
    }

    public void createParty() throws FileNotFoundException, InterruptedException {

        int size = (int) (random() * 10) + 1;
        Logger.logToScreen("Creating a party of warriors and wizards with " + size + " characters", TypeOfMessages.CREATION);
        Party party = new Party();
        for (int i = 0; i < size; i++) {
            if (Math.random()*2 >= 1.0) {
                Warrior character = new Warrior(i, "Warrior ", "Warrior", 0, true, 0, 0);
                character.setRandomName(party);
                character.setRandomHp();
                character.setRandomStrength();
                character.setRandomStamina();
                Logger.logToScreen("Character " + character.getName() + " created as a " + character.getCharClass(), TypeOfMessages.CREATION);
                party.addToParty(character);
            } else {
                Wizard character = new Wizard(i, "Wizard ", "Wizard", 0, true, 0, 0);
                character.setRandomName(party);
                character.setRandomHp();
                character.setRandomMana();
                character.setRandomIntelligence();
                Logger.logToScreen("Character " + character.getName() + " created as a " + character.getCharClass(), TypeOfMessages.CREATION);
                party.addToParty(character);
            }
        }
        Thread.sleep(1000); // 1000ms = 1s
        Logger.logToScreen("New party is ready for the battle", TypeOfMessages.PARTY_CREATED);
        Thread.sleep(1000); // 1000ms = 1s
    }

 }
