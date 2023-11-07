package me.trouper.Functions;

import me.trouper.Countroll;
import me.trouper.Utils.Utils;
import me.trouper.Utils.Verbose;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static me.trouper.Functions.Eval.eval;
import static me.trouper.Functions.Eval.isPerfectSquare;

public class Increasers {

    public static String increase(int current, int target, int i, boolean deep) {

        if (target - current > 4069) {
            return power(i,10,deep);
        } else if (target - current > 10000000) {
            return power(i,8,deep);
        } else if (target - current > 1000000) {
            return power(i,6,deep);
        } else if (target - current > 100000) {
            return power(i,4,deep);
        } else if (target - current > 10000) {
            return power(i,3,deep);
        } else if (target - current > 1000) {
            return power(i,2,deep);
        } else if (target - current > 100) {
            return multiply(i,9,deep);
        } else {
            return multiply(i,2,deep);
        }
    }
    public static String multiply(int i, int factor, boolean deep) {
        Countroll.factorCount++;
        String result = "<&7>(<&r><&2>" + i + "<&b>*<&r><&2>" + factor + "<&7>)<&r>";

        if (deep) {
            result = "<&7>(<&r><&2>" + (Complexers.complex(i,true)) + "<&b>*<&r><&2>" + Complexers.complex(i,true) + "<&7>)<&r>";
        }
        if (!(eval(result) == i * factor)) Verbose.send("ERR", "Failed multiply increaser!");
        return eval(result) == i * factor ? result : "(" + i + ")";
    }
    public static String power(int i, int exp, boolean deep) {
        Countroll.powerCount++;
        String result = "<&7>(<&r><&2>" + i + "<&b>^<&r><&2>" + exp + "<&7>)<&r>";

        if (deep) {
            result = "<&7>(<&r><&2>" + Complexers.complex(i,true) + "<&b>^<&r><&2>" + Complexers.complex(i,true) + "<&7>)<&r>";
        }
        if (!(eval(result) == Math.pow(i,exp))) Verbose.send("ERR", "Failed power increaser!");
        return eval(result) == Math.pow(i,exp) ? result : "(" + i + ")";
    }
}
