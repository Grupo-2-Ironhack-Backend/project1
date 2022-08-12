package battle;

import UI.MainScreen;

import UI.UIMessages;
import characters.Character;
import characters.Warrior;
import utils.ImportExportCSV;
import utils.Logger;
import utils.TypeOfMessages;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Battle {

    private List<Character> team1;
    private List<Character> team2;

    private Graveyard graveyard ;

    private int round = 0;

    public Battle(List<Character> team1, List<Character> team2) {
        this.team1 = team1;
        this.team2 = team2;
        graveyard = new Graveyard();
    }

    public void fight() throws FileNotFoundException, InterruptedException {
        Scanner userInput = new Scanner(System.in);
        
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

            Logger.logToScreen("\nStill alive: " + team1.size() + " members in team 1.", TypeOfMessages.STILL_ALIVE);
            Logger.logToScreen(team2.size() + " mercenaries left in team 2", TypeOfMessages.STILL_ALIVE);

            if (team1.isEmpty() && team2.isEmpty()) {
                Logger.logToScreen("\nBoth bands are dead... '¬¬", TypeOfMessages.DEATH);
            } else if (team1.isEmpty()) {
                Logger.logToScreen("\nTeam 2 gets an epic victory!\n", TypeOfMessages.CREATION);
                Logger.logToScreen(UIMessages.warriorsArt, TypeOfMessages.ART);
                Logger.logToScreen("\n" + UIMessages.beholdTheDead, TypeOfMessages.DEATH);
                switch(userInput.nextLine()) {
                    case "y", "Y":
                        for (Character deadChar : graveyard.getGraveyard()) {
                            Logger.logToScreen(deadChar.getName(), TypeOfMessages.DEATH);
                        }
                    case "n", "N":
                        MainScreen.showMainScreen();
                }
                Logger.logToScreen(UIMessages.export_1, TypeOfMessages.CREATION);

                switch(userInput.nextLine()) {
                    case "y", "Y":
                        Logger.logToScreen(UIMessages.export_2, TypeOfMessages.CREATION);
                        ImportExportCSV.exportPartyToCSV(team1, "io/team2.csv");
                        break;
                    default:
                        break;
                }

            } else if (team2.isEmpty()){
                Logger.logToScreen("\nTeam 1 wiped the floor with team 2!", TypeOfMessages.CREATION);
                Logger.logToScreen(UIMessages.export_1, TypeOfMessages.CREATION);

                switch(userInput.nextLine()) {
                    case "y", "Y":
                        Logger.logToScreen(UIMessages.export_2, TypeOfMessages.CREATION);
                        ImportExportCSV.exportPartyToCSV(team1, "io/team1.csv");
                        break;
                    default:
                        break;
                }
            }
        }

    }

    public void attack(Character attacker1, Character attacker2){ //Ya había un Main Attack y Second Attack preparados y que además los hizo Katherine
        round++;
        Logger.logToScreen("\n ===================== ROUND " + round + " =======================", TypeOfMessages.ATTACK);

        boolean skill1;
        boolean skill2;

        skill1 = Math.random() < 0.5;
        skill2 = Math.random() < 0.5;

        // Set HP of characters
        if (attacker1.getClass() == Warrior.class){
            attacker2.setHp(attackWarrior(skill2, attacker2, attacker1.getClassMainAttribute()));
        } else {
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
            Logger.logToScreen("Health points of " + characterList.getName() + " after critical hit: " + Math.max((characterList.getHp() - attacker),0), TypeOfMessages.PARTY_JOINED);

            return characterList.getHp() - attacker;
        } else {
            Logger.logToScreen(characterList.getName() + " received " + attacker/2 + " damage.", TypeOfMessages.ATTACK);
            Logger.logToScreen("Health points of " + characterList.getName() + " after a regular hit: " + Math.max((characterList.getHp() - (attacker/2)),0), TypeOfMessages.PARTY_JOINED);
            return characterList.getHp() - (attacker/2);
        }
    }

    public int attackWizard(boolean skill, Character characterList, int attacker){
        if (skill == true){
            Logger.logToScreen(characterList.getName() + " received " + attacker + " damage.", TypeOfMessages.ATTACK);
            Logger.logToScreen("Health points of " + characterList.getName() + " after critical blow: " + Math.max((characterList.getHp() - attacker),0), TypeOfMessages.PARTY_JOINED);
            return characterList.getHp() - attacker;
        } else {
            Logger.logToScreen(characterList.getName() + " received " + 2 + " damage.", TypeOfMessages.ATTACK);
            Logger.logToScreen("Health points of " + characterList.getName() + " after a regular hit: " + Math.max((characterList.getHp() - 2),0), TypeOfMessages.PARTY_JOINED);
            return characterList.getHp() - 2;
        }
    }
}
