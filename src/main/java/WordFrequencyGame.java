import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class WordFrequencyGame {
    public String getResult(String inputStr){
        if (inputStr.split("\\s+").length==1) {
            return inputStr + " 1";
        } else {
            try {
                List<WordFrequency> wordList = createWordFrequencyBySplitInputStr(inputStr);
                List<WordFrequency> wordFrequencyList = countWordFrequency(wordList);
                wordFrequencyList.sort((w1, w2) -> w2.getCount() - w1.getCount());
                return buildWordFrequencyString(wordFrequencyList);
            } catch (Exception e) {
                return "Calculate Error";
            }
        }
    }
    public List<WordFrequency> createWordFrequencyBySplitInputStr(String inputStr){
        String[] wordArr = inputStr.split("\\s+");
        List<WordFrequency> wordList = new ArrayList<>();
        for (String word : wordArr) {
            WordFrequency wordFrequency = new WordFrequency(word, 1);
            wordList.add(wordFrequency);
        }
        return wordList;
    }
    public List<WordFrequency> countWordFrequency(List<WordFrequency> wordList){
        Map<String, List<WordFrequency>> wordMap = getListMap(wordList);
        List<WordFrequency> WordFrequencyList = new ArrayList<>();
        for (Map.Entry<String, List<WordFrequency>> entry : wordMap.entrySet()){
            WordFrequency wordFrequency = new WordFrequency(entry.getKey(), entry.getValue().size());
            WordFrequencyList.add(wordFrequency);
        }
        return WordFrequencyList;
    }
    public String buildWordFrequencyString(List<WordFrequency> WordCountList){
        StringJoiner wordFrequencyJoiner = new StringJoiner("\n");
        for (WordFrequency wordCount : WordCountList) {
            wordFrequencyJoiner.add(wordCount.getWord() + " " +wordCount.getCount());
        }
        return wordFrequencyJoiner.toString();
    }


    private Map<String,List<WordFrequency>> getListMap(List<WordFrequency> wordFrequencyList) {
        Map<String, List<WordFrequency>> map = new HashMap<>();
        for (WordFrequency wordFrequency : wordFrequencyList){
            if (!map.containsKey(wordFrequency.getWord())){
                ArrayList<WordFrequency> word = new ArrayList<>();
                word.add(wordFrequency);
                map.put(wordFrequency.getWord(), word);
            }
            else {
                map.get(wordFrequency.getWord()).add(wordFrequency);
            }
        }
        return map;
    }


}
