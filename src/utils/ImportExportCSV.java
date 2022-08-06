package utils;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

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
}
