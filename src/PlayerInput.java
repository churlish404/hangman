import java.util.Scanner;

public class PlayerInput {
    private final Scanner playerInput = new Scanner(System.in);

    public char getLetterGuess() {
        System.out.println("guess a letter:");
        char letterGuess = playerInput.next().charAt(0);
         // clear scanner to use for word guess
         playerInput.nextLine();
         return letterGuess;
    }
    public String getWordGuess() {
        System.out.println("guess the word");
        return playerInput.nextLine();
    }
}
