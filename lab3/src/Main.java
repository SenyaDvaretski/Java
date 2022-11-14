import customExceptions.EmptyListException;
import customExceptions.NoSuchSubstringException;

import java.util.Arrays;
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

public class Main {
    public static void main(String[] args) {
        MyList<String> stringsList = new MyList<>(Arrays.asList(args));
        stringsList.print();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the substring: ");
        String substring = scanner.nextLine();
        try {
            int compareOperationsNumber = stringsList.substringSort(substring);
            System.out.println("After first sort:");
            stringsList.print();
            System.out.println("Number of comparison operations: ".concat(String.valueOf(compareOperationsNumber)));
        } catch (NoSuchSubstringException | EmptyListException e) {
            System.err.println(e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("There is a null value in input!");
        }
    }
}