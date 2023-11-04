package me.trouper.Functions;

import me.trouper.Utils.Utils;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Eval {
    public static double eval(String expression) {
        final String cleaned = Utils.removeColors(expression);
        Utils.verbose("Evaluating Expression: " + cleaned);
        Expression exp = new ExpressionBuilder(cleaned).build();
        return exp.evaluate();
    }
    public static boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
    public static boolean isInt(double number) {
        return (number == Math.floor(number)) && !Double.isInfinite(number);
    }
}
