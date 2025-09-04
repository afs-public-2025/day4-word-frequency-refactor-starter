import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordFrequencyGame {
    private static final String SPACE_REGEX = "\\s+";
    private static final String CALCULATE_ERROR = "Calculate Error";
    private static final int INITIAL_COUNT = 1;
    public String getResult(String inputStr){
        if (inputStr.split(SPACE_REGEX).length==1) {
            return inputStr + " 1";
        } else {
            try {
                List<WordFrequency> wordsArraySplitByRegex = getWordsArraySplitByRegex(inputStr);
                Map<String, List<WordFrequency>> classifiedWordFrequencyMap =groupWordFrequencyByWord(wordsArraySplitByRegex);
                List<WordFrequency> realWordFrequency = getRealWordFrequency(classifiedWordFrequencyMap);
                return joinWordSortedByFrequency(realWordFrequency);
            } catch (Exception e) {
                return CALCULATE_ERROR;
            }
        }
    }

    private List<WordFrequency> getWordsArraySplitByRegex(String targetString) {
        String[] wordsArraySplitByRegex = targetString.split(SPACE_REGEX);
        List<WordFrequency> wordFrequencyList = new ArrayList<>();
        Stream.of(wordsArraySplitByRegex).forEach(word -> {
            wordFrequencyList.add(new WordFrequency(word, INITIAL_COUNT));
        });
        return wordFrequencyList;
    }

    private List<WordFrequency> getRealWordFrequency(Map<String, List<WordFrequency>> classifiedWordFrequencyMap) {
        List<WordFrequency> realWordFrequency = classifiedWordFrequencyMap.entrySet().stream()
                .map(entry -> new WordFrequency(entry.getKey(), entry.getValue().size()))
                .collect(Collectors.toList());
        return realWordFrequency;

    }

    private String joinWordSortedByFrequency(List<WordFrequency> realWordFrequency){
        realWordFrequency.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

        StringJoiner joinerWordSortedByFrequency = new StringJoiner("\n");
        realWordFrequency.stream()
                .map(wordFrequency -> wordFrequency.getValue() + " " + wordFrequency.getWordCount())
                .forEach(joinerWordSortedByFrequency::add);
        return joinerWordSortedByFrequency.toString();
    }

    private Map<String,List<WordFrequency>> groupWordFrequencyByWord(List<WordFrequency> wordFrequencyList) {
        Map<String, List<WordFrequency>> classifiedWordFrequencyMap = new HashMap<>();
        for (WordFrequency wordFrequency : wordFrequencyList) {
            classifiedWordFrequencyMap
                    .computeIfAbsent(wordFrequency.getValue(), k -> new ArrayList<>())
                    .add(wordFrequency);
        }
        return classifiedWordFrequencyMap;

    }


}
