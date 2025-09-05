import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputStr){
        if (inputStr.split("\\s+").length==1) {
            return inputStr + " 1";
        } else {
            try {
                String[] words = inputStr.split("\\s+");
                List<Word> wordsList=calculateWordFrequency(words);
                sortWordList(wordsList);

                return buildWordFrequencyResult(wordsList);
            } catch (Exception e) {
                return "Calculate Error";
            }
        }
    }

    private static String buildWordFrequencyResult(List<Word> wordsList) {
        return wordsList.stream()
                .map(word -> word.getValue() + " " + word.getWordCount())
                .collect(Collectors.joining("\n"));
    }

    private static void sortWordList(List<Word> wordsList) {
        wordsList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());
    }

    private  static  List<Word> calculateWordFrequency(String[] words){
        Map<String, Integer> wordFrequencyMap = countWordOccurrences(words);
        List<Word> wordsList = createWordList(wordFrequencyMap);
        return wordsList;
    }

    private static List<Word> createWordList(Map<String, Integer> wordFrequencyMap) {
        List<Word> wordsList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            wordsList.add(new Word(entry.getKey(), entry.getValue()));
        }
        return wordsList;
    }

    private static Map<String, Integer> countWordOccurrences(String[] words) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : words) {
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }
        return wordFrequencyMap;
    }

}
