import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputStr){
        try {
            List<String> extractedWords = Arrays.stream(inputStr.split("\\s+")).toList();
            Map<String, Long> frequencyMap = buildWordFrequencyMap(extractedWords);
            frequencyMap = sortWordFrequencyMap(frequencyMap);
            return buildFrequencyResult(frequencyMap);
        } catch (Exception e) {
            return "Calculate Error";
        }
    }

    private Map<String, Long> buildWordFrequencyMap(List<String> extractedWords) {
        return extractedWords.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private Map<String, Long> sortWordFrequencyMap(Map<String, Long> wordFrequencyMap) {
        return wordFrequencyMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    private String buildFrequencyResult(Map<String, Long> frequencyMap) {
        StringJoiner frequencyResult = new StringJoiner("\n");
        for (Map.Entry<String, Long> wordToFrequency: frequencyMap.entrySet()) {
            frequencyResult.add(wordToFrequency.getKey() + " " + wordToFrequency.getValue());
        }
        return frequencyResult.toString();
    }
}
