import java.util.Objects;

public class HangmanGame {
    public String word;
    public LetterGuesses letterGuesses;
    public Lives lives;
    public CurrentGameState currentGameState;
    public PlayerInput playerInput;

    public HangmanGame() {
        this.word = GenerateWord.getWord();
        this.letterGuesses = new LetterGuesses();
        this.lives = new Lives();
        this.currentGameState = new CurrentGameState();
        this.playerInput = new PlayerInput();
    }

    public boolean play() {
        System.out.println("Hello, Welcome to Hangman...\n"
                + "Guess a letter and then guess the word if you're feeling cocky\n"
                + "You have 6 lives if you guess an incorrect letter you will lose a life \n"
                + "Guess the word in time to spare the man from his demise! \n");

        while (true) {
            if (lives.checkLoss()) {
                System.out.println("You have run out of lives \n"
                        + "Bye Bye stick man");
                return false; // Game over, player lost
            }

            // print game state
            System.out.println(word);
            currentGameState.displayWord(word, letterGuesses);
            letterGuesses.displayGuesses(); // Display guessed letters.

            // ask user to guess letter
            char guess = playerInput.getLetterGuess();

            // if letter exists in guesses display a message "already guessed x"
            if (letterGuesses.hasAlreadyGuessed(guess)) {
                System.out.println("You already guessed this letter silly");
            }
            // check is not a number
            else if (letterGuesses.isNotANumber(guess)) {
                System.out.println("You cannot guess a number");
            }
            // newly guessed letter
            else {
                letterGuesses.addGuess(guess);
                if (word.contains(String.valueOf(guess))) {
                    System.out.println("Nice one! That's in the word");
                    letterGuesses.incrementCorrectGuess();
                } else {
                    System.out.println("Oh dear, that's not correct!");
                    currentGameState.displayWord(word, letterGuesses);
                    lives.loseLife();
                }
                if (hasGuessedAllCorrectLetters()) {
                    System.out.println("Well done you guessed all the letters! " + word + " is correct");
                    return true;
                }
                lives.printLives();
                if (letterGuesses.getNumberOfCorrectGuesses() > 3) {
                    System.out.println("You've guessed some correct letters.. feeling lucky?");
                    String wordGuess = playerInput.getWordGuess();
                    if (Objects.equals(wordGuess, word)) {
                        System.out.println("Well done! " + word + " is correct");
                        return true;
                    } else {
                        currentGameState.displayIncorrectWordGuessMessage();
                    }
                }
            }
        }
    }
    private boolean hasGuessedAllCorrectLetters() {
        for (char letter : word.toCharArray()) {
            if (!letterGuesses.hasAlreadyGuessed(letter)) {
                return false;
            }
        }
        return true;
    }
}



