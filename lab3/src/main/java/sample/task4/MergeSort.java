package sample.task4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class MergeSort<T> implements Sort<T>{
    /**
     * Method that sorts list of objects using merge sorting algorithm
     *
     * @param list list of objects to sort
     * @param left left bound of sorting area
     * @param right right bound of sorting area
     * @param c comparator
     * @return sorted list of objects
     */
    private List<T> mergeSort(List<T> list, int left, int right, Comparator<T> c){

        int middle = left + ((right - left) / 2) + 1;
        if (middle > 0 && right > (left + 1)) {
            mergeSort(list, left, middle - 1, c);
            mergeSort(list, middle, right, c);
        }

        List<T> buffer = new ArrayList<>();
        int cursor = left;
        for (int i = 0; i < right - left + 1; i++) {
            if ((middle > right) ||
                    c.compare(list.get(cursor), list.get(middle)) < 0) {
                buffer.add(list.get(cursor));
                cursor++;
            } else {
                buffer.add(list.get(middle));
                middle++;
            }
        }
        IntStream.range(left, right + 1)
                 .forEach(i -> list.set(i, buffer.get(i - left)));
        return list;
    }

    /**
     * Sort method implementation
     *
     * @param list list of objects to be sorted
     * @param comparator comparator
     * @return sorted list of objects
     */
    @Override
    public List<T> sort(List<T> list, Comparator<T> comparator) {
        return mergeSort(list, 0, list.size() - 1, comparator);
    }
}