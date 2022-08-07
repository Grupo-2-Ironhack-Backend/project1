import characters.Character;
import characters.Warrior;
import characters.Wizard;
import utils.ImportExportCSV;

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
            System.out.println(member.toString());
        }

        // getCharInfo() presents char info to be properly formatted for GUI
        for (Character member : newParty) {
            System.out.println(member.getCharInfo());
        }
    }
}