public class DisplayCurrentGameState {
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

    public void displayHangMan(int livesRemaining) {
        switch (livesRemaining) {
            case 0:
                System.out.println("  @=====@\n  |   \\|\n  O   ||\n /|\\  ||\n / \\  ||\n      ||\n=========");
                break;
            case 1:
                System.out.println("  @=====@\n  |   \\|\n  O   ||\n /|\\  ||\n /    ||\n      ||\n=========");
                break;
            case 2:
                System.out.println("  @=====@\n  |   \\|\n  O   ||\n /|\\  ||\n      ||\n      ||\n=========");
                break;
            case 3:
                System.out.println("  @=====@\n  |   \\|\n  O   ||\n /|   ||\n      ||\n      ||\n=========");
                break;
            case 4:
                System.out.println("  @=====@\n  |   \\|\n  O   ||\n  |   ||\n      ||\n      ||\n=========");
                break;
            case 5:
                System.out.println("  @=====@\n  |   \\|\n  O   ||\n      ||\n      ||\n      ||\n=========");
                break;
            case 6:
                System.out.println("  @=====@\n  |   \\|\n      ||\n      ||\n      ||\n      ||\n=========");
        }
    }
};