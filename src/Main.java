import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String word = GenerateWord.getWord();

        System.out.println("Hello, Welcome to Hangman..\n"
                + "Guess a letter or guess the word if you're feeling cocky\n"
                + "You have 6 lives, use them wisely :) \n");

        ArrayList<Character> letterGuesses = new ArrayList<>();
        CurrentGameState currentGameState = new CurrentGameState();
        Lives playerLives = new Lives();


        while(true) {
            // check have enough lives if don't then break
            playerLives.checkLoss();
            // print game state
            currentGameState.displayWord(word, letterGuesses);
            // ask user to guess letter

            //read user input
            // if letter exists in guesses display a message "already guessed x"
            // else add to guesses list
            // if correct guess feed back to user
            // if incorrect feedback to user and remove a life
            // ask user to guess word
            // if word is correct break
            break;
        }

    }


}