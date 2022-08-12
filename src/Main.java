import UI.MainScreen;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        MainScreen.showMainScreen();
    }
}

    private static void presentation() {
        Logger.logToScreen(UIMessages.title, TypeOfMessages.ART);
        Scanner input = new Scanner(System.in);
        String foo = input.nextLine();
        input.close();
    }
}