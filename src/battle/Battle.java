package battle;

import characters.Character;
import characters.Warrior;
import characters.Wizard;

import java.util.List;

public class Battle {

    private List<Character> team1;
    private List<Character> team2;

    public Battle(List<Character> team1, List<Character> team2) {
        this.team1 = team1;
        this.team2 = team2;

    }

    public void fight(){
        for (int i = 0; i < team1.size(); i++) {
            System.out.println("\n\n========= BATALLA " + (i+1) + " ============");
            while (team1.get(i).isAlive() && team2.get(i).isAlive()) {
               attack(team1.get(i), team2.get(i));
            }
        }
    }

   /* public int instanceOf(Character list){

        if (list instanceof Warrior){
            return ((Warrior) list).getStrength();
        } else if (list instanceof Wizard){
            return  ((Wizard) list).getIntelligence();
        }
        return 0;
    }*/

    public void attack(Character characterAttack1, Character characterAttack2){

        System.out.println("\n\n ======= ATAQUE ========");

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
