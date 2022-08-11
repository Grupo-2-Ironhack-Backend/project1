import battle.Battle;
import battle.Party;
import characters.Character;
import characters.Warrior;
import characters.Wizard;

import java.io.FileNotFoundException;

public class Main {
    /**
     * @author group-2
     * Main() prueba la importación/exportación
     * hacia/desde csv, creando primero una
     * banda de magos y guerreros, que son exportados y
     * posteriormente importados de nuevo e insertados
     * como objetos en un nuevo arrayList, para comprobar
     * su funcionamiento, imprimimos el contenido del nuevo array
     */

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        System.out.println("                                             _______________________\n" +
                "   _______________________-------------------                       `\\\n" +
                " /:--__                                                              |\n" +
                "||&lt; &gt; |                                   ___________________________/\n" +
                "| \\__/_________________-------------------                         |\n" +
                "|                                                                  |\n" +
                " |                       MERCS                                      |\n" +
                " |                                                                  |\n" +
                " |      \"Beware fellow adventurer, as you are about to              |\n" +
                "  |        witness a clash of parties like never before,             |\n" +
                "  |      earth will tear apart, skies will fall,                     |\n" +
                "  |        there might be some pizza too.                            |\n" +
                "  |      Fight two random generated parties or import                 |\n" +
                "   |       the one who made it through the end and gained a           |\n" +
                "   |       pace in your heart and in your filesystem.                 |\n" +
                "  |                                              ____________________|_\n" +
                "  |  ___________________-------------------------                      `\\\n" +
                "  |/`--_                                                                 |\n" +
                "  ||[ ]||                                            ___________________/\n" +
                "   \\===/___________________--------------------------");

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

        System.out.println("\n\n==================================\n");

    }
}