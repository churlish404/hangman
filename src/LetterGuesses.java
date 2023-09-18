import java.util.ArrayList;

import java.util.ArrayList;

public class LetterGuesses {
    private ArrayList<Character> letterGuesses = new ArrayList<>();

    public void addGuess(char guess) {
        letterGuesses.add(guess);
    }

    public boolean hasGuessed(char guess) {
        return letterGuesses.contains(guess);
    }

    public void displayGuesses() {
        System.out.print("Guessed letters: ");
        for (char guess : letterGuesses) {
            System.out.print(guess + " ");
        }
        System.out.println("\n"); // Print a newline to separate the guessed letters.
    }
}