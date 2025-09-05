import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class WordFrequencyGame {
    public String getResult(String inputStr){
        if (inputStr == null || inputStr.trim().isEmpty()) {
            return "Calculate Error";
        }
        List<WordFrequency> wordFrequencyList = countWordFrequencies(inputStr);
        wordFrequencyList.sort((w1,w2)-> w2.getFrequency()- w1.getFrequency());
        return buildResultString(wordFrequencyList);

    }
    private List<WordFrequency> countWordFrequencies(String inputStr) {
        String[] words = inputStr.split("\\s+");
        List<WordFrequency> wordFrequencyList = new ArrayList<>();
        for(String word : words) {
            String lowerCasedWord = word.toLowerCase();
            WordFrequency wordFrequency = findWordFrequency(wordFrequencyList, lowerCasedWord);
            if (wordFrequency == null) {
                wordFrequencyList.add(new WordFrequency(lowerCasedWord, 1));
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
