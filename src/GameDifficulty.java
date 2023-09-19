public enum GameDifficulty {
    EASYPEASY(5),
    MEDIUMPEASY(6, 8),
    HARDPEASY(9, 20);

    private final int minWordLength;
    private final int maxWordLength;

    GameDifficulty(int minWordLength, int maxWordLength) {
        this.minWordLength = minWordLength;
        this.maxWordLength = maxWordLength;
    }

    GameDifficulty(int fixedWordLength) {
        this.minWordLength = fixedWordLength;
        this.maxWordLength = fixedWordLength;
    }

    public int getMinWordLength() {
        return minWordLength;
    }

    public int getMaxWordLength() {
        return maxWordLength;
    }
}
