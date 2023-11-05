package me.trouper.Functions;

import me.trouper.Main;
import me.trouper.Utils.Utils;

import java.util.Random;

import static me.trouper.Functions.Eval.eval;
import static me.trouper.Functions.Eval.isPerfectSquare;

public class Complexers {

    /**
     * Safe to use with D mode
     * @param i Integer to divide
     * @return Colored String
     */
    public static String divide(int i, boolean deep) {
        Main.divideCount++;
        Random random = new Random();

        int factor = random.nextInt(9)+1;
        int doubled = i * factor;
        boolean expFac = false;
        boolean expDoub = false;

        if (isPerfectSquare(factor)) expFac = true;
        if (isPerfectSquare(doubled)) expDoub = true;

        String result = "<&f>(<&r><&e>" + doubled + "<&b>/<&r><&e>" + factor + "<&f>)<&r>";

        if (deep) {
            result = "<&3>(<&r><&d>" + ((expDoub) ? power(doubled,false) : divide(doubled,false)) + "<&b>/<&r><&d>" + ((expFac) ? power(factor,false) : divide(factor,false)) + "<&3>)<&r>";
        }
        if (eval(result) != i) Utils.verbose("Failed to divide " + i + ", Attempted: " + result + "=" + eval(result));
        return eval(result) == i ? result : "(" + i + ")";
    }

    /**
     * Safe to use with D mode
     * Only to be used with perfect squares
     * @param i Integer to root+square
     * @return Colored String
     */
    public static String power(int i, boolean deep) {
        Main.powerCount++;
        if (!Eval.isPerfectSquare(i)) {
            return "(" + i + ")";
        }

        int root = (int) Math.sqrt(i);
        String result =  "<&r><&f>(<&e>" + root + "<&b>^<&e>2<&f>)<&r>";

        if (deep) {
            result = "<&r><&3>(<&d>" + divide(root,false) + "<&b>^<&d>2<&3>)<&r>";
        }
        if (eval(result) != i) Utils.verbose("<&ch>Failed to power <&r>" + i + ", Attempted: " + result + "=" + eval(result));
        return eval(result) == i ? result : "(" + i + ")";
    }

    /**
     * Uses sqrt(), not safe with D mode
     * @param i integer to square+root
     * @return Colored String
     */
    public static String root(int i, boolean deep) {
        Main.rootCount++;
        int squared = (int) Math.pow(i,2);
        String result = "<&9>sqrt<&r><&f>(<&r><&e>" + squared + "<&f>)<&r>";

        if (deep) {
            result = "<&1>sqrt<&r><&3>(<&r><&d>" + divide(squared,false) + "<&3>)<&r>";
        }
        if (eval(result) != i) Utils.verbose("<&ch>Failed to root <&r>" + i + ", Attempted: " + result + "=" + eval(result));
        return (eval(result) == i) ? result : "(" + i + ")";
    }

    /**
     * Uses modulus (ri%divisor)=i
     * @param i Modulus to return
     * @return Colored string
     */
    public static String mRootDivisor(int i, boolean deep) {
        Main.rDivisorCount++;
        Random random = new Random();
        int dividend = random.nextInt(9)+i+10;
        int divisor = Utils.moduRootDivisor(dividend,i);
        String result = "<&r><&f>(<&e>" + dividend + "<&b>%<&e>" + divisor + "<&f>)<&r>";
        Utils.verbose("<&dh><&b>mRootDivisor has been ran!<&r>" +
                "\nWanted: " + i +
                "\nDivisor: " + divisor +
                "\nDividend: " + dividend +
                "\nCheck: " + dividend + "%" + divisor + "=" + i +
                "\nResult: " + result);
        if (eval(result) != i) Utils.verbose("<&ch>Failed to mRootDivisor<&r> " + i + ", Attempted: " + result + "=" + eval(result));
        return (eval(result) == i) ? result : "(" + i + ")";
    }

    /**
     * Uses modulus (dividend%ri)=i
     * @param i Modulus to return
     * @return Colored String
     */
    public static String mRootDividend(int i, boolean deep) {
        Main.rDividendCount++;
        Random random = new Random();
        int divisor = random.nextInt(9)+i+10;
        int dividend = Utils.moduRootDividend(divisor,i);
        String result = "<&r><&f>(<&e>" + dividend + "<&b>%<&e>" + divisor  + "<&f>)<&r>";
        Utils.verbose("<&dh><&b>mRootDividend has been ran!<&r>" +
                "\nWanted:" + i +
                "\nDivisor: " + divisor +
                "\nDividend: " + dividend +
                "\nCheck: " + dividend + "%" + divisor + "=" + i +
                "\nResult: " + result);
        if (eval(result) != i) Utils.verbose("<&ch>Failed to mRootDividend<&r> " + i + ", Attempted: " + result + "=" + eval(result));
        return (eval(result) == i) ? result : "(" + i + ")";
    }
}
