import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputStr) {
        if (inputStr == null || inputStr.trim().isEmpty()) {
            return "";
        }

        List<String> words = splitIntoWords(inputStr);
        List<Word> wordFrequencies = calculateWordFrequencies(words);
        sortWordsByFrequency(wordFrequencies);
        return formatResult(wordFrequencies);
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

    private void sortWordsByFrequency(List<Word> words) {
        words.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());
    }

    private String formatResult(List<Word> words) {
        return words.stream()
                .map(w -> w.getValue() + " " + w.getWordCount())
                .collect(Collectors.joining("\n"));
    }
}


