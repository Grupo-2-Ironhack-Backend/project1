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

    private boolean aBoolean = true;
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

    public void attack(Character characterAttack1, Character characterAttack2){ //Ya había un Main Attack y Second Attack preparados y que además los hizo Katherine

        // System.out.println("\n\n ======= ATAQUE ========"); //Ya había un Logger preparado para lanzar mensajes.
        Logger.logToScreen("\n ====== ATAQUE ========", TypeOfMessages.ATTACK);

        boolean skill1;
        boolean skill2;

        skill1 = Math.random() < 0.5;
        skill2 = Math.random() < 0.5;

        System.out.println("Boolean de mago: " + skill1);
        System.out.println("Boolean de guerrero: " + skill2);

        if (characterAttack1.getClass() == Warrior.class){
            //attackGuerrero(skill2, pos, characterList2, characterAttack1);
            characterAttack2.setHp(attackWarrior(skill2, characterAttack2, characterAttack1.getClassMainAttribute()));
        } else {
            //attackMago(skill1, pos, characterList1, characterAttack2);
            characterAttack2.setHp(attackWizard(skill1, characterAttack2, characterAttack1.getClassMainAttribute()));
        }

        if (characterAttack2.getClass() == Warrior.class){
            characterAttack1.setHp(attackWarrior(skill2, characterAttack1, characterAttack2.getClassMainAttribute()));
        } else {
            characterAttack1.setHp(attackWizard(skill1, characterAttack1, characterAttack2.getClassMainAttribute()));
        }


        System.out.println("El hp del mago es de: " + characterAttack1.getHp());
        System.out.println("El hp del guerrero es de: " + characterAttack2.getHp());

        if (characterAttack1.getHp() > 0){
            characterAttack1.setAlive(true);
        } else {
            characterAttack1.setAlive(false);
        }

        if (characterAttack2.getHp() > 0){
            characterAttack2.setAlive(true);
        } else {
            characterAttack2.setAlive(false);
        }
    }

    public int attackWarrior(boolean skill, Character characterList, int characterAttack){
        if (skill == true){
            System.out.println("Vida del mago luego de ataque critico del guerrero: " + (characterList.getHp() - characterAttack));

            return characterList.getHp() - characterAttack;
        } else {
            System.out.println("Vida del mago luego de ataque normal del guerrero: " + (characterList.getHp() - (characterAttack/2)));
            return characterList.getHp() - (characterAttack/2);
        }
    }

    public int attackWizard(boolean skill, Character characterList, int characterAttack){
        if (skill == true){
            System.out.println("Vida del guerrero luego de ataque critico del mago: " + (characterList.getHp() - characterAttack));
            return characterList.getHp() - characterAttack;
        } else {
            System.out.println("Vida del guerrero luego de ataque normal del mago: " + (characterList.getHp() - 2));
            return characterList.getHp() - 2;
        }
    }
}
