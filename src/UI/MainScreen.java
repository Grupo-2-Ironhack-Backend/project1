package UI;

import battle.Battle;
import battle.ImportBattle;
import battle.QuickBattle;
import utils.Logger;
import utils.TypeOfMessages;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainScreen {
    public static void showMainScreen() throws FileNotFoundException, InterruptedException {
        Logger.logToScreen(UIMessages.title, TypeOfMessages.CREATION);
        Scanner userInput = new Scanner(System.in);
        while(true) {
            Logger.logToScreen(UIMessages.firstMenu, TypeOfMessages.CREATION);
            switch(userInput.nextInt()) {
                case 1:
                    showBattleScreen();
                    break;
                case 2:
                    Logger.logToScreen("Farewell thee...", TypeOfMessages.DEATH);
                    System.exit(0);
                    break;
            }
        }
    }

    public static void showBattleScreen() throws FileNotFoundException, InterruptedException {
        Logger.logToScreen(UIMessages.secondMenu, TypeOfMessages.CREATION);
        Scanner userInput = new Scanner(System.in);
        switch(userInput.nextInt()) {
            case 1:
                QuickBattle quickBattle = new QuickBattle();
                quickBattle.startQuickBattle();
                break;
            case 2:
                ImportBattle importBattle = new ImportBattle();
                importBattle.startImportBattle();
                break;
            case 3:
                showMainScreen();
            case 4:
                System.exit(0);
            default:
                System.exit(0);
        }
    }
}
