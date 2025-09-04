import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputStr){


        if (inputStr.split("\\s+").length==1) {
            return inputStr + " 1";
        } else {

            try {
            return buildResult(covertToInput(countSameWords(inputStr.split("\\s+"))));
            } catch (Exception e) {
                return "Calculate Error";
            }
        }
    }

    private Map<String,Long> countSameWords(String[] spitedWords) {
        return Arrays.stream(spitedWords).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }

    private List<WordFrequency> covertToInput(Map<String,Long> map) {
        List<WordFrequency> list = new ArrayList<>();
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            WordFrequency wordFrequency = new WordFrequency(entry.getKey(), entry.getValue().intValue());
            list.add(wordFrequency);
        }
        return list;
    }

    private String buildResult(List<WordFrequency> wordFrequencyList) {
        wordFrequencyList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());
        StringJoiner reu = new StringJoiner("\n");
        for (WordFrequency wordFrequency : wordFrequencyList) {
            String s = wordFrequency.getWord() + " " +wordFrequency.getWordCount();
            reu.add(s);
        }
        return reu.toString();
    }
}
