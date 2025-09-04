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

                String[] words = inputStr.split("\\s+");

                List<Word> wordsList=calculateWordFrequency(words);

                wordsList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

                StringJoiner joiner = new StringJoiner("\n");
                for (Word w : wordsList) {
                    String s = w.getValue() + " " +w.getWordCount();
                    joiner.add(s);
                }
                return joiner.toString();
            } catch (Exception e) {


                return "Calculate Error";
            }
        }
    }
    private  static  List<Word> calculateWordFrequency(String[] words){
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        for (String word : words) {
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }

        List<Word> wordsList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            wordsList.add(new Word(entry.getKey(), entry.getValue()));
        }

        return wordsList;
    }

}
