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

                inputList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

                StringJoiner joiner = new StringJoiner("\n");
                for (WordFrequency w : inputList) {
                    String s = w.getWord() + " " +w.getWordCount();
                    joiner.add(s);
                }
                return joiner.toString();
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

        //get the map for the next step of sizing the same word
        Map<String, List<WordFrequency>> map = frequencyList.stream().collect(Collectors.groupingBy(word -> word.getWord()));

        return map;
    }

    private List<WordFrequency> calculatedWordFrequency (Map<String, List<WordFrequency>> map){
        List<WordFrequency> calculatedFrequencyList = new ArrayList<>();
        for (Map.Entry<String, List<WordFrequency>> entry : map.entrySet()){
            WordFrequency input = new WordFrequency(entry.getKey(), entry.getValue().size());
            calculatedFrequencyList.add(input);
        }
        return calculatedFrequencyList;
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
