import java.util.*;
import java.io.CharArrayWriter;

import java.time.LocalDateTime;

public class WordFrequencyGame {
    public String buildWordFrequencyGameResult(String inputStr){
        if(inputStr.split("\\s+").length==1){
            return inputStr + " 1";
        }
        else{
            try {
                List<WordFrequency> sourceWordFrequencyList = convertWordFrequencyMapToSortedWordFrequencyList(
                        splitStringToWordFrequencyMap(inputStr)
                );
                StringJoiner resultBuilder = new StringJoiner("\n");
                sourceWordFrequencyList.stream().forEach((wordFrequency) -> {
                    resultBuilder.add(wordFrequency.getWord() + " " + wordFrequency.getOccurrenceFrequency());
                });
                return resultBuilder.toString();
            } catch (Exception e) {
                return "Calculate Error";
            }
        }



//        if (inputStr.split("\\s+").length==1) {
//            return inputStr + " 1";
//        } else {
//
//            try {
//
//                //split the input string with 1 to n pieces of spaces
//                String[] arr = inputStr.split("\\s+");
//
//                List<Input> inputList = new ArrayList<>();
//                for (String s : arr) {
//                    Input input = new Input(s, 1);
//                    inputList.add(input);
//                }
//
//                //get the map for the next step of sizing the same word
//                Map<String, List<Input>> map =getListMap(inputList);
//
//                List<Input> list = new ArrayList<>();
//                for (Map.Entry<String, List<Input>> entry : map.entrySet()){
//                    Input input = new Input(entry.getKey(), entry.getValue().size());
//                    list.add(input);
//                }
//                inputList = list;
//
//                inputList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());
//
//                StringJoiner joiner = new StringJoiner("\n");
//                for (Input w : inputList) {
//                    String s = w.getValue() + " " +w.getWordCount();
//                    joiner.add(s);
//                }
//                return joiner.toString();
//            } catch (Exception e) {
//
//
//                return "Calculate Error";
//            }
//        }
    }


//    private Map<String,Integer> getListMap(List<WordFrequency> sourceWordFrequencyList) {
//        Map<String, Integer> targetWordFrequencyMap = new HashMap<>();
//        sourceWordFrequencyList.stream().forEach((wordFrequency)->{
//            if (!targetWordFrequencyMap.containsKey(wordFrequency.getWord())){
//                ArrayList<WordFrequency> tempW
//                targetWordFrequencyMap.put(wordFrequency.getWord(), )
//            }
//        });
//        /*for (Input input :  inputList){
////       map.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input);
//            if (!map.containsKey(input.getValue())){
//                ArrayList arr = new ArrayList<>();
//                arr.add(input);
//                map.put(input.getValue(), arr);
//            }
//
//            else {
//                map.get(input.getValue()).add(input);
//            }
//        }*/
//
//
//        return wordFrequencyMap;
//    }


    private static Map<String,Integer> splitStringToWordFrequencyMap(String sourceString){
        String[] sourceWordArray=sourceString.split("\\s+");
        Map<String, Integer> targetWordFrequencyMap = new HashMap<>();
        Arrays.stream(sourceWordArray).forEach((word)->{
            targetWordFrequencyMap.put(word, targetWordFrequencyMap.getOrDefault(word,0)+1);
        });
        return targetWordFrequencyMap;
    }
    private static List<WordFrequency> convertWordFrequencyMapToSortedWordFrequencyList(Map<String,Integer> sourceWordFrequencyMap){
        List<WordFrequency> targetWordFrequencyList=new ArrayList<>();
        sourceWordFrequencyMap.keySet().stream().forEach((word)->{
            targetWordFrequencyList.add(new WordFrequency(word,sourceWordFrequencyMap.get(word)));
        });
        targetWordFrequencyList.sort((w1, w2) -> w2.getOccurrenceFrequency() - w1.getOccurrenceFrequency());
        return targetWordFrequencyList;
    }





}
