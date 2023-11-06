package me.trouper.Functions;

import com.ezylang.evalex.EvaluationException;
import com.ezylang.evalex.data.EvaluationValue;
import com.ezylang.evalex.parser.ParseException;
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
    public static double evalM(String exp) throws EvaluationException, ParseException {
        com.ezylang.evalex.Expression expression = new com.ezylang.evalex.Expression(exp);
        EvaluationValue result = expression.evaluate();
        return result.getNumberValue().doubleValue();
    }
}
