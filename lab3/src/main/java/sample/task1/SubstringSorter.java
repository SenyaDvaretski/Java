package sample.task1;

import sample.task1.customExceptions.EmptyListException;
import sample.task1.customExceptions.NoSuchSubstringException;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class SubstringSorter {
    /**
     * Method sorts list according to the first occurrence of substring in an element,
     * returns number of comparison operations during sorting,
     * may throw NoSuchSubstringException if an element doesn't have given substring
     *
     * @param substring given substring
     * @return number of comparing operations during sorting
     * @throws NoSuchSubstringException throws if there is a string which doesn't contain given substring
     */
    public static int sort(List<String> stringsList, String substring) throws NoSuchSubstringException, NullPointerException, EmptyListException {
        if(stringsList.isEmpty()){
            throw new EmptyListException("Given list is empty, unable to sort empty list!");
        }
        Optional<String> errorStr = stringsList.stream().filter(str -> !str.contains(substring) ).findFirst();
        if (errorStr.isPresent()) {
            throw new NoSuchSubstringException("There is no substring \"".concat(substring)
                    .concat("\" in a string \"".concat(errorStr.get()).concat("\"!")));
        }

        AtomicInteger comparisonCounter = new AtomicInteger();
        Comparator<String> substringComparator = Comparator.comparing(str -> {
            comparisonCounter.addAndGet(1);
            return str.indexOf(substring);
        });
        stringsList.sort(substringComparator);
        return comparisonCounter.intValue() / 2;
    }
}
