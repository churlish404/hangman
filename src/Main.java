import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String word = GenerateWord.getWord();


        System.out.println("Hello, Welcome to Hangman..\n"
                + "Guess a letter or guess the word if you're feeling cocky\n"
                + "You have 6 lives, use them wisely :) \n");

        ArrayList<Character> letterGuesses = new ArrayList<>();
        DisplayWord displayWord = new DisplayWord();

        displayWord.displayWord(word, letterGuesses);

    }


}