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

            System.out.println("Tamaño del equipo 1: " + team1.size());
            System.out.println("Tamaño del equipo 2: " + team2.size());

            if (team1.isEmpty() && team2.isEmpty()) {
                System.out.println("Empate");

            } else if (team1.isEmpty()) {
                System.out.println("Ha ganado el equipo 2");
            } else {
                System.out.println("Ha ganado el equipo 1");
            }
        }

    }

    public void attack(Character attacker1, Character attacker2){ //Ya había un Main Attack y Second Attack preparados y que además los hizo Katherine

        // System.out.println("\n\n ======= ATAQUE ========"); //Ya había un Logger preparado para lanzar mensajes.
        Logger.logToScreen("\n ====== ATAQUE ========", TypeOfMessages.ATTACK);

        boolean skill1;
        boolean skill2;

        skill1 = Math.random() < 0.5;
        skill2 = Math.random() < 0.5;

        System.out.println("Boolean de mago: " + skill1);
        System.out.println("Boolean de guerrero: " + skill2);

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


        System.out.println("El hp del mago es de: " + attacker1.getHp());
        System.out.println("El hp del guerrero es de: " + attacker2.getHp());


        if (attacker1.getHp() <= 0){
            attacker1.setAlive(false);
            // attacker1.setAlive(true);
        }

        if (attacker2.getHp() <= 0){
            attacker2.setAlive(false);
        }

    }

    public int attackWarrior(boolean skill, Character characterList, int attacker){
        if (skill == true){
            System.out.println("Vida del mago luego de ataque critico del guerrero: " + (characterList.getHp() - attacker));

            return characterList.getHp() - attacker;
        } else {
            System.out.println("Vida del mago luego de ataque normal del guerrero: " + (characterList.getHp() - (attacker/2)));
            return characterList.getHp() - (attacker/2);
        }
    }

    public int attackWizard(boolean skill, Character characterList, int attacker){
        if (skill == true){
            System.out.println("Vida del guerrero luego de ataque critico del mago: " + (characterList.getHp() - attacker));
            return characterList.getHp() - attacker;
        } else {
            System.out.println("Vida del guerrero luego de ataque normal del mago: " + (characterList.getHp() - 2));
            return characterList.getHp() - 2;
        }
    }
}
