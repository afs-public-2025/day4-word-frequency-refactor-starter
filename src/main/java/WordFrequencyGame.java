import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.io.CharArrayWriter;

import java.time.LocalDateTime;

public class WordFrequencyGame {
    public String getResult(String inputStr){




        //split the input string with 1 to n pieces of spaces
        String[] arr = inputStr.split("\\s+");

        List<WordCount> inputList = new ArrayList<>();
        for (String s : arr) {
            WordCount input = new WordCount(s, 1);
            inputList.add(input);
        }

        //get the map for the next step of sizing the same word
        Map<String, List<WordCount>> map =getListMap(inputList);

        List<WordCount> list = new ArrayList<>();
        for (Map.Entry<String, List<WordCount>> entry : map.entrySet()){
            WordCount input = new WordCount(entry.getKey(), entry.getValue().size());
            list.add(input);
        }
        inputList = list;

        inputList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

        StringJoiner joiner = new StringJoiner("\n");
        for (WordCount w : inputList) {
            String s = w.getValue() + " " +w.getWordCount();
            joiner.add(s);
        }
        return joiner.toString();

    }


    private Map<String,List<WordCount>> getListMap(List<WordCount> inputList) {
        Map<String, List<WordCount>> map = new HashMap<>();
        for (WordCount input :  inputList){
//       map.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input);
            if (!map.containsKey(input.getValue())){
                ArrayList arr = new ArrayList<>();
                arr.add(input);
                map.put(input.getValue(), arr);
            }

            else {
                map.get(input.getValue()).add(input);
            }
        }


        return map;
    }


}
