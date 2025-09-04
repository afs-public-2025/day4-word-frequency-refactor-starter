import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class WordFrequencyGame {
    public String getResult(String inputStr) {
        try {
            Map<String, Integer> wordsCountMap = getWordsCountMap(inputStr);

            List<Word> wordsInfoSortedByCount = getSortedInputList(wordsCountMap);

            return generateWordFrequencyInfo(wordsInfoSortedByCount);
        } catch (Exception e) {
            return "Calculate Error";
        }
    }

    private Map<String, Integer> getWordsCountMap(String inputStr) {
        Map<String, Integer> wordsCountMap = new HashMap<>();
        String[] wordsArray = inputStr.split("\\s+");
        for (String word : wordsArray) {
            wordsCountMap.put(word, wordsCountMap.getOrDefault(word, 0) + 1);
        }
        return wordsCountMap;
    }

    private List<Word> getSortedInputList(Map<String, Integer>wordsCountMap) {
        List<Word> wordsInfoSortedByCount = new ArrayList<>();
        wordsCountMap.forEach((word, count) -> {
            Word input = new Word(word, count);
            wordsInfoSortedByCount.add(input);
        });
        wordsInfoSortedByCount.sort((input1, input2) -> input2.getWordCount() - input1.getWordCount());
        return wordsInfoSortedByCount;
    }

    private String generateWordFrequencyInfo(List<Word> inputList) {
        StringJoiner wordFrequencyInfo = new StringJoiner("\n");
        for (Word word : inputList) {
            String wordAndCount = word.getWordValue() + " " + word.getWordCount();
            wordFrequencyInfo.add(wordAndCount);
        }
        return wordFrequencyInfo.toString();
    }

//private Map<String, List<Input>> getListMap(List<Input> inputList) {
//    Map<String, List<Input>> map = new HashMap<>();
//    for (Input input : inputList) {
////       map.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input);
//        if (!map.containsKey(input.getValue())) {
//            ArrayList arr = new ArrayList<>();
//            arr.add(input);
//            map.put(input.getValue(), arr);
//        } else {
//            map.get(input.getValue()).add(input);
//        }
//    }
//
//
//    return map;
//}
}