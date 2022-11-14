import customExceptions.EmptyListException;
import customExceptions.NoSuchSubstringException;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class that is a list of strings with additional sort method
 *
 * @param <T> - any class that extends String
 */
public class MyList<T extends String> extends ArrayList<T> {


    /** Constructor creates new empty MyList object */
    public MyList() {super();}

    /**
     * Constructor creates new MyList from various number of strings
     * @param strings few strings, that should be added to list
     */
    public MyList(T ... strings) {super(List.of(strings));}

    /**
     * Constructor makes new MyList instance from list
     * @param list arrayList
     */
    public MyList(List<T> list) {
        super(list);
    }

    /** Method prints list in a column */
    public void print(){
        this.stream().forEach(System.out::println);
    }

    /**
     *
     * Method sorts list according to the first occurrence of substring in an element,
     * returns number of comparison operations during sorting,
     * may throw NoSuchSubstringException if an element doesn't have given substring
     *
     * @param substring given substring
     * @return number of comparing operations during sorting
     * @throws NoSuchSubstringException throws if there is a string which doesn't contain given substring
     */
    public int substringSort(String substring) throws NoSuchSubstringException, NullPointerException, EmptyListException {
        if(this.isEmpty()){
            throw new EmptyListException("Given list is empty, unable to sort empty list!");
        }
        Optional<T> errorStr = this.stream().filter(str -> !str.contains(substring) ).findFirst();
        if (errorStr.isPresent()) {
            throw new NoSuchSubstringException("There is no substring \"".concat(substring)
                    .concat("\" in a string \"".concat(errorStr.get()).concat("\"!")));
        }

        AtomicInteger comparisonCounter = new AtomicInteger();
        Comparator<T> substringComparator = Comparator.comparing(str -> {
            comparisonCounter.addAndGet(1);
            return str.indexOf(substring);
        });
        this.sort(substringComparator);
        return comparisonCounter.intValue() / 2;
    }
}
