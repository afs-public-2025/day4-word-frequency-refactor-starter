import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputStr) {

        List<String> words = List.of(inputStr.split("\\s+"));

        if (words.size() == 1) {
            return String.format("%s %d", words.get(0), 1);
        }

        Map<String, Integer> frequencyMap = words.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.summingInt(e -> 1)));

        Map<String, Integer> sortedMap = frequencyMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, // Handle key collisions (not needed here)
                        LinkedHashMap::new // Maintain insertion order
                ));

        return sortedMap.entrySet()
                .stream()
                .map(entry -> entry.getKey() + " " + entry.getValue())
                .collect(Collectors.joining("\n"));
    }

    public Map<Object, Long> convertWordsToMap(Map<Object, Long> map) {

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);

        return map;
    }


}