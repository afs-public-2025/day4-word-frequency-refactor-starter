import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class WordFrequencyGame {

    public String getWordFrequency(String inputText) {
        if (isSingleWord(inputText)) {
            return inputText + " 1";
        } else {
            return calculateWordFrequency(inputText);
        }
    }

    private Map<String, List<Input>> groupWordsByName(List<Input> wordEntries) {
        Map<String, List<Input>> wordGroups = new HashMap<>();
        for (Input entry : wordEntries) {
            wordGroups.computeIfAbsent(entry.getWord(), k -> new ArrayList<>()).add(entry);
        }
        return wordGroups;
    }

    public boolean isSingleWord(String inputText) {
        return inputText.split("\\s+").length == 1;
    }

    public String calculateWordFrequency(String inputText) {
        try {
            List<Input> wordList = parseInputText(inputText);
            wordList = countFrequencies(wordList);
            sortByFrequencyDesc(wordList);
            return formatResult(wordList);
        } catch (Exception e) {
            return "Calculate Error";
        }
    }

    private List<Input> parseInputText(String inputText) {
        String[] words = inputText.split("\\s+");
        List<Input> wordEntries = new ArrayList<>();
        for (String word : words) {
            wordEntries.add(new Input(word, 1));
        }
        return wordEntries;
    }

    private List<Input> countFrequencies(List<Input> wordList) {
        Map<String, List<Input>> wordGroups = groupWordsByName(wordList);

        List<Input> result = new ArrayList<>();
        for (Map.Entry<String, List<Input>> entry : wordGroups.entrySet()) {
            result.add(new Input(entry.getKey(), entry.getValue().size()));
        }
        return result;
    }

    private void sortByFrequencyDesc(List<Input> wordList) {
        wordList.sort((w1, w2) -> w2.getFrequency() - w1.getFrequency());
    }

    private String formatResult(List<Input> wordList) {
        StringJoiner joiner = new StringJoiner("\n");
        for (Input wordEntry : wordList) {
            joiner.add(wordEntry.getWord() + " " + wordEntry.getFrequency());
        }
        return joiner.toString();
    }

    public String getResult(String inputStr) {
        return getWordFrequency(inputStr);
    }

}
