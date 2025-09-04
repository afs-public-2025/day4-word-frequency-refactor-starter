import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class WordFrequencyGame {
    public String getResult(String inputStr){

        if (inputStr == null || inputStr.trim().isEmpty()) {
            return "Calculate Error";
        }
        return "";

    }
    private List<WordFrequency> countWordFrequencies(String inputStr) {
        String[] words = inputStr.split("\\s+");
        List<WordFrequency> wordFrequencyList = new ArrayList<>();
        for(String word : words) {
            WordFrequency wordFrequency = findWordFrequency(wordFrequencyList, word);
            if (wordFrequency == null) {
                wordFrequencyList.add(new WordFrequency(word, 1));
            } else {
                wordFrequency.incrementFrequency();
            }
        }
        return wordFrequencyList;
    }
    private WordFrequency findWordFrequency(List<WordFrequency> wordFrequencyList, String word) {
        for (WordFrequency wordFrequency : wordFrequencyList) {
            if (wordFrequency.getWord().equals(word)) {
                return wordFrequency;
            }
        }
        return null;
    }
    private String buildResultString(List<WordFrequency> wordFrequencyList) {
        StringJoiner result = new StringJoiner("\n");
        for (WordFrequency wordFrequency : wordFrequencyList) {
            result.add(wordFrequency.getWord() + " " + wordFrequency.getFrequency());
        }
        return result.toString();
    }


}
