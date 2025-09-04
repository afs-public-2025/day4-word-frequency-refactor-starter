import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class WordFrequencyGame {
    public String processSingleWordFrequency(String inputStr) {
        if (inputStr.split("\\s+").length == 1) {
            return inputStr + " 1"; // 返回单词和数字 1
        }
        return null;
    }
    public List<WordFrequency> processMultipleWordsFrequency(String inputStr) {
        String[] wordsArray = inputStr.split("\\s+");

        List<WordFrequency> wordFrequencyList = new ArrayList<>();
        for (String word : wordsArray) {
            WordFrequency wordFrequency = new WordFrequency(word, 1);
            wordFrequencyList.add(wordFrequency);
        }
        //get the map for the next step of sizing the same word
        Map<String, List<WordFrequency>> wordFrequencyMap =getListMap(wordFrequencyList);

        List<WordFrequency> wordFinalList = new ArrayList<>();
        for (Map.Entry<String, List<WordFrequency>> entry : wordFrequencyMap.entrySet()){
            WordFrequency wordFrequency = new WordFrequency(entry.getKey(), entry.getValue().size());
            wordFinalList.add(wordFrequency);
        }

        return wordFinalList;
    }

    public String processWordFormat(String inputStr){
        String singleWorld= processSingleWordFrequency(inputStr);
        if (singleWorld!=null) {
            return singleWorld;
        } else {
            try {
                List<WordFrequency> wordFrequencyList = processMultipleWordsFrequency(inputStr);
                wordFrequencyList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());
                StringJoiner joiner = new StringJoiner("\n");
                for (WordFrequency w : wordFrequencyList) {
                    String s = w.getValue() + " " +w.getWordCount();
                    joiner.add(s);
                }
                return joiner.toString();
            } catch (Exception e) {

                return "Calculate Error";
            }
        }
    }


    private Map<String,List<WordFrequency>> getListMap(List<WordFrequency> wordFrequencyList) {
        Map<String, List<WordFrequency>> map = new HashMap<>();
        for (WordFrequency wordFrequency : wordFrequencyList){
            if (!map.containsKey(wordFrequency.getValue())){
                ArrayList wordlist = new ArrayList<>();
                wordlist.add(wordFrequency);
                map.put(wordFrequency.getValue(), wordlist);
            }

            else {
                map.get(wordFrequency.getValue()).add(wordFrequency);
            }
        }


        return map;
    }


}
