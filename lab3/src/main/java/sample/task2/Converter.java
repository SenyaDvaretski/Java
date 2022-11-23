package sample.task2;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    /**
     * Method adds all substrings of given string to the end of the given string,
     * every substring is separated by the "\n" symbol
     *
     * @param string string that must be converted
     * @return new converted string
     */
    public static StringBuilder convert(StringBuilder string){
        List<Integer> quotesPositions = new ArrayList<>();
        int currentQuotePosition = string.indexOf("\"");
        while(currentQuotePosition != -1){
            quotesPositions.add(currentQuotePosition);
            currentQuotePosition = string.indexOf("\"", currentQuotePosition + 1);
        }

        for(int i = 0; i < quotesPositions.size(); i++){
            for(int j = i + 1; j < quotesPositions.size(); j++){
                string.append("\n");
                string.append(string.substring(quotesPositions.get(i) + 1, quotesPositions.get(j)));
            }
        }
        return string;
    }
}
