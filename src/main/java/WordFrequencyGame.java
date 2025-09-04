import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class WordFrequencyGame {
    private static final String SPACE_REGEX = "\\s+";
    private static final String CALCULATE_ERROR = "Calculate Error";
    private static final int INITIAL_COUNT = 1;
    public String getResult(String inputStr){
        if (inputStr.split(SPACE_REGEX).length==1) {
            return inputStr + " 1";
        } else {

            try {

                List<WordFrequency> wordsArraySplitByRegex = getWordsArraySplitByRegex(inputStr);

                //get the map for the next step of sizing the same word
                Map<String, List<WordFrequency>> classifiedWordFrequencyMap =groupWordFrequencyByWord(wordsArraySplitByRegex);

                List<WordFrequency> updatedWordToRealFrequency = new ArrayList<>();
                for (Map.Entry<String, List<WordFrequency>> entry : classifiedWordFrequencyMap.entrySet()){
                    WordFrequency wordFrequency = new WordFrequency(entry.getKey(), entry.getValue().size());
                    updatedWordToRealFrequency.add(wordFrequency);
                }
                updatedWordToRealFrequency.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

                StringJoiner joiner = new StringJoiner("\n");
                for (WordFrequency w : wordsArraySplitByRegex) {
                    String s = w.getValue() + " " +w.getWordCount();
                    joiner.add(s);
                }
                return joiner.toString();
            } catch (Exception e) {


                return CALCULATE_ERROR;
            }
        }
    }

    private List<WordFrequency> getWordsArraySplitByRegex(String targetString) {
        String[] wordsArraySplitByRegex = targetString.split(SPACE_REGEX);
        List<WordFrequency> wordFrequencyList = new ArrayList<>();
        Stream.of(wordsArraySplitByRegex).forEach(word -> {
            wordFrequencyList.add(new WordFrequency(word, INITIAL_COUNT));
        });
        return wordFrequencyList;
    }

    private List<WordFrequency> getWordsArraySplitBySpace(String targetString) {
        String[] wordsArraySplitBySpace = targetString.split(SPACE_REGEX);
        List<WordFrequency> wordFrequencyList = new ArrayList<>();
        for (String str : wordsArraySplitBySpace) {
            WordFrequency wordFrequency = new WordFrequency(str, INITIAL_COUNT);
            wordFrequencyList.add(wordFrequency);
        }
        return wordFrequencyList;
    }

    private Map<String,List<WordFrequency>> groupWordFrequencyByWord(List<WordFrequency> wordFrequencyList) {
        Map<String, List<WordFrequency>> classifiedWordFrequencyMap = new HashMap<>();
        for (WordFrequency wordFrequency : wordFrequencyList){
            if (!classifiedWordFrequencyMap.containsKey(wordFrequency.getValue())){
                ArrayList<WordFrequency> matchingWordFrequency = new ArrayList<>();
                matchingWordFrequency.add(wordFrequency);
                classifiedWordFrequencyMap.put(wordFrequency.getValue(), matchingWordFrequency);
            } else {
                classifiedWordFrequencyMap.get(wordFrequency.getValue()).add(wordFrequency);
            }
        }


        return classifiedWordFrequencyMap;
    }


}
