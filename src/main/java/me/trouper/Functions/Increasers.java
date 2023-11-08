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
        if (target - current > 64000) {
            Countroll.expCount++;
            return Increasers.power(i,4,deep);
        } else if (target - current > 4069) {
            Countroll.expCount++;
            return Increasers.power(i,3,deep);
        } else if (target - current > 1048) {
            Countroll.expCount++;
            return Increasers.power(i,2,deep);
        } else if (target - current > 128) {
            Countroll.factorCount++;
            return Increasers.multiply(i,9,deep);
        } else {
            return multiply(i,2,deep);
        }
    }
    public static String multiply(int i, int factor, boolean deep) {
        Countroll.factorCount++;
        String result;

        if (deep) {
            result = "<&7>(<&r><&2>" + (Complexers.complex(i,true)) + "<&b>*<&r><&2>" + Complexers.complex(i,true) + "<&7>)<&r>";
            if (eval(result) == i * factor) return result;
        }

        result = "<&7>(<&r><&2>" + i + "<&b>*<&r><&2>" + factor + "<&7>)<&r>";
        double calc = eval(result);

        if (!(calc == Math.multiplyExact(i,factor))) Verbose.send("ERR", "Failed multiply increaser! " +
                "\nAttempted expression: " + result +
                "\nTarget: " + i +
                "\nCalc: " + calc);
        return calc == i * factor ? result : "(" + i + ")";
    }
    public static String power(int i, int exp, boolean deep) {
        Countroll.powerCount++;
        String result;

        if (deep) {
            result = "<&7>(<&r><&2>" + Complexers.complex(i,true) + "<&b>^<&r><&2>" + Complexers.complex(i,true) + "<&7>)<&r>";
            if (eval(result) == Math.pow(i,exp)) return result;
        }

        result = "<&7>(<&r><&2>" + i + "<&b>^<&r><&2>" + exp + "<&7>)<&r>";
        double calc = eval(result);

        if (!(calc == Math.pow(i,exp))) Verbose.send("ERR", "Failed multiply increaser! " +
                "\nAttempted expression: " + result +
                "\nTarget: " + i +
                "\nCalc: " + calc);
        return calc == Math.pow(i,exp) ? result : "(" + i + ")";
    }
}
