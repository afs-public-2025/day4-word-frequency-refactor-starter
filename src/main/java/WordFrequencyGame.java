import java.util.*;

public class WordFrequencyGame {
    private Map<String, Integer> getWordCount(String inputStr) {
        Map<String, Integer> wordCount = new LinkedHashMap<>();
        String[] words = inputStr.split("\\s+");
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }

    public String getResult(String inputStr){
        if (inputStr.split("\\s+").length==1) {
            return inputStr + " 1";
        }
        else {
            try {
                List<WordFrequency> wordFrequencyList = new ArrayList<>();
                Map<String, Integer> wordCount = getWordCount(inputStr);
                wordCount.forEach((word, count) -> wordFrequencyList.add(new WordFrequency(word, count)));

                // Higher occurrence first, followed by appearance order
                wordFrequencyList.sort((w1, w2) -> w2.getWordOccurrence() - w1.getWordOccurrence());

                StringJoiner result = new StringJoiner("\n");
                wordFrequencyList.forEach(wordFrequency -> result.add(wordFrequency.getWord() + " " + wordFrequency.getWordOccurrence()));
                return result.toString();
            }
            catch (Exception e) {
                return "Calculate Error";
            }
        }
    }


}
