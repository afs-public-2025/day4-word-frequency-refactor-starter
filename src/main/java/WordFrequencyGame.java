import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputString) {
        try {
            Map<String, Integer> countMap = new HashMap<>();
            for (String s : inputString.split("\\s+")) {
                countMap.merge(s, 1, Integer::sum);
            }
            return countMap.entrySet().stream()
                    .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                    .map(entry -> entry.getKey() + " " + entry.getValue())
                    .collect(Collectors.joining("\n"));
        } catch (Exception e) {
            return "Calculate Error";
        }
    }
}
