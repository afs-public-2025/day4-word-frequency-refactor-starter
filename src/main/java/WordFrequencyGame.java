import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputStr) {

        List<String> wordList = List.of(inputStr.split("\\s+"));

        if (wordList.size() == 1) {
            return String.format("%s %d", wordList.get(0), 1);
        }

        return "";
    }

    public Map<String, Integer> convertWordListToFrequencyMap(List<String> wordList) {
        return wordList.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.summingInt(e -> 1)));
    }

    public Map<String, Integer> sortMapByValue(Map<String, Integer> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    public String convertMapToResult(Map<String, Integer> map) {
        return map.entrySet()
                .stream()
                .map(entry -> entry.getKey() + " " + entry.getValue())
                .collect(Collectors.joining("\n"));
    }

}