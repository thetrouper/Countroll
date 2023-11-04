package me.trouper.Functions;

import static me.trouper.Functions.Eval.eval;

public class Increasers {
    public static String multiply(int i, int factor, boolean deep) {
        String result;
        if (deep) {
            result = "(" + Complexers.divide(i,false) + "/" + Complexers.divide(factor,false) + ")";
        } else {
            result = "(" + i + "*" + factor + ")";
        }
        if (eval(result) == i * factor) {
            return result;
        }
        return "(" + i + ")";
    }
    public static String power(int i, int exp, boolean deep) {
        String result;
        if (deep) {
            result = "(" + Complexers.root(i,false) + "^" + Complexers.root(exp,false) + ")";
        } else {
            result = "(" + i + "^" + exp + ")";
        }
        if (eval(result) == Math.pow(i,exp)) {
            return result;
        }
        return "(" + i + ")";
    }
}
