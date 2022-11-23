package sample.task2;

import java.util.Scanner;


/**
 *  Convert string, adding all it substrings that are enclosed in double quotes.
 *  Erase double quotes in a substring before adding a substring.
 *  Before every substring adding, append movement to next line character.
 */
public class Task2Runner {
    public static void run(){
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scanner.nextLine());
        StringBuilder result = Converter.convert(input);
        System.out.println(result);
    }
}
