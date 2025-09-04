import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputStr) {


        if (inputStr.split("\\s+").length == 1) {
            return inputStr + " 1";
        }

        if (inputStr.isBlank()) {
            return null;
        }

        try {
            return buildResultStr(calculateWordFrequency(inputStr));

        } catch (Exception e) {

            return "Calculate Error";
        }

    }


    private List<WordFrequency> calculateWordFrequency(String inputStr) {
        return Arrays.stream(inputStr.split("\\s+"))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet().stream()
                .sorted((w1, w2) -> Math.toIntExact(w2.getValue() - w1.getValue()))
                .map(wordFrequency -> new WordFrequency(wordFrequency.getKey(), wordFrequency.getValue().intValue()))
                .collect(Collectors.toList());
    }

    private String buildResultStr(List<WordFrequency> wordFrequencies) {
        StringJoiner joiner = new StringJoiner("\n");
        for (WordFrequency wordFrequency : wordFrequencies) {
            String s = wordFrequency.getWord() + " " + wordFrequency.getWordCount();
            joiner.add(s);
        }
        return joiner.toString();
    }


}
