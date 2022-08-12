package battle;

import characters.Character;
import utils.ImportExportCSV;
import utils.Logger;
import utils.TypeOfMessages;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class ImportBattle {
    public void startImportBattle() throws FileNotFoundException, InterruptedException {
        Scanner userInput = new Scanner(System.in);

        Logger.logToScreen("Write the path to your file for team1: ", TypeOfMessages.CREATION);
        String pathToFile = userInput.nextLine();
        List<Character> team1 = ImportExportCSV.importCSVParty(pathToFile);

        Logger.logToScreen("Write the path to your file for team2: ", TypeOfMessages.CREATION);
        pathToFile = userInput.nextLine();
        List<Character> team2 = ImportExportCSV.importCSVParty(pathToFile);

        Party party1 = new Party();
        party1.setParty(team1);

        Party party2 = new Party();
        party2.setParty(team2);

        Battle battle = new Battle(party1.getParty(), party2.getParty());
        battle.fight();
    }
}
