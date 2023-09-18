public class CurrentGameState {
    public void displayWord(String word, LetterGuesses letterGuesses) {
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (letterGuesses.hasAlreadyGuessed(letter)) {
                System.out.print(letter + " ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println();
    }

    public void displayIncorrectWordGuessMessage () {
        System.out.println("That's incorrect, try again");
    }

}
