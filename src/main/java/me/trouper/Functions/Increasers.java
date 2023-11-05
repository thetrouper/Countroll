package me.trouper.Functions;

import static me.trouper.Functions.Eval.eval;
import static me.trouper.Functions.Eval.isPerfectSquare;

public class Increasers {
    public static String multiply(int i, int factor, boolean deep) {
        boolean useExp = isPerfectSquare(i);

        String result = "<&7>(<&r><&2>" + i + "<&b>*<&r><&2>" + factor + "<&7>)<&r>";

        if (deep) {
            result = "<&7>(<&r><&2>" + (useExp ? Complexers.power(i,true) : Complexers.divide(i,true)) + "<&b>*<&r><&2>" + factor + "<&7>)<&r>";
        }

        return eval(result) == i * factor ? result : "(" + i + ")";
    }
    public static String power(int i, int exp, boolean deep) {
        boolean useExp = isPerfectSquare(i);

        String result = "<&7>(<&r><&2>" + i + "<&b>^<&r><&2>" + exp + "<&7>)<&r>";

        if (deep) {
            result = "<&7>(<&r><&2>" + (useExp ? Complexers.power(i,true) : Complexers.divide(i,true)) + "<&b>^<&r><&2>" + exp + "<&7>)<&r>";
        }

        return eval(result) == Math.pow(i,exp) ? result : "(" + i + ")";
    }
}
