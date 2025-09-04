public class WordEntry {
    private final String word;
    private final int frequency;

    public WordEntry(String word, int frequency){
        this.word = word;
        this.frequency = frequency;
    }

    public String getWord() {
        return this.word;
    }

    public int getFrequency() {
        return this.frequency;
    }
}
