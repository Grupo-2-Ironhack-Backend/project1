package utils;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ImportExportCSV {
    public static void exportPartyToCSV(ArrayList<String> party) {
        File partyFile = new File("./party.csv");

        try (FileWriter writer = new FileWriter(partyFile)) {
            for (String member : party) {
                writer.write(member + ", ");
            }
        } catch (Exception e) {
            System.out.println("La banda ha desaparecido en un vórtice de malignidad. No hay banda.");
        }
    }

    public static ArrayList<String> importCSVParty() {
        ArrayList<String> party = new ArrayList<>();

        try (Scanner scanFile = new Scanner(new File("./party.csv"))) {
            while (scanFile.hasNextLine()) {
                String dato = scanFile.nextLine();
                party.add(dato);
            }
        } catch (Exception e) {
            System.out.println("La banda no ha podido llegar a la batalla. Estan todos MUERTOS.");
        }

        return party;
    }
}
