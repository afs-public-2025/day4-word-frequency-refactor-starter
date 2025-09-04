import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputStr){

        // apply stream api to count distinct word quantity
        return Arrays.stream(inputStr.split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((wordValueCountMap1,wordValueCountMap2)->wordValueCountMap2.getValue().intValue() - wordValueCountMap1.getValue().intValue())
                .map(wordValueCountMap -> wordValueCountMap.getKey() + " " + wordValueCountMap.getValue())
                .collect(Collectors.joining("\n"));
    }


}
