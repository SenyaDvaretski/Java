package sample.task4;

import java.util.ArrayList;
import java.util.List;

/**
 *  Create your own sorting class, complete task #1 using it.
 *  Sorting class must:
 *  1) Allow any type of objects to be sorted
 *  2) Use interface Comparator
 */

public class Task4Runner {
    public static void run(){
        List<Integer> input = new ArrayList<>(List.of(3, 2, 1));
        List<Integer> result = new MergeSort<Integer>().sort(input, Integer::compare);
        System.out.println(result);
    }
}
