package sample.task1;

import sample.task1.customExceptions.EmptyListException;
import sample.task1.customExceptions.NoSuchSubstringException;

import java.util.List;
import java.util.Scanner;

/**
    Sort the string array by two criteria:
    1)according to the first occurrence of given substring;
    2)according to the string size;

    Input : strings array from command line arguments,
            substring is entered by user into command line;

    Output : firstly prints given array,
             then after every sort prints sorted array
             and number of comparison operations.
 */

public class Task1Runner {
    public static void run(List<String> stringsList) {
        stringsList.forEach(System.out::println);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the substring: ");
        String substring = scanner.nextLine();

        try {
            int firstCompareOperationsNumber = SubstringSorter.sort(stringsList, substring);
            System.out.println("After first sort:");
            stringsList.forEach(System.out::println);
            System.out.println("Number of comparison operations: ".concat(String.valueOf(firstCompareOperationsNumber)));
        } catch (NoSuchSubstringException | EmptyListException e) {
            System.err.println(e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("There is a null value in input!");
        }

        try {
            int secondCompareOperationsNumber = LengthSorter.sort(stringsList);
            System.out.println("After second sort:");
            stringsList.forEach(System.out::println);
            System.out.println("Number of comparison operations: ".concat(String.valueOf(secondCompareOperationsNumber)));
        } catch (EmptyListException e) {
            System.err.println(e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("There is a null value in input!");
        }
    }
}