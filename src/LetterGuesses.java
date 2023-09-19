import java.util.ArrayList;

import java.util.ArrayList;

public class LetterGuesses {
    private final ArrayList<Character> letterGuesses = new ArrayList<>();
    private int numberOfCorrectGuesses = 0;

    public int getNumberOfCorrectGuesses() {
        return numberOfCorrectGuesses;
    }
    public void incrementCorrectGuess() {
        numberOfCorrectGuesses++;
    }
    public void addGuess(char guess) {
        char lowercaseGuess = Character.toLowerCase(guess);
        letterGuesses.add(lowercaseGuess);
    }
    public boolean hasAlreadyGuessed(char guess) {
        return letterGuesses.contains(guess);
    }
    public boolean isNotANumber(char guess) {
        return Character.isDigit(guess);
    }
    public void displayGuesses() {
        System.out.print("Guessed letters: ");
        for (char guess : letterGuesses) {
            System.out.print(guess + " ");
        }
        System.out.println("\n");
    }
}