import battle.Battle;
import characters.Character;
import characters.Warrior;
import characters.Wizard;

import java.util.ArrayList;
import java.util.List;

import characters.Character;
import characters.*;
import utils.*;

import java.util.ArrayList;

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

    public static void main(String[] args) {

        Character guerrero1 = new Warrior(1,"Jhon", "Warrior",100,true,50,10);
        Character mago1 = new Wizard(5,"Cristian","Wizard",100,true,50,20);

        List<Character> characterList1 = new ArrayList<>();
        List<Character> characterList2 = new ArrayList<>();

        characterList1.add(mago1);
        characterList2.add(guerrero1);

        Battle battle = new Battle(characterList1,characterList2);
        battle.fight();

        System.out.println("\n\n==================================\n");

        ArrayList<Character> party = new ArrayList<>();

        Character guts = new Warrior(5, "Guts", "Warrior", 5000, true, 2500, 250);
        Character logan = new Wizard(3, "Big Hat Logan", "Wizard", 1000, true, 3500, 250);
        Character saitama = new Warrior(4, "Saitama", "Warrior", 1500, true, 2500, 300);
        Character elminster = new Wizard(1, "Elminster", "Wizard", 1000, true, 4000, 300);
        Character kiaska = new Warrior(6, "Kiaska", "Warrior", 3500, true, 3000, 200);
        Character shierke = new Wizard(2, "Shierke", "Wizard", 1000, true, 3000, 250);

        party.add(guts);
        party.add(logan);
        party.add(saitama);
        party.add(elminster);
        party.add(kiaska);
        party.add(shierke);

        ImportExportCSV.exportPartyToCSV(party);

        ArrayList<Character> newParty = ImportExportCSV.importCSVParty();








        // toString() presents info ready to create new objects
       for (Character member : newParty) {
            Logger.logToScreen(member.toString(), TypeOfMessages.CREATION);
        }

        // getCharInfo() presents char info to be properly formatted for GUI
        for (Character member : newParty) {
            Logger.logToScreen(member.getCharInfo(), TypeOfMessages.PARTY_JOINED);
        }
    }
}