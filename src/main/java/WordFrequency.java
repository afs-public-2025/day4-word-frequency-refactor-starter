public class WordFrequency {
    private String word;
    private int occurrenceFrequency;

    public WordFrequency(String word, int occurrenceFrequency){
        this.word=word;
        this.occurrenceFrequency=occurrenceFrequency;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getOccurrenceFrequency() {
        return occurrenceFrequency;
    }

    public void setOccurrenceFrequency(int occurrenceFrequency) {
        this.occurrenceFrequency = occurrenceFrequency;
    }
}
