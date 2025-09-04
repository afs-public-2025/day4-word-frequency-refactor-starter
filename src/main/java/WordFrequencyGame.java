import java.util.*;
import java.io.CharArrayWriter;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputStr){


//        if (inputStr.split("\\s+").length==1) {
//            return inputStr + " 1";
//        } else {

            try {

//                //split the input string with 1 to n pieces of spaces
//                String[] words = inputStr.split("\\s+");
////
//
//                List<WordFrequency> collect = Arrays.stream(words)
//                        .map(word -> new WordFrequency(word, 1))
//                        .collect(Collectors.toList());
//
//                Map<String, List<WordFrequency>> collect1 =
//                        collect.stream().collect(Collectors.groupingBy(word -> word.getWord()));
//
//                //get the map for the next step of sizing the same word
//                Map<String, List<WordFrequency>> map =getListMap(inputList);
//
//                List<WordFrequency> list = new ArrayList<>();
//                for (Map.Entry<String, List<WordFrequency>> entry : map.entrySet()){
//                    WordFrequency input = new WordFrequency(entry.getKey(), entry.getValue().size());
//                    list.add(input);
//                }
//                inputList = list;

                Map<String, List<WordFrequency>> frequencyMap = countWordFrequency(inputStr);
                List<WordFrequency> inputList = calculatedWordFrequency(frequencyMap);

                return sortedOutput(inputList);
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

    private String sortedOutput (List<WordFrequency> inputList){

        return inputList.stream()
                .sorted((w1, w2) -> Integer.compare(w2.getWordCount(), w1.getWordCount()))
                .map(w -> w.getWord() + " " + w.getWordCount())
                .collect(Collectors.joining("\n"));
    }


//    private Map<String,List<WordFrequency>> getListMap(List<WordFrequency> frequencyList) {
//        Map<String, List<WordFrequency>> map = new HashMap<>();
//        for (WordFrequency input :  frequencyList){
////       map.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input);
//            if (!map.containsKey(input.getWord())){
//                ArrayList arr = new ArrayList<>();
//                arr.add(input);
//                map.put(input.getWord(), arr);
//            }
//
//            else {
//                map.get(input.getWord()).add(input);
//            }
//        }
//
//
//        return map;
//    }


}
