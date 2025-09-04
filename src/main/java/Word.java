public class Word {
    private final String wordValue;
    private final int wordFrequency;

    public Word(String wordValue, int wordFrequency) {
        this.wordValue = wordValue;
        this.wordFrequency = wordFrequency;
    }


    public String getWordValue() {
        return this.wordValue;
    }

    public int getWordCount() {
        return this.wordFrequency;
    }


}
