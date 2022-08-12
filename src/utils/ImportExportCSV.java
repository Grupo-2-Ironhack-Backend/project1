package utils;

import characters.Character;
import characters.Warrior;
import characters.Wizard;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImportExportCSV {
    public static void exportPartyToCSV(List<Character> party, String pathName) {
        File partyFile = new File(pathName);

        try (FileWriter writer = new FileWriter(partyFile)) {
            for (Character member : party) {
                writer.write(member.toString());
                Logger.logToScreen(member.getName() + " added to the file.", TypeOfMessages.PARTY_CREATED);
            }
        } catch (Exception e) {
            Logger.logToScreen("The band dissapeared in a vortex of madness. There's no band.", TypeOfMessages.CREATION);
        }
    }

    public static ArrayList<Character> importCSVParty(String pathName) {
        ArrayList<Character> invokedParty = new ArrayList<>();

        try (Scanner scanFile = new Scanner(new File(pathName))) {

            long lines = Files.lines(Path.of(pathName)).count();
            Logger.logToScreen(lines + " MERCENARIES, MIXING WARRIORS AND WIZARDS, ARE GATHERING TOGETHER! WAIT FOR IT...\n", TypeOfMessages.CREATION);

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
                    Logger.logToScreen(lineas[1] + " added to the new party as a " + lineas[2] + ". Enjoy the fight!", TypeOfMessages.PARTY_JOINED);
                } else if (lineas[2].equals("Wizard")) {
                    invokedParty.add(new Wizard(Integer.parseInt(lineas[0]),
                            lineas[1],
                            lineas[2],
                            Integer.parseInt(lineas[3]),
                            Boolean.parseBoolean(lineas[4]),
                            Integer.parseInt(lineas[5]),
                            Integer.parseInt(lineas[6])));
                    Logger.logToScreen(lineas[1] + " added to the new party as a " + lineas[2] + ". Do your magic!", TypeOfMessages.PARTY_JOINED);
                }
            }
        } catch (Exception e) {
            Logger.logToScreen("The band couldn't make it to the battle. THEY ARE ALL DEAD!", TypeOfMessages.DEATH);
        }

        return invokedParty;
    }
}
