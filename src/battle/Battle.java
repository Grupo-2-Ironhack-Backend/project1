package battle;

import characters.Character;
import characters.Warrior;
import characters.Wizard;
import utils.Logger;
import utils.TypeOfMessages;

import java.util.List;

public class Battle {

    private List<Character> team1;
    private List<Character> team2;

    private Graveyard graveyard ;

    public Battle(List<Character> team1, List<Character> team2) {
        this.team1 = team1;
        this.team2 = team2;
        graveyard = new Graveyard();
    }

    public void fight(){
        while (!team1.isEmpty() && !team2.isEmpty()){


            while (team1.get(0).isAlive() && team2.get(0).isAlive()) {
                attack(team1.get(0), team2.get(0));
            }
            if (team1.get(0).isAlive() == false) {
                graveyard.addToGraveyard(team1.get(0));
                team1.remove(team1.get(0));
            }
            if (team2.get(0).isAlive() == false) {
                graveyard.addToGraveyard(team2.get(0));
                team2.remove(team2.get(0));
            }

            Logger.logToScreen("\nStill alive: " + team1.size() + " members in team 1.", TypeOfMessages.CREATION);
            Logger.logToScreen(team2.size() + " mercenaries left in team 2", TypeOfMessages.CREATION);

            if (team1.isEmpty() && team2.isEmpty()) {
                Logger.logToScreen("\nBoth bands are dead... '¬¬", TypeOfMessages.DEATH);
            } else if (team1.isEmpty()) {
                Logger.logToScreen("\nTeam 2 gets an epic victory!", TypeOfMessages.CREATION);
            } else if (team2.isEmpty()){
                Logger.logToScreen("\nTeam 1 wiped the floor with team 2!", TypeOfMessages.CREATION);
            }
        }

    }

    public void attack(Character attacker1, Character attacker2){ //Ya había un Main Attack y Second Attack preparados y que además los hizo Katherine

        Logger.logToScreen("\n =========== ROUND =============", TypeOfMessages.ATTACK);

        boolean skill1;
        boolean skill2;

        skill1 = Math.random() < 0.5;
        skill2 = Math.random() < 0.5;

        // Set HP of characters
        if (attacker1.getClass() == Warrior.class){
            //attackGuerrero(skill2, pos, characterList2, attacker1);
            attacker2.setHp(attackWarrior(skill2, attacker2, attacker1.getClassMainAttribute()));
        } else {
            //attackMago(skill1, pos, characterList1, attacker2);
            attacker2.setHp(attackWizard(skill1, attacker2, attacker1.getClassMainAttribute()));
        }

        if (attacker2.getClass() == Warrior.class){
            attacker1.setHp(attackWarrior(skill2, attacker1, attacker2.getClassMainAttribute()));
        } else {
            attacker1.setHp(attackWizard(skill1, attacker1, attacker2.getClassMainAttribute()));
        }

        attacker1.setAlive((attacker1.getHp() <= 0) ? false : true);
        attacker2.setAlive((attacker2.getHp() <= 0) ? false : true);

    }

    public int attackWarrior(boolean skill, Character characterList, int attacker){
        if (skill == true){
            Logger.logToScreen(characterList.getName() + " received " + attacker + " damage.", TypeOfMessages.ATTACK);
            Logger.logToScreen("Health points of " + characterList.getName() + " after critical hit: " + (characterList.getHp() - attacker), TypeOfMessages.PARTY_JOINED);

            return characterList.getHp() - attacker;
        } else {
            Logger.logToScreen(characterList.getName() + " received " + attacker/2 + " damage.", TypeOfMessages.ATTACK);
            Logger.logToScreen("Health points of " + characterList.getName() + " after a regular hit: " + (characterList.getHp() - (attacker/2)), TypeOfMessages.PARTY_JOINED);
            return characterList.getHp() - (attacker/2);
        }
    }

    public int attackWizard(boolean skill, Character characterList, int attacker){
        if (skill == true){
            Logger.logToScreen(characterList.getName() + " received " + attacker + " damage.", TypeOfMessages.ATTACK);
            Logger.logToScreen("Health points of " + characterList.getName() + " after critical blow: " + (characterList.getHp() - attacker), TypeOfMessages.PARTY_JOINED);
            return characterList.getHp() - attacker;
        } else {
            Logger.logToScreen(characterList.getName() + " received " + 2 + " damage.", TypeOfMessages.ATTACK);
            Logger.logToScreen("Health points of " + characterList.getName() + " after a regular hit: " + (characterList.getHp() - 2), TypeOfMessages.PARTY_JOINED);
            return characterList.getHp() - 2;
        }
    }
}
