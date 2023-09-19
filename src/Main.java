import java.util.Scanner;

public class Main {
    private static Scanner quitScanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean wantsAnotherGame = true;

        while (wantsAnotherGame) {
            HangmanGame game = new HangmanGame();
            boolean win = game.play();
            if (win) {
                System.out.println("Congrats, I suppose...you won");
            } else {
                System.out.println("Oh no! You lost!");
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