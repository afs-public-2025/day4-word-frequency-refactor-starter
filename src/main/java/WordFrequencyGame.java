import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.io.CharArrayWriter;

import java.time.LocalDateTime;

public class WordFrequencyGame {
    public String getResult(String inputStr){


        if (inputStr.split("\\s+").length==1) {
            return inputStr + " 1";
        } else {

            try {

//                //split the input string with 1 to n pieces of spaces
//                String[] words = inputStr.split("\\s+");
//
//                List<WordFrequency> inputList = new ArrayList<>();
//                for (String s : words) {
//                    WordFrequency input = new WordFrequency(s, 1);
//                    inputList.add(input);
//                }
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

                List<WordFrequency> inputList = countWordFrequency(inputStr);

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
        }
    }

    private List<WordFrequency> countWordFrequency (String inputStr){
        //split the input string with 1 to n pieces of spaces
        String[] words = inputStr.split("\\s+");

        List<WordFrequency> frequencyList = new ArrayList<>();
        for (String s : words) {
            WordFrequency input = new WordFrequency(s, 1);
            frequencyList.add(input);
        }

        //get the map for the next step of sizing the same word
        Map<String, List<WordFrequency>> map =getListMap(frequencyList);

        List<WordFrequency> list = new ArrayList<>();
        for (Map.Entry<String, List<WordFrequency>> entry : map.entrySet()){
            WordFrequency input = new WordFrequency(entry.getKey(), entry.getValue().size());
            list.add(input);
        }

        return list;
    }


    private Map<String,List<WordFrequency>> getListMap(List<WordFrequency> frequencyList) {
        Map<String, List<WordFrequency>> map = new HashMap<>();
        for (WordFrequency input :  frequencyList){
//       map.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input);
            if (!map.containsKey(input.getWord())){
                ArrayList arr = new ArrayList<>();
                arr.add(input);
                map.put(input.getWord(), arr);
            }

            else {
                map.get(input.getWord()).add(input);
            }
        }


        return map;
    }


}
