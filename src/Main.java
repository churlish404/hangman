import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        HangmanGame game = new HangmanGame();
        boolean win = game.play();

        if(win) {
            System.out.println("Congrats you won");
        }
        else {
            System.out.println("Sorry you lost ");
        }
    }
}