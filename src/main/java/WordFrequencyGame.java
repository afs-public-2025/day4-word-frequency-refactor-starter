import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class WordFrequencyGame {
//    public String getResult(String inputStr){
//
//
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
//    }
    private List<WordFrequency> countWordFrequencies(String inputStr) {
        String[] words = inputStr.split("\\s+");
        List<WordFrequency> wordFrequencyList = new ArrayList<>();
        for(String word : words) {
            word = word.toLowerCase();
            WordFrequency wordFrequency = findWordFrequency(wordFrequencyList, word);
            if (wordFrequency == null) {
                wordFrequencyList.add(new WordFrequency(word, 1));
            } else {
                wordFrequency.incrementFrequency();
            }
        }
        return wordFrequencyList;
    }
    private WordFrequency findWordFrequency(List<WordFrequency> wordFrequencyList, String word) {
        for (WordFrequency wordFrequency : wordFrequencyList) {
            if (wordFrequency.getWord().equals(word)) {
                return wordFrequency;
            }
        }
        return null;
    }


}
