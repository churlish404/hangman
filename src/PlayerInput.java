import java.util.Scanner;

public class PlayerInput {
    private Scanner playerInput = new Scanner(System.in);
    private char letterGuess;
    private String wordGuess;

    public char getLetterGuess() {
        System.out.println("guess a letter");
         letterGuess = playerInput.next().charAt(0);
         // clear scanner to use for word guess
         playerInput.nextLine();
         return letterGuess;
    }
    public String getWordGuess() {
        System.out.println("guess the word");
        wordGuess = playerInput.nextLine();
        return wordGuess;
    }
}
