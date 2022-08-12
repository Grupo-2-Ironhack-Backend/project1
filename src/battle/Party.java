package battle;

import UI.UIMessages;
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
        Logger.logToScreen(character.getName() + " has joined the party. Hope you survive the experience!\n", TypeOfMessages.PARTY_JOINED);
    }

    public Party createParty() throws FileNotFoundException, InterruptedException {
        int size = (int) (random() * 5) + 1;
        Party party = new Party();

        Logger.logToScreen(size + " MERCENARIES, MIXING WARRIORS AND WIZARDS, ARE GATHERING TOGETHER! WAIT FOR IT...\n", TypeOfMessages.CREATION);

        for (int i = 0; i < size; i++) {
            if (Math.random()*2 >= 1.0) {
                Warrior character = new Warrior(i, "Warrior ", "Warrior", 0, true, 0, 0);
                character.setRandomName(party);
                character.setRandomHp();
                character.setRandomStrength();
                character.setRandomStamina();
                Logger.logToScreen(character.getName() + " born as a " + character.getCharClass(), TypeOfMessages.CREATION);
                party.addToParty(character);
            } else {
                Wizard character = new Wizard(i, "Wizard ", "Wizard", 0, true, 0, 0);
                character.setRandomName(party);
                character.setRandomHp();
                character.setRandomMana();
                character.setRandomIntelligence();
                Logger.logToScreen(character.getName() + " was chosen to be a " + character.getCharClass(), TypeOfMessages.CREATION);
                party.addToParty(character);
            }
        }

        Thread.sleep(1000); // 1000ms = 1s
        Thread.sleep(1000); // 1000ms = 1s

        Logger.logToScreen("A NEWFOUND AND BRAVE PARTY OF MERRY MERCENARIES ARE READY TO BRING DEATH!\n", TypeOfMessages.PARTY_CREATED);

        return party;
    }

 }
