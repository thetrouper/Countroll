package me.trouper.Functions;

import me.trouper.Utils.Utils;
import me.trouper.Utils.Verbose;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Eval {
    public static double eval(String expression) {
        final String cleaned = Utils.removeColors(expression);
        Verbose.send("EVAL","Evaluating Expression: " + cleaned);
        Expression exp = new ExpressionBuilder(cleaned).build();
        return exp.evaluate();
    }
    public static boolean isPerfectSquare(int num) {
        if (num == 0) return false;
        final double sq = Math.sqrt(num);
        return sq == Math.floor(sq);
    }
    public static boolean isInt(double number) {
        return (number == Math.floor(number)) && !Double.isInfinite(number);
    }
}
