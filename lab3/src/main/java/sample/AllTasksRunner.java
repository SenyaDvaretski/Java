package sample;

import sample.task1.Task1Runner;
import sample.task2.Task2Runner;
import sample.task3.Task3Runner;
import sample.task4.Task4Runner;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Class that runs any task that you need
 *
 * Enter name of the task into the command line to run it
 */

public class AllTasksRunner {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name of the task to run: ");
        String taskNumber = scanner.nextLine();
        if (taskNumber.equals("task1")) {
            Task1Runner.run(Arrays.asList(args));
        }else if (taskNumber.equals("task2")){
            Task2Runner.run();
        }else if (taskNumber.equals("task3")){
            Task3Runner.run();
        }else if (taskNumber.equals("task4")){
            Task4Runner.run();
        }
        else{
            System.err.println("There is no such tasks!");
        }
    }
}
