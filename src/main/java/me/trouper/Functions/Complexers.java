package me.trouper.Functions;

import java.util.Random;

import static me.trouper.Functions.Eval.eval;

public class Complexers {
    public static String divide(int i, boolean deep) {
        Random random = new Random();
        int factor = random.nextInt(9)+1;
        int doubled = i * factor;
        String result;
        if (deep) {
            result = "(" + Increasers.multiply(doubled,1,false) + "/" + Increasers.multiply(factor,1,false) + ")";
        } else {
            result = "(" + doubled + "/" + factor + ")";
        }
        if (eval(result) == i) {
            return result;
        }
        return "(" + i + ")";
    }

    public static String root(int i, boolean deep) {
        int squared = (int) Math.pow(i,2);
        String result;
        if (deep) {
            result = "sqrt(" + Increasers.power(i,1,false) + ")";
        } else {
            result = "sqrt(" + squared + ")";
        }
        if (eval(result) == i){
            return result;
        }
        return "(" + i + ")";
    }
}
