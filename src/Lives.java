public class Lives {
    private static final int NUMBER_OF_LIVES = 6;
    private int livesRemaining = NUMBER_OF_LIVES;

    public int getLivesRemaining() {
        return livesRemaining;
    }
    public void loseLife() {
        if (livesRemaining > 0) {
            livesRemaining--;
        }
    }
    public void printLives() {
        System.out.println(livesRemaining);
    }
    public boolean checkLoss() {
        return livesRemaining == 0;
    }
}
