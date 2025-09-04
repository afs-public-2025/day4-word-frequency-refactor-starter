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
                List<WordDetail> wordList = initWordList(words);

                Map<String, List<WordDetail>> wordListmap = getWordListMap(wordList);

                wordList = getWordList(wordListmap);

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

    private List<WordDetail> getWordList(Map<String, List<WordDetail>> wordListmap) {
        List<WordDetail> wordlist = new ArrayList<>();
        for (Map.Entry<String, List<WordDetail>> entry : wordListmap.entrySet()){
            WordDetail word = new WordDetail(entry.getKey(), entry.getValue().size());
            wordlist.add(word);
        }
        return wordlist;
    }

    private Map<String,List<WordDetail>> getWordListMap(List<WordDetail> wordList) {
        Map<String, List<WordDetail>> wordListmap = new HashMap<>();
        for (WordDetail word :  wordList){
            wordListmap.computeIfAbsent(word.getWord(), k -> new ArrayList<>()).add(word);
        }
        return wordListmap;
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
