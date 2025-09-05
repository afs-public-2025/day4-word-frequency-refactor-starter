import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputStr) {
        try {
            Map<String, Integer> wordsCountMap = getWordsFrequencyMap(inputStr);

            List<Word> wordsListSortedByCount = getSortedWordsList(wordsCountMap);

            return generateWordFrequencyInfo(wordsListSortedByCount);
        } catch (Exception e) {
            return "Calculate Error";
        }
    }

    private Map<String, Integer> getWordsFrequencyMap(String inputStr) {
        Map<String, Integer> wordsFrequencyMap = new HashMap<>();
        String[] wordsArray = inputStr.split("\\s+");
        for (String word : wordsArray) {
            wordsFrequencyMap.put(word, wordsFrequencyMap.getOrDefault(word, 0) + 1);
        }
        return wordsFrequencyMap;
    }

    private List<Word> getSortedWordsList(Map<String, Integer>wordsCountMap) {
        List<Word> wordsInfoSortedByCount = new ArrayList<>();
        wordsCountMap.forEach((word, count) -> {
            Word input = new Word(word, count);
            wordsInfoSortedByCount.add(input);
        });
        wordsInfoSortedByCount.sort((input1, input2) -> input2.getWordCount() - input1.getWordCount());
        return wordsInfoSortedByCount;
    }

    private String generateWordFrequencyInfo(List<Word> wordsListSortedByCount) {
        return wordsListSortedByCount.stream().map(info->info.getWordValue()+" "+info.getWordCount())
                .collect(Collectors.joining("\n"));
    }

}