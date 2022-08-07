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
                attack(instanceOf(team1.get(i)), instanceOf(team2.get(i)), i);
            }
        }
    }

    public int instanceOf(Character list){

        if (list instanceof Warrior){
            return ((Warrior) list).getStrength();
        } else if (list instanceof Wizard){
            return  ((Wizard) list).getIntelligence();
        }
        return 0;
    }

    public void attack(int characterAttack1, int characterAttack2, int pos){

        System.out.println("\n\n ======= ATAQUE ========");

        boolean skill1;
        boolean skill2;

        skill1 = Math.random() < 0.5;
        skill2 = Math.random() < 0.5;

        System.out.println("Boolean de mago: " + skill1);
        System.out.println("Boolean de guerrero: " + skill2);



        if (team1.get(pos).getClass() == Warrior.class){
            //attackGuerrero(skill2, pos, characterList2, characterAttack1);
            team2.get(pos).setHp(attackGuerrero(skill2, pos, team2, characterAttack1));
        } else {
            //attackMago(skill1, pos, characterList1, characterAttack2);
            team2.get(pos).setHp(attackMago(skill1, pos, team2, characterAttack1));
        }

        if (team2.get(pos).getClass() == Warrior.class){
            team1.get(pos).setHp(attackGuerrero(skill2, pos, team1, characterAttack2));
        } else {
            team1.get(pos).setHp(attackMago(skill1, pos, team1, characterAttack2));
        }


        System.out.println("El hp del mago es de: " + team1.get(pos).getHp());
        System.out.println("El hp del guerrero es de: " + team2.get(pos).getHp());

        if (team1.get(pos).getHp() > 0){
            team1.get(pos).setAlive(true);
        } else {
            team1.get(pos).setAlive(false);
        }

        if (team2.get(pos).getHp() > 0){
            team2.get(pos).setAlive(true);
        } else {
            team2.get(pos).setAlive(false);
        }

    }

    public int attackGuerrero(boolean skill, int num, List<Character> characterList, int characterAttack){
        if (skill == true){
            System.out.println("Vida del mago luego de ataque critico del guerrero: " + (characterList.get(num).getHp() - characterAttack));
            return characterList.get(num).getHp() - characterAttack;
        } else {
            System.out.println("Vida del mago luego de ataque normal del guerrero: " + (characterList.get(num).getHp() - (characterAttack/2)));
            return characterList.get(num).getHp() - (characterAttack/2);
        }
    }

    public int attackMago(boolean skill, int num, List<Character> characterList, int characterAttack){
        if (skill == true){
            System.out.println("Vida del guerrero luego de ataque critico del mago: " + (characterList.get(num).getHp() - characterAttack));
            return characterList.get(num).getHp() - characterAttack;
        } else {
            System.out.println("Vida del guerrero luego de ataque normal del mago: " + (characterList.get(num).getHp() - 2));
            return characterList.get(num).getHp() - 2;
        }
    }

}
