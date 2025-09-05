import java.util.*;
import java.io.CharArrayWriter;

import java.time.LocalDateTime;

import java.util.*;

public class WordFrequencyGame {
    public String getResult(String inputStr){

        String[] wordArr = inputStr.split("\\s+");

        Map<String, Integer> wordCountmap = getWordCountMap(wordArr);
        List<WordCount> wordCountList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCountmap.entrySet()){
            WordCount input = new WordCount(entry.getKey(), entry.getValue());
            wordCountList.add(input);
        }

        wordCountList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

        StringJoiner joiner = new StringJoiner("\n");
        for (WordCount word : wordCountList) {
            joiner.add(word.getValue() + " " + word.getWordCount());
        }
        return joiner.toString();

    }

    private Map<String, Integer> getWordCountMap(String[] wordArr) {
        Map<String, Integer> wordCountMap = new LinkedHashMap<>();
        for (String word : wordArr) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        return wordCountMap;
    }
}
