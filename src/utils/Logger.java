package utils;

public class Logger {
    public static void LogToScreen(String message, TypeOfMessages typeOfMessage) {
        try{
            Thread.sleep(1000); // 1000ms = 1s
        }catch(InterruptedException ex){
        }
        switch (typeOfMessage) {
            case CREATION -> {
                System.out.println(ConsoleColors.BLUE_BOLD + message);
                break;
            }
            case ATTACK -> {
                System.out.println(ConsoleColors.RED + message);
                break;
            }
            case DAMAGE_DEALT -> {
                System.out.println(ConsoleColors.RED_BOLD + message);
                break;
            }
            case DAMAGE_TAKEN -> {
                System.out.println(ConsoleColors.PURPLE_BOLD + message);
                break;
            }
            case PARTY_JOINED -> {
                System.out.println(ConsoleColors.GREEN_BRIGHT + message);
                break;
            }
            case PARTY_CREATED -> {
                System.out.println(ConsoleColors.GREEN_BOLD + message);
                break;
            }
            default -> {
                System.out.println(ConsoleColors.WHITE + message);
                break;
            }
        }
    }
}
