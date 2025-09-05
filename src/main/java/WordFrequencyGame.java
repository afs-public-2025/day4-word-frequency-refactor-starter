import java.util.*;
import java.io.CharArrayWriter;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputStr){

            try {


                Map<String, List<WordFrequency>> frequencyMap = countWordFrequency(inputStr);
                List<WordFrequency> frequencyList = calculatedWordFrequency(frequencyMap);

                return sortedOutput(frequencyList);
            } catch (Exception e) {


                return "Calculate Error";
            }
//        }
    }

    private Map<String, List<WordFrequency>> countWordFrequency (String inputStr){
        //split the input string with 1 to n pieces of spaces
        String[] words = inputStr.split("\\s+");

        List<WordFrequency> frequencyList = Arrays.stream(words)
                .map(word -> new WordFrequency(word, 1))
                .collect(Collectors.toList());

        Map<String, List<WordFrequency>> map = frequencyList.stream().collect(Collectors.groupingBy(word -> word.getWord()));

        return map;
    }

    private List<WordFrequency> calculatedWordFrequency (Map<String, List<WordFrequency>> map){

        return map.entrySet().stream()
                .map(entry -> new WordFrequency(entry.getKey(),
                        entry.getValue() != null ? entry.getValue().size() : 0))
                .collect(Collectors.toList());
    }

    private String sortedOutput (List<WordFrequency> frequencyList){

        return frequencyList.stream()
                .sorted((w1, w2) -> Integer.compare(w2.getWordCount(), w1.getWordCount()))
                .map(w -> w.getWord() + " " + w.getWordCount())
                .collect(Collectors.joining("\n"));
    }



}
