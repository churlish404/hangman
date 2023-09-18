import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

GenerateWord gameWord = new GenerateWord();

String word = gameWord.getWord();
System.out.println(word);


    }
}