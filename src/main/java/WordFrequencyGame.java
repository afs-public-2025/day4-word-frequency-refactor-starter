import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputStr){


        if (inputStr.split("\\s+").length==1) {
            return inputStr + " 1";
        } else {

            try {
            return buildResult(covertToWordFrequencyList(inputStr.split("\\s+")));
            } catch (Exception e) {
                return "Calculate Error";
            }
        }
    }

    private List<WordFrequency> covertToWordFrequencyList(String[] spitedWords) {
         return Arrays.stream(spitedWords).collect(Collectors.groupingBy(s -> s, Collectors.counting()))
           .entrySet().stream().map(
             entry -> new WordFrequency(entry.getKey(), entry.getValue().intValue())
           ).collect(Collectors.toList());
    }

    private String buildResult(List<WordFrequency> wordFrequencyList) {
        wordFrequencyList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());
        return wordFrequencyList.stream().map(
          wordFrequency -> wordFrequency.getWord() + " " +wordFrequency.getWordCount()
        ).collect(Collectors.joining("\n"));
    }
}
