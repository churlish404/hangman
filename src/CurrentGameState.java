import java.util.ArrayList;

public class CurrentGameState {
    public void displayWord(String word, ArrayList<Character> letterGuesses) {
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (letterGuesses.contains(letter)) {
                System.out.print(letter + " ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println();
    }
}
