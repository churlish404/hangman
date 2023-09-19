public class PlayerMessages {
    public static void welcomeMessage() {
        System.out.println("Hello & Welcome to Hangman...\n"
                + "Go ahead guess a letter, if you guess 4 letters you can try and guess the word\n"
                + "if you guess an incorrect letter, you will pay for it with....one of your 6 lives \n"
                + "Guess the word in time to spare the man from his demise! \n");
    }
    public static void guessAWordMessage() {
        System.out.println("You've guessed some correct letters.. feeling lucky?");
    }

    public static void outOfLivesMessage() {
        System.out.println("You have run out of lives \n"
                + "(stick man groans) 'Noooooooooooooooooooooo'");
    }

    public static void alreadyGuessedMessage(char letter) {
        System.out.println("You already guessed the letter '" + letter + "'. For not paying attention you lose a life.");
    }

    public static void notANumberMessage() {
        System.out.println("You cannot guess a number.");
    }

    public static void correctLetterMessage(char letter) {
        System.out.println("Nice one! '" + letter + "' is in the word.");
    }

    public static void incorrectLetterMessage(char letter) {
        System.out.println("Oh dear, '" + letter + "' is not in the word.");
    }

    public static void guessedAllLettersMessage(String word) {
        System.out.println("Well done! You've guessed all the letters. The word is: " + word);
    }

    public static void correctWordGuessMessage(String word) {
        System.out.println("Well done! '" + word + "' is correct.");
    }

    public void displayIncorrectWordGuessMessage () {
        System.out.println("That's incorrect, try again");
    }

    public static void incorrectWordGuessMessage() {
        System.out.println("That's incorrect. Try again.");
    }
}
