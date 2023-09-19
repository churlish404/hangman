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
      PlayerMessages.welcomeMessage();

        while (true) {
            if (lives.checkLoss()) {
               PlayerMessages.outOfLivesMessage();
               currentGameState.displayHangMan(lives.getLivesRemaining());
                return false;
            }

            // print game state
            System.out.println(word);
            currentGameState.displayWord(word, letterGuesses);
            letterGuesses.displayGuesses();
            lives.printLives();
            currentGameState.displayHangMan(lives.getLivesRemaining());

            char guess = playerInput.getLetterGuess();
            // guess validation
            if (letterGuesses.hasAlreadyGuessed(guess)) {
                PlayerMessages.alreadyGuessedMessage(guess);
            }
            else if (letterGuesses.isNotANumber(guess)) {
                PlayerMessages.notANumberMessage();
            }

            // valid guess
            else {
                letterGuesses.addGuess(guess);
                if (word.contains(String.valueOf(guess))) {
                    PlayerMessages.correctLetterMessage(guess);
                    letterGuesses.incrementCorrectGuess();
                } else {
                    PlayerMessages.incorrectLetterMessage(guess);
                    currentGameState.displayWord(word, letterGuesses);
                    lives.loseLife();
                }
                if (hasGuessedAllCorrectLetters()) {
                    PlayerMessages.guessedAllLettersMessage(word);
                    return true;
                }
                // if correctly guessed three letters can try and guess word
                if (letterGuesses.getNumberOfCorrectGuesses() > 3) {
                    PlayerMessages.guessAWordMessage();
                    currentGameState.displayWord(word, letterGuesses);
                    String wordGuess = playerInput.getWordGuess();
                    if (Objects.equals(wordGuess, word)) {
                        PlayerMessages.correctWordGuessMessage(word);
                        return true;
                    } else {
                        PlayerMessages.incorrectWordGuessMessage();
                    }
                }
            }
        }
    }
    // was unsure where else I could put this
    private boolean hasGuessedAllCorrectLetters() {
        for (char letter : word.toCharArray()) {
            if (!letterGuesses.hasAlreadyGuessed(letter)) {
                return false;
            }
        }
        return true;
    }
}



