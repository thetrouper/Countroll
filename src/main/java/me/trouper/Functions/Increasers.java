package me.trouper.Functions;

import static me.trouper.Functions.Eval.eval;

public class Increasers {
    public static String multiply(int i, int factor) {
        String result = "<&7>(<&r><&2>" + i + "<&b>*<&r><&2>" + factor + "<&7>)<&r>";

        if (eval(result) == i * factor) {
            return result;
        }
        return "(" + i + ")";
    }
    public static String power(int i, int exp) {
        String result = "<&7>(<&r><&2>" + i + "<&b>^<&r><&2>" + exp + "<&7>)<&r>";

        if (eval(result) == Math.pow(i,exp)) {
            return result;
        }
        return "(" + i + ")";
    }
}
