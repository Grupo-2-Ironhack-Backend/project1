package utils;

public class Logger {
    public static void logToScreen(String message, TypeOfMessages typeOfMessage) {
        switch (typeOfMessage) {
            case CREATION -> {
                System.out.println(ConsoleColors.GREEN_BRIGHT + message);
            }
            case ATTACK -> {
                System.out.println(ConsoleColors.RED + message);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            case DAMAGE_DEALT -> {
                System.out.println(ConsoleColors.RED_BOLD + message);
            }
            case DAMAGE_TAKEN -> {
                System.out.println(ConsoleColors.PURPLE_BOLD + message);
            }
            case PARTY_JOINED -> {
                System.out.println(ConsoleColors.GREEN_BOLD + message);
            }
            case PARTY_CREATED -> {
                System.out.println(ConsoleColors.PURPLE + message);
            }
            case DEATH -> {
                System.out.println(ConsoleColors.GREEN_BRIGHT + message);
            }
            case VICTORY -> {
                System.out.println(ConsoleColors.PURPLE_BRIGHT + message);
            }
            case DISSAPEARED -> {
                System.out.println(ConsoleColors.BLUE_BOLD);
            }
            default -> {
                System.out.println(ConsoleColors.RESET + message);
            }
        }
        try{
            Thread.sleep(500); // 1000ms = 1s
        }catch(InterruptedException ex){
            System.err.println("Error: " + ex.getMessage());
        }
    }
}
