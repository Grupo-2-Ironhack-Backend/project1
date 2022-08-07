import battle.Battle;
import characters.Character;
import characters.Warrior;
import characters.Wizard;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Warrior guerrero1 = new Warrior(1,"Jhon",100,true,50,10);
        Wizard mago1 = new Wizard(5,"Cristian",100,true,50,20);

        List<Character> characterList1 = new ArrayList<>();
        List<Character> characterList2 = new ArrayList<>();

        characterList1.add(mago1);
        characterList2.add(guerrero1);

        Battle battle = new Battle(characterList1,characterList2);
        battle.fight();

    }
}