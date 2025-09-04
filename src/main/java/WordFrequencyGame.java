import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputStr) {
        return null;
    }

    private List<String> splitIntoWords(String inputStr) {
        return Arrays.asList(inputStr.split("\\s+"));
    }

    private List<Word> calculateWordFrequencies(List<String> words) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        List<Word> wordFrequencies = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            wordFrequencies.add(new Word(entry.getKey(), entry.getValue()));
        }

        return wordFrequencies;
    }
}


