public class WordFrequency {
    private final String word;
    private final int occurrence;

    public WordFrequency(String word, int occurrence){
        this.word = word;
        this.occurrence = occurrence;
    }

    public String getWord() {
        return this.word;
    }

    public int getWordOccurrence() {
        return this.occurrence;
    }


}
