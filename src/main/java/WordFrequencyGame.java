import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.io.CharArrayWriter;

import java.time.LocalDateTime;

public class WordFrequencyGame {
    public String processSingleWordInput(String inputStr) {
        if (inputStr.split("\\s+").length == 1) {
            return inputStr + " 1"; // 返回单词和数字 1
        }
        return null;
    }
    public List<Input> processMultipleWords(String inputStr) {
        String[] wordsArray = inputStr.split("\\s+");

        List<Input> inputList = new ArrayList<>();
        for (String word : wordsArray) {
            Input input = new Input(word, 1);
            inputList.add(input);
        }
        //get the map for the next step of sizing the same word
        Map<String, List<Input>> map =getListMap(inputList);

        List<Input> wordList = new ArrayList<>();
        for (Map.Entry<String, List<Input>> entry : map.entrySet()){
            Input input = new Input(entry.getKey(), entry.getValue().size());
            wordList.add(input);
        }

        return wordList;
    }

    public String getSameWord(String inputStr){
        String singleWorld=processSingleWordInput(inputStr);

        if (singleWorld!=null) {
            return singleWorld;
        } else {
            try {
                List<Input> inputList=processMultipleWords(inputStr);
                inputList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

                StringJoiner joiner = new StringJoiner("\n");
                for (Input w : inputList) {
                    String s = w.getValue() + " " +w.getWordCount();
                    joiner.add(s);
                }
                return joiner.toString();
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


}
