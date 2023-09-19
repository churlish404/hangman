import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GenerateWord {
    private static final ArrayList<String> dictionary = new ArrayList<>();

    static {
        try {
            populateDictionary();
        } catch (FileNotFoundException error) {
            System.err.println("Dictionary file not found: " + error.getMessage());
        }
    }

    private static void populateDictionary() throws FileNotFoundException {
        Scanner fileReader = new Scanner(new File("src/Hangman_Library.txt"));
        while (fileReader.hasNextLine()) {
            dictionary.add(fileReader.nextLine());
        }
        fileReader.close();
    }
    private static boolean isWordValidForDifficulty(String word, GameDifficulty gameDifficulty) {
        int wordLength = word.length();
        return wordLength >= gameDifficulty.getMinWordLength() && wordLength <= gameDifficulty.getMaxWordLength();
    }

    public static String getWord(GameDifficulty gameDifficulty) {
        if (dictionary.isEmpty()) {
            throw new IllegalStateException("Dictionary is empty");
        }
        ArrayList<String> filteredWords = new ArrayList<>();
        for(String word : dictionary) {
            if(isWordValidForDifficulty(word, gameDifficulty)) {
                filteredWords.add(word);
            }
        }
        Random rand = new Random();
        int randomIndex = rand.nextInt(filteredWords.size());
        return filteredWords.get(randomIndex);
    }
}






