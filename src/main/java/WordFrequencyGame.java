import java.util.*;

public class WordFrequencyGame {
    public String getResult(String inputStr){


        if (inputStr.split("\\s+").length==1) {
            return inputStr + " 1";
        } else {

            try {
                String[] splitArray = inputStr.split("\\s+");
                Map<String, Integer> countMap = new HashMap<>();
                for (String s : splitArray) {
                    countMap.merge(s, 1, Integer::sum);
                }
                List<Map.Entry<String, Integer>> entries = new ArrayList<>(countMap.entrySet());
                entries.sort((e1, e2) -> e2.getValue() - e1.getValue());

                StringJoiner joiner = new StringJoiner("\n");
                for (Map.Entry<String, Integer> map : entries) {
                    String s = map.getKey() + " " + map.getValue();
                    joiner.add(s);
                }
                return joiner.toString();
            } catch (Exception e) {
                return "Calculate Error";
            }
        }
    }


}
