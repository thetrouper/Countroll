package me.trouper.Functions;

import me.trouper.Countroll;
import me.trouper.Utils.Utils;
import me.trouper.Utils.Verbose;

import java.util.*;

import static me.trouper.Functions.Eval.eval;
import static me.trouper.Functions.Eval.isPerfectSquare;

public class Complexers {
    /* Complexer Toggles */
    public static boolean useDivide;
    public static boolean usePower;
    public static boolean useRoot;
    public static boolean useRDividend;

    public static String pickComplexer() {
        List<String> enabledComplexers = new ArrayList<>();

        if (useDivide) enabledComplexers.add("divide");
        if (usePower) enabledComplexers.add("power");
        if (useRoot) enabledComplexers.add("root");
        if (useRDividend) enabledComplexers.add("mrDividend");

        Collections.shuffle(enabledComplexers);
        if (!enabledComplexers.isEmpty()) {
            return enabledComplexers.get(0);
        } else {
            return "NONE";
        }
    }
    public static String complex(int i, boolean deep) {
        String complexer = pickComplexer();
        if (isPerfectSquare(i)) complexer = "power";
        switch (complexer) {
            case "divide" -> {
                return divide(i,deep);
            }
            case "power" -> {
                if (!isPerfectSquare(i)) {
                    return divide(i,deep);
                }
                return power(i,deep);
            }
            case "root" -> {
                return root(i,deep);
            }
            case "mrDividend" -> {
                return mRootDividend(i,deep);
            }
            default -> {
                return divide(i,false);
            }
        }
    }
    /**
     * Safe to use with D mode
     * @param i Integer to divide
     * @return Colored String
     */
    public static String divide(int i, boolean deep) {
        Verbose.send("COMP", "Running Divide Complexer, I:" + i + " Deep: " + deep);
        Countroll.divideCount++;
        Random random = new Random();

        int factor = random.nextInt(9)+1;
        int doubled = i * factor;

        String result = "<&f>(<&r><&e>" + doubled + "<&b>/<&r><&e>" + factor + "<&f>)<&r>";

        if (deep) {
            result = "<&3>(<&r><&d>" + (complex(doubled,false)) + "<&b>/<&r><&d>" + (complex(factor,false)) + "<&3>)<&r>";
        }
        if (eval(result) != i) Verbose.send("ERR","<&ch>Failed to divide <&r>" + i + ", Attempted: " + result + "=" + eval(result));
        return eval(result) == i ? result : "<&ch>(" + i + ")<&r>";
    }

    /**
     * Safe to use with D mode
     * Only to be used with perfect squares
     * @param i Integer to root+square
     * @return Colored String
     */
    public static String power(int i, boolean deep) {
        Verbose.send("COMP", "Running Power Complexer, I:" + i + " Deep: " + deep);
        Countroll.powerCount++;

        int root = (int) Math.sqrt(i);
        String result =  "<&r><&f>(<&e>" + root + "<&b>^<&e>2<&f>)<&r>";

        if (deep) {
            result = "<&r><&3>(<&d>" + complex(root,false) + "<&b>^<&d>2<&3>)<&r>";
        }
        if (eval(result) != i) Verbose.send("ERR","<&ch>Failed to power <&r>" + i + ", Attempted: " + result + "=" + eval(result));
        return eval(result) == i ? result : "<&ch>(" + i + ")<&r>";
    }

    /**
     * Uses sqrt(), not safe with D mode
     * @param i integer to square+root
     * @return Colored String
     */
    public static String root(int i, boolean deep) {
        Verbose.send("COMP", "Running Root Complexer, I:" + i + " Deep: " + deep);
        Countroll.rootCount++;
        int squared = (int) Math.pow(i,2);
        String result = "<&9>sqrt<&r><&f>(<&r><&e>" + squared + "<&f>)<&r>";

        if (deep) {
            result = "<&1>sqrt<&r><&3>(<&r><&d>" + complex(squared, false) + "<&3>)<&r>";
        }
        if (eval(result) != i) Verbose.send("ERR","<&ch>Failed to root <&r>" + i + ", Attempted: " + result + "=" + eval(result));
        return (eval(result) == i) ? result : "<&ch>(" + i + ")<&r>";
    }

    /**
     * Uses modulus (dividend%ri)=i
     * @param i Modulus to return
     * @return Colored String
     */
    public static String mRootDividend(int i, boolean deep) {
        Verbose.send("COMP", "Running mrDividend Complexer, I:" + i + " Deep: " + deep);
        Countroll.rDividendCount++;
        Random random = new Random();
        int divisor = random.nextInt(9)+i+10;
        int dividend = Utils.moduRootDividend(divisor,i);
        String result = "<&r><&f>(<&e>" + dividend + "<&b>%<&e>" + divisor  + "<&f>)<&r>";
        if (deep) {
            result = "<&r><&7>(<&d>" + complex(dividend,false) + "<&b>%<&d>" + complex(divisor,false)  + "<&7>)<&r>";
        }
        Verbose.send("COMP","<&dh><&b>mRootDividend has been ran!<&r>" +
                "\nWanted:" + i +
                "\nDivisor: " + divisor +
                "\nDividend: " + dividend +
                "\nCheck: " + dividend + "%" + divisor + "=" + i +
                "\nResult: " + result);
        if (eval(result) != i) Verbose.send("ERR","<&ch>Failed to mRootDividend<&r> " + i + ", Attempted: " + result + "=" + eval(result));
        return (eval(result) == i) ? result : "<&ch>(" + i + ")<&r>";

    }
}
