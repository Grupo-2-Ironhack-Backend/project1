package utils;

import characters.Character;
import characters.Warrior;
import characters.Wizard;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ImportExportCSV {
    public static void exportPartyToCSV(ArrayList<Character> party) {
        File partyFile = new File("./party.csv");

        try (FileWriter writer = new FileWriter(partyFile)) {
            for (Character member : party) {
                writer.write(member.toString());
            }
        } catch (Exception e) {
            System.out.println("La banda ha desaparecido en un vórtice de malignidad. No hay banda.");
        }
    }

    public static ArrayList<Character> importCSVParty() {
        ArrayList<Character> invokedParty = new ArrayList<>();

        try (Scanner scanFile = new Scanner(new File("./party.csv"))) {
            while (scanFile.hasNextLine()) {
                String linea = scanFile.nextLine();
                String[] lineas = linea.split(",");

                if (lineas[2].equals("Warrior")) {
                    invokedParty.add(new Warrior(Integer.parseInt(lineas[0]),
                            lineas[1],
                            lineas[2],
                            Integer.parseInt(lineas[3]),
                            Boolean.parseBoolean(lineas[4]),
                            Integer.parseInt(lineas[5]),
                            Integer.parseInt(lineas[6])));
                } else if (lineas[2].equals("Wizard")) {
                    invokedParty.add(new Wizard(Integer.parseInt(lineas[0]),
                            lineas[1],
                            lineas[2],
                            Integer.parseInt(lineas[3]),
                            Boolean.parseBoolean(lineas[4]),
                            Integer.parseInt(lineas[5]),
                            Integer.parseInt(lineas[6])));
                }
            }
        } catch (Exception e) {
            System.out.println("La banda no ha podido llegar a la batalla. Estan todos MUERTOS.");
        }

        return invokedParty;
    }
}
