import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class WordFrequencyGame {
    public String getResult(String inputStr){
        String[] words = inputStr.split("\\s+");
        if (words.length==1) {
            return inputStr + " 1";
        } else {
            try {
                //split the input string with 1 to n pieces of spaces
                List<WordDetail> wordList = initWordList(words);

                //get the map for the next step of sizing the same word
                Map<String, List<WordDetail>> map = getWordListMap(wordList);

                List<WordDetail> list = new ArrayList<>();
                for (Map.Entry<String, List<WordDetail>> entry : map.entrySet()){
                    WordDetail input = new WordDetail(entry.getKey(), entry.getValue().size());
                    list.add(input);
                }
                wordList = list;

                wordList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

                StringJoiner result = new StringJoiner("\n");
                for (WordDetail resultList : wordList) {
                    String s = resultList.getWord() + " " +resultList.getWordCount();
                    result.add(s);
                }
                return result.toString();
            } catch (Exception e) {
                return "Calculate Error";
            }
        }
    }

    private Map<String,List<WordDetail>> getWordListMap(List<WordDetail> wordList) {
        Map<String, List<WordDetail>> map = new HashMap<>();
        for (WordDetail word :  wordList){
            map.computeIfAbsent(word.getWord(), k -> new ArrayList<>()).add(word);
        }
        return map;
    }

    public List<WordDetail> initWordList(String[] inputArr){
        List<WordDetail> wordList = new ArrayList<>();
        for (String word : inputArr) {
            WordDetail input = new WordDetail(word, 1);
            wordList.add(input);
        }
        return wordList;
    }
}
