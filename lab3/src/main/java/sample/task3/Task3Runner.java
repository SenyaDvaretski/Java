package sample.task3;

import by.vsu.mf.ai.ssd.strings.Manager;
import by.vsu.mf.ai.ssd.strings.Job;
import sample.task2.Converter;

/**
 *  Complete task #2 using given library - "strings"
 */

public class Task3Runner {
    public static void run(){
        Manager.createWindow(Converter::convert);
    }
}
