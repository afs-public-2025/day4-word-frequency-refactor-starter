import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class WordFrequencyGame {

    public String getWordFrequency(String inputText) {
        if (inputText == null || inputText.trim().isEmpty()) {
            return "Input Error: Empty Input";
        }

        try {
            String[] words = inputText.split("\\s+");
            if (words.length == 1) {
                return inputText.trim() + " 1";
            }

            List<WordEntry> wordList = parseInputText(inputText);
            wordList = countFrequencies(wordList);
            sortByFrequencyDesc(wordList);
            return formatResult(wordList);
        } catch (Exception e) {
            return "Calculate Error";
        }
    }

    private Map<String, List<WordEntry>> groupWordsByName(List<WordEntry> wordEntries) {
        return wordEntries.stream()
          .collect(Collectors.groupingBy(WordEntry::getWord));
    }


    private List<WordEntry> parseInputText(String inputText) {
        return Arrays.stream(inputText.split("\\s+"))
          .map(word -> new WordEntry(word, 1))
          .collect(Collectors.toList());
    }

    private List<WordEntry> countFrequencies(List<WordEntry> wordList) {
        return groupWordsByName(wordList).entrySet().stream()
          .map(entry -> new WordEntry(entry.getKey(), entry.getValue().size()))
          .collect(Collectors.toList());
    }

    private void sortByFrequencyDesc(List<WordEntry> wordList) {
        wordList.sort((w1, w2) -> w2.getFrequency() - w1.getFrequency());
    }

    private String formatResult(List<WordEntry> wordList) {
        return wordList.stream()
            .map(entry -> entry.getWord() + " " + entry.getFrequency())
            .collect(Collectors.joining("\n"));
    }

    public String getResult(String inputStr) {
        return getWordFrequency(inputStr);
    }

}
