import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputStr){
        String[] words = inputStr.split("\\s+");
        if (words.length==1) {
            return inputStr + " 1";
        } else {
            try {
                List<WordDetail> wordList = initWordList(words);
                Map<String, List<WordDetail>> wordListmap = getWordListMap(wordList);
                wordList = getWordList(wordListmap);
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
        List<WordDetail> wordlist = wordListmap.entrySet().stream()
                .map(entry -> new WordDetail(entry.getKey(), entry.getValue().size()))
                .collect(Collectors.toList());
        return wordlist;
    }

    private Map<String,List<WordDetail>> getWordListMap(List<WordDetail> wordList) {
        Map<String, List<WordDetail>> wordListmap = wordList.stream()
                .collect(Collectors.groupingBy(WordDetail::getWord));
        return wordListmap;
    }

    private List<WordDetail> initWordList(String[] inputArr){
        List<WordDetail> wordList = Arrays.stream(inputArr)
                .map(word -> new WordDetail(word, 1))
                .collect(Collectors.toList());
        return wordList;
    }
}
