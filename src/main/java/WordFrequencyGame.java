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
                //split the input string with 1 to n pieces of spaces
                String[] inputArr = inputStr.split("\\s+");
                List<Input> inputList = new ArrayList<>();
                inputList = splitInput(inputArr, inputList);

                //get the map for the next step of sizing the same word
                Map<String, List<Input>> map =getListMap(inputList);

                List<Input> list = new ArrayList<>();
                for (Map.Entry<String, List<Input>> entry : map.entrySet()){
                    Input input = new Input(entry.getKey(), entry.getValue().size());
                    list.add(input);
                }
                inputList = list;

                inputList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

                StringJoiner result = new StringJoiner("\n");
                for (Input resultList : inputList) {
                    String s = resultList.getValue() + " " +resultList.getWordCount();
                    result.add(s);
                }
                return result.toString();
            } catch (Exception e) {
                return "Calculate Error";
            }
        }
    }

    private Map<String,List<Input>> getListMap(List<Input> inputList) {
        Map<String, List<Input>> map = new HashMap<>();
        for (Input input :  inputList){
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

    public List<Input> splitInput(String[] inputArr, List<Input> inputList){
        //split the input string with 1 to n pieces of spaces
        for (String value : inputArr) {
            Input input = new Input(value, 1);
            inputList.add(input);
        }
        return inputList;
    }
}
