public class Word {
    private final String wordValue;
    private final int wordCount;

    public Word(String wordValue, int wordCount) {
        this.wordValue = wordValue;
        this.wordCount = wordCount;
    }


    public String getWordValue() {
        return this.wordValue;
    }

    public int getWordCount() {
        return this.wordCount;
    }


}
