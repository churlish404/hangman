import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        String word = GenerateWord.getWord();

        System.out.println("Hello, Welcome to Hangman..\n"
                + "Guess a letter and then guess the word if you're feeling cocky\n"
                + "You have 6 lives if you guess an incorrect letter you will lose a life \n"
                + "Guess the word in time to spare the man from his demise!");

        CurrentGameState currentGameState = new CurrentGameState();
        PlayerInput playerInput = new PlayerInput();
        Lives playerLives = new Lives();
        LetterGuesses letterGuesses = new LetterGuesses();

        while (true) {
            // check have enough lives if don't then break
            if (playerLives.checkLoss()) {
                System.out.println("You have run out of lives \n"
                + "Bye Bye stick man");
                break;
            }

            // print game state
            System.out.println(word);
            currentGameState.displayWord(word, letterGuesses);
            letterGuesses.displayGuesses(); // Display guessed letters.

            // ask user to guess letter
            char guess = playerInput.getLetterGuess();

            // if letter exists in guesses display a message "already guessed x"
            if (letterGuesses.hasGuessed(guess)) {
                System.out.println("You already guessed this letter silly");
            } else {
                letterGuesses.addGuess(guess);
                if (word.contains(String.valueOf(guess))) {
                    System.out.println("Nice one! that's in the word");
                    currentGameState.displayWord(word, letterGuesses);
                } else {
                    System.out.println("Oh dear, that's not correct!");
                    currentGameState.displayWord(word, letterGuesses);
                    playerLives.loseLife();
                }

                playerLives.printLives();
                String wordGuess = playerInput.getWordGuess();
                if (Objects.equals(wordGuess, word)) {
                    System.out.println(word + " is correct");
                    break;
                }
                else {
                    currentGameState.displayIncorrectWordGuessMessage();
                }
            }
        }
    }
}