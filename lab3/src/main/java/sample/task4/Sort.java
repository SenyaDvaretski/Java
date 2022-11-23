package sample.task4;

import java.util.Comparator;
import java.util.List;

/**
 * Interface for sorter class
 *
 * @param <T>
 */
public interface Sort <T>{
    List<T> sort(List<T> list, Comparator<T> comparator);
}
