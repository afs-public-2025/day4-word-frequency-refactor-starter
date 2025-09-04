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
                .map(entry -> new WordFrequency(entry.getKey(), entry.getValue().intValue()))
                .sorted(Comparator.comparingInt(WordFrequency::getCount).reversed())
                .collect(Collectors.toList());
    }

    private String buildResultStr(List<WordFrequency> wordFrequencies) {
        return wordFrequencies.stream().map(WordFrequency::toString)
                .collect(Collectors.joining("\n"));
    }


}
