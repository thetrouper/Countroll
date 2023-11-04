package me.trouper.Functions;

import java.util.Random;

import static me.trouper.Functions.Eval.*;
import static me.trouper.Functions.Eval.eval;
import static me.trouper.Utils.Utils.removeColors;
import static me.trouper.Utils.Utils.verbose;

public class Obf {
    public static String obfInt(int target, boolean deep) {
        if (deep) System.out.println("Deep Obfuscation is coming soon!");
        StringBuilder expression = new StringBuilder();

        Random random = new Random();

        int initializer = random.nextInt(9)+1;
        verbose("Initializing Expression: " + initializer);
        expression.append("<&dh><&f>").append(initializer).append("<&r>");

        int cubeCount = 0;
        int factorCount = 0;
        int addCount = 0;
        int subCount = 0;
        int rootCount = 0;
        int divideCount = 0;
        int perfectCount = 0;
        int total = 0;

        while (eval(expression.toString()) != target) {
            total++;
            int eval = (int) eval(expression.toString());
            int ri = random.nextInt(9)+1;
            int op = random.nextInt(2);
            boolean mult = false;

            if (!isInt(eval(expression.toString()))) {
                System.out.println("Something went horribly wrong, Here is the relevant info." +
                        "\nEvaluation: " + eval(expression.toString()) +
                        "\nRandom Pick: " + ri +
                        "\nOperation: " + op +
                        "\nCaught at: \n" + removeColors(expression.toString()));
                break;
            }

            verbose("Random: " + ri);
            verbose("Current: " + eval(expression.toString()));

            if (isPerfectSquare(eval) && eval != 1) {
                perfectCount++;
                verbose("PERFECT SQUARE TIME! (" + perfectCount+ ")");
                expression.insert(0,"<&eh><&b>sqrt(<&r>").append("<&eh><&b>)<&r>");
                eval = (int) eval(expression.toString());
            }
            if (target - eval > 4069) {
                mult = true;
                cubeCount++;
                verbose("Large than (" + cubeCount + ")");
                final String toAdd = Increasers.power(ri,3);
                expression.append("<&b>+<&r><&a>").append(toAdd).append("<&r>");
            } else if (target - eval > 1048) {
                mult = true;
                cubeCount++;
                verbose("Large than (" + cubeCount + ")");
                final String toAdd = Increasers.power(ri,2);
                expression.append("<&b>+<&r><&a>").append(toAdd).append("<&r>");
            } else if (target - eval > 128) {
                factorCount++;
                verbose("Big than (" + factorCount + ")");
                final String toAdd = Increasers.multiply(ri,9);
                expression.append("<&b>+<&r><&a>").append(toAdd).append("<&r>");
                continue;
            }

            if (eval < target) {
                addCount++;
                if (op == 0) {
                    divideCount++;
                } else {
                    rootCount++;
                }

                final String toAdd = (op == 0) ? Complexers.divide(ri) : Complexers.root(ri);

                expression.append((mult) ? "<&b>*<&r>" : "<&b>+<&r><&e>").append(toAdd).append("<&r>");
                verbose("Less than (" + addCount + ")");
            }

            if (eval > target) {
                subCount++;
                if (op == 0) {
                    divideCount++;
                } else {
                    rootCount++;
                }

                final String toAdd = (op == 0) ? Complexers.divide(ri) : Complexers.root(ri);
                /*
                String colored = Utils.highlightReg(toAdd);
                if (deep) {
                    colored = Utils.highlightDeep(toAdd);
                }*/
                expression.insert(0,"<&c>(<&r>").append("<&c>)<&r>");
                expression.append("<&b>-<&r><&e>").append(toAdd).append("<&r>");
                verbose("Greater than (" + subCount + ")");
            }
        }

        verbose("Broke out of loop. Value: " + eval(expression.toString()));
        verbose("Expression: " + expression);
        verbose("Expression (Cleaned): " + removeColors(expression.toString()));
        System.out.println("\n\n\n\nStatistics: " +
                "\nCubes: " + cubeCount +
                "\nFactors: " + factorCount +
                "\nAdditions: " + addCount +
                "\nSubtractions: " + subCount +
                "\nRoots Taken: " + rootCount +
                "\nDivisors: " + divideCount +
                "\nPerfect Squares Found: " + perfectCount +
                "\nTotal steps taken: " + total);
        return expression.toString();
    }
}
