package sample.task1;

import sample.task1.customExceptions.EmptyListException;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LengthSorter {
    /**
     * Method sorts list according to the string length,
     * returns number of comparison operations during sorting
     *
     * @param stringsList list of strings that should be sorted
     * @return number of comparing operations during sorting
     * @throws EmptyListException if the given list is empty
     */
    public static int sort(List<String> stringsList) throws EmptyListException {
        if(stringsList.isEmpty()){
            throw new EmptyListException("Given list is empty, unable to sort empty list!");
        }

        AtomicInteger comparisonCounter = new AtomicInteger();
        Comparator<String> substringComparator = Comparator.comparing(str -> {
            comparisonCounter.addAndGet(1);
            return str.length();
        });
        stringsList.sort(substringComparator);
        return comparisonCounter.intValue() / 2;
    }
}
