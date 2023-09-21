import java.util.Objects;

public class HangmanGame {
    private String word;
    private LetterGuesses letterGuesses;
    private Lives lives;
    private DisplayCurrentGameState currentGameState;
    private PlayerInput playerInput;

    public HangmanGame(GameDifficulty gameDifficulty) {
        this.word = GenerateWord.getWord(gameDifficulty);
        this.letterGuesses = new LetterGuesses();
        this.lives = new Lives();
        this.currentGameState = new DisplayCurrentGameState();
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
            currentGameState.displayWord(word, letterGuesses);
            letterGuesses.displayGuesses();
            lives.printLives();
            currentGameState.displayHangMan(lives.getLivesRemaining());

            char guess = playerInput.getLetterGuess();
            // guess validation
            if (letterGuesses.hasAlreadyGuessed(guess)) {
                PlayerMessages.alreadyGuessedMessage(guess);
                lives.loseLife();
            }
            else if (letterGuesses.isNotANumber(guess)) {
                PlayerMessages.notANumberMessage();
            }

            // valid guess
            else {
                letterGuesses.addGuess(guess);
                if (word.contains(String.valueOf(guess).toLowerCase())) {
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
                // if correctly guessed four different letters can try and guess word
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
    private boolean hasGuessedAllCorrectLetters() {
        for (char letter : word.toCharArray()) {
            if (!letterGuesses.hasAlreadyGuessed(letter)) {
                return false;
            }
        }
        return true;
    }
}



