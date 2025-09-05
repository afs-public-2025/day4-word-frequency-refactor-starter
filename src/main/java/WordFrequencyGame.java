import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputString) throws Exception {
        if (inputString == null || inputString.trim().isEmpty()) {
            throw new Exception("Calculate Error");
        }
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : inputString.split("\\s+")) {
            countMap.merge(word, 1, Integer::sum);
        }
        return countMap.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .map(entry -> entry.getKey() + " " + entry.getValue())
                .collect(Collectors.joining("\n"));
    }
}
