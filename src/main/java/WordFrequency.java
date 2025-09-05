public class WordFrequency {
    private final String word;
    private int frequency;

    public WordFrequency(String word, int frequency){
        this.word =word;
        this.frequency =frequency;
    }

    public String getWord() {
        return this.word;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public void incrementFrequency() {
        this.frequency++;
    }


}
