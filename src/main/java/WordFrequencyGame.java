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

                //split the input string with 1 to n pieces of spaces
                String[] words = inputStr.split("\\s+");

                List<Word> wordsList = getWordList(words);

                //get the map for the next step of sizing the same word
                Map<String, List<Word>> map =getListMap(wordsList);

                wordsList = getWordListFromMap(map);

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

    private static List<Word> getWordListFromMap(Map<String, List<Word>> map) {
        List<Word> wordsList;
        List<Word> list = new ArrayList<>();
        for (Map.Entry<String, List<Word>> entry : map.entrySet()){
            Word input = new Word(entry.getKey(), entry.getValue().size());
            list.add(input);
        }
        wordsList = list;
        return wordsList;
    }

    private static List<Word> getWordList(String[] words) {
        List<Word> wordsList = new ArrayList<>();
        for (String word : words) {
            Word input = new Word(word, 1);
            wordsList.add(input);
        }
        return wordsList;
    }


    private Map<String,List<Word>> getListMap(List<Word> wordsList) {
        Map<String, List<Word>> map = new HashMap<>();
        for (Word word :  wordsList){
//       map.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input);
            if (!map.containsKey(word.getValue())){
                ArrayList arr = new ArrayList<>();
                arr.add(word);
                map.put(word.getValue(), arr);
            }

            else {
                map.get(word.getValue()).add(word);
            }
        }


        return map;
    }


}
