package me.trouper.Functions;

import java.util.Random;

import static me.trouper.Functions.Eval.eval;

public class Complexers {
    public static String divide(int i) {
        Random random = new Random();
        int factor = random.nextInt(9)+1;
        int doubled = i * factor;
        String result = "(" + doubled + "/" + factor + ")";

        if (eval(result) == i) {
            return result;
        }
        return "(" + i + ")";
    }

    public static String multiply(int i, int factor) {
        String result = "(" + i + "*" + factor + ")";
        if (eval(result) == i * factor) {
            return result;
        }
        return "(" + i + ")";
    }
    public static String power(int i, int exp) {
        String result = "(" + i + "^" + exp + ")";
        if (eval(result) == Math.pow(i,exp)) {
            return result;
        }
        return "(" + i + ")";
    }

    public static String root(int i) {
        int squared = (int) Math.pow(i,2);
        String result = "sqrt(" + squared + ")";
        if (eval(result) == i){
            return result;
        }
        return "(" + i + ")";
    }
}