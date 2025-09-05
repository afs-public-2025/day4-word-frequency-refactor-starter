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
                // 大小写不同的word统一为小写
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
                .entrySet().stream()
                .map(entry -> new WordFrequency(entry.getKey(), entry.getValue().intValue()))
                .sorted(Comparator.comparingInt(WordFrequency::getCount).reversed())
                .collect(Collectors.toList());
    }

    private String buildResultStr(List<WordFrequency> wordFrequencies) {
        return wordFrequencies.stream().map(WordFrequency::toString)
                .collect(Collectors.joining("\n"));
    }


    public static void main(String[] args) {
        String inputStr = "the the is Hello Hello Hello Hello hello hello hello afhiaf awrwra afhiaf";
        WordFrequencyGame wordFrequencyGame = new WordFrequencyGame();
        System.out.println(wordFrequencyGame.getResult(inputStr));
    }

}
