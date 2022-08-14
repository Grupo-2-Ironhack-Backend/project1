import UI.UIMessages;
import battle.Battle;
import battle.Party;
import characters.Character;
import characters.Warrior;
import characters.Wizard;
import utils.Logger;
import utils.TypeOfMessages;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        presentation();

        Character guerrero1 = new Warrior(1,"Jhon", "Warrior",100,true,50,10);
        Character mago1 = new Wizard(5,"Cristian","Wizard",100,true,50,20);
        Character guerrero2 = new Warrior(2,"newWarrior", "Warrior",100,true,50,10);
        Character mago2 = new Wizard(6,"newWizard","Wizard",100,true,50,20);

        Party characterList1 = new Party();
        characterList1.addToParty(mago1);
        characterList1.addToParty(guerrero2);
        characterList1.addToParty(guerrero1);
        characterList1.addToParty(mago2);

        Party characterList2 = new Party();
        characterList2 = characterList2.createParty();

        // List<Character> characterList3 = importCSVParty();

        Battle battle = new Battle(characterList1.getParty(),characterList2.getParty());
        battle.fight();


    }

    private static void presentation() {
        Logger.logToScreen(UIMessages.title, TypeOfMessages.ART);
        Scanner input = new Scanner(System.in);
        String foo = input.nextLine();
        input.close();
    }
}