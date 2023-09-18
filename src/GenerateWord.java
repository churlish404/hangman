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
        Scanner fileReader = new Scanner(new File("src/Hangman_Dictionary.txt"));
        while (fileReader.hasNextLine()) {
            dictionary.add(fileReader.nextLine());
        }
        fileReader.close();
    }

    public static String getWord() {
        if (dictionary.isEmpty()) {
            throw new IllegalStateException("Dictionary is empty");
        }
        Random rand = new Random();
        int randomIndex = rand.nextInt(dictionary.size());
        return dictionary.get(randomIndex);
    }
}






