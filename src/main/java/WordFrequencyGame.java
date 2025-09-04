import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class WordFrequencyGame {

    public String outputResult(String inputStr){
        if(isOneWord(inputStr)){
            return inputStr + " 1";
        }
        else {
            return notOneword(inputStr);
        }
    }


    private Map<String, List<Input>> getListMap(List<Input> inputList) {
        Map<String, List<Input>> map = new HashMap<>();
        for (Input input : inputList) {
            map.computeIfAbsent(input.getWords(), k -> new ArrayList<>()).add(input);
        }
        return map;
    }

    public boolean isOneWord(String inputStr) {
        return inputStr.split("\\s+").length == 1;
    }

    public String notOneword(String inputStr) {
        try {
            List<Input> wordlist = splitWords(inputStr);
            wordlist = countWordFrequency(wordlist);
            sortByFrequencyDesc(wordlist);
            return formatResult(wordlist);
        } catch (Exception e) {
            return "Calculate Error";
        }
    }

    private List<Input> splitWords(String inputStr) {
        String[] wordarray = inputStr.split("\\s+");
        List<Input> wordlist = new ArrayList<>();
        for (String word : wordarray) {
            wordlist.add(new Input(word, 1));
        }
        return wordlist;
    }

    private List<Input> countWordFrequency(List<Input> wordlist) {
        Map<String, List<Input>> map = getListMap(wordlist);
        List<Input> result = new ArrayList<>();
        for (Map.Entry<String, List<Input>> entry : map.entrySet()) {
            result.add(new Input(entry.getKey(), entry.getValue().size()));
        }
        return result;
    }

    private void sortByFrequencyDesc(List<Input> wordlist) {
        wordlist.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());
    }

    private String formatResult(List<Input> wordlist) {
        StringJoiner joiner = new StringJoiner("\n");
        for (Input word : wordlist) {
            joiner.add(word.getWords() + " " + word.getWordCount());
        }
        return joiner.toString();
    }
}
