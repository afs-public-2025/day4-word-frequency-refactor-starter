public class Word {
    private String word;
    private int wordCount;

    public Word(String word, int wordCount){
        this.word =word;
        this.wordCount =wordCount;
    }


    public String getValue() {
        return this.word;
    }

    public int getWordCount() {
        return this.wordCount;
    }


}
