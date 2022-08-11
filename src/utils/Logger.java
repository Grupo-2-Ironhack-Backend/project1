package utils;

public class Logger {
    public static void logToScreen(String message, TypeOfMessages typeOfMessage) {
        switch (typeOfMessage) {
            case CREATION -> {
                System.out.println(ConsoleColors.BLUE_BOLD + message);
            }
            case ATTACK -> {
                System.out.println(ConsoleColors.RED + message);
            }
            case DAMAGE_DEALT -> {
                System.out.println(ConsoleColors.RED_BOLD + message);
            }
            case DAMAGE_TAKEN -> {
                System.out.println(ConsoleColors.PURPLE_BOLD + message);
            }
            case PARTY_JOINED -> {
                System.out.println(ConsoleColors.GREEN_BRIGHT + message);
            }
            case PARTY_CREATED -> {
                System.out.println(ConsoleColors.GREEN_BOLD + message);
            }
            case ART -> {
                System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + message);
            }
            default -> {
                System.out.println(ConsoleColors.WHITE + message);
            }
        }
        try{
            Thread.sleep(1000); // 1000ms = 1s
        }catch(InterruptedException ex){
            System.err.println("Error: " + ex.getMessage());
        }
    }
}
