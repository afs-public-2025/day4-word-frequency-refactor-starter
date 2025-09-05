import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputStr){
        String[] words = inputStr.split("\\s+");
        if (words.length == 1) {
            return inputStr + " 1";
        } else {
            try {
                Map<String, List<WordDetail>> wordListmap = getWordListMap(words);
                List<WordDetail> wordList = getWordList(wordListmap);
                wordList.sort((word1, word2) -> word2.getCount() - word1.getCount());
                return buildResult(wordList);
            } catch (Exception e) {
                return "Calculate Error";
            }
        }
    }

    private String buildResult(List<WordDetail> wordList) {
        return wordList.stream()
                .map(word -> word.getWord() + " " + word.getCount())
                .collect(Collectors.joining("\n"));
    }

    private List<WordDetail> getWordList(Map<String, List<WordDetail>> wordListmap) {
        return wordListmap.entrySet().stream()
                .map(entry -> new WordDetail(entry.getKey(), entry.getValue().size()))
                .collect(Collectors.toList());
    }

    private Map<String,List<WordDetail>> getWordListMap(String[] words) {
        List<WordDetail> wordList = Arrays.stream(words)
                .map(word -> new WordDetail(word, 1))
                .toList();
        return wordList.stream()
                .collect(Collectors.groupingBy(WordDetail::getWord));
    }
}
