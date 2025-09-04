import java.util.*;

public class WordFrequencyGame {
    public String getResult(String inputString) {
        try {
            Map<String, Integer> countMap = new HashMap<>();
            for (String s : inputString.split("\\s+")) {
                countMap.merge(s, 1, Integer::sum);
            }
            List<Map.Entry<String, Integer>> entries = new ArrayList<>(countMap.entrySet());
            entries.sort((e1, e2) -> e2.getValue() - e1.getValue());

            StringJoiner result = new StringJoiner("\n");
            for (Map.Entry<String, Integer> map : entries) {
                String s = map.getKey() + " " + map.getValue();
                result.add(s);
            }
            return result.toString();
        } catch (Exception e) {
            return "Calculate Error";
        }
    }
}
