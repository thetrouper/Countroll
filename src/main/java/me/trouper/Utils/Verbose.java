package me.trouper.Utils;

import me.trouper.Countroll;

public class Verbose {
    public static boolean processes;
    public static boolean all;
    public static boolean loops;
    public static boolean eval;
    public static boolean complexers;
    public static boolean increasers;
    public static boolean utils;
    public static boolean errors;
    public static void send(String type, String message) {
        message = Utils.activateColors(message);
        if (all) {
            System.out.println(message);
            return;
        }
        if (type.equals("INIT")) System.out.println(message);
        if (type.equals("PROC") && processes) System.out.println(message);
        if (type.equals("LOOP") && loops) System.out.println(message);
        if (type.equals("UTIL") && utils) System.out.println(message);
        if (type.equals("EVAL") && eval) System.out.println(message);
        if (type.equals("COMP") && complexers) System.out.println(message);
        if (type.equals("INCR") && increasers) System.out.println(message);
        if (type.equals("ERR") && errors) {
            System.out.println(message);
            Countroll.errorCount++;
        }
    }
}
