import java.util.Scanner;

public class Main {
    private static final Scanner quitScanner = new Scanner(System.in);
    private static final Scanner difficultyScanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean wantsAnotherGame = true;

        while (wantsAnotherGame) {
            try {
                System.out.println("Choose your difficulty....EASYPEASY (5 letters), MEDIUMPEASY (6-8 letters) OR HARDPEASY (9+ letters)");
                GameDifficulty gameDifficulty = GameDifficulty.valueOf(difficultyScanner.nextLine().toUpperCase());

                HangmanGame game = new HangmanGame(gameDifficulty);
                boolean win = game.play();
                if (win) {
                    System.out.println("Congrats, I suppose...you won");
                } else {
                    System.out.println("Oh no! You lost!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid difficulty. Please choose from EASYPEASY, MEDIUMPEASY, or HARDPEASY.");
                continue;
            }

            System.out.println("Do you want to play another game? (y/n)");
            String userInput = quitScanner.nextLine().toLowerCase();
            if (userInput.equals("n") || userInput.equals("no")) {
                wantsAnotherGame = false;
            }
        }
        System.out.println("Quitting..");
    }
}
