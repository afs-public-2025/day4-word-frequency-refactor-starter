import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputStr){
        try {
            String[] words = inputStr.trim().split("\\s+");
            Map<String, Integer> wordCountMap = new HashMap<>();
            for (String word : words) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
            return wordCountMap.entrySet().stream()
                    .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                    .map(entry -> entry.getKey() + " " + entry.getValue())
                    .collect(Collectors.joining("\n"));
        } catch (Exception e) {
            return "Calculate Error";
        }
    }
}
