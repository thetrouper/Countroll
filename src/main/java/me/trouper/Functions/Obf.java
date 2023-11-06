package me.trouper.Functions;

import me.trouper.Main;

import java.util.Random;

import static me.trouper.Functions.Eval.*;
import static me.trouper.Functions.Eval.eval;
import static me.trouper.Utils.Utils.removeColors;
import static me.trouper.Utils.Utils.verbose;

public class Obf {
    /**
     * ObfIntN will work for Numselli's counting bot
     * @param target Integer to reach
     * @param deep When True, doubles the use of Complexers and Increasers
     * @return A colored string
     */
    public static String obfIntN(int target, boolean deep) {
        if (deep) System.out.println("Deep Obfuscation is coming soon!");
        StringBuilder expression = new StringBuilder();

        Random random = new Random();

        int initializer = random.nextInt(9)+1;
        verbose("Initializing Expression: " + initializer);
        expression.append("<&dh><&f>").append(initializer).append("<&r>");


        while (eval(expression.toString()) != target) {
            Main.total++;
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
                Main.perfectCount++;
                verbose("PERFECT SQUARE TIME! (" + Main.perfectCount+ ")");
                expression.insert(0,"<&eh><&b>sqrt(<&r>").append("<&eh><&b>)<&r>");
                eval = (int) eval(expression.toString());
            }

            final String toAdd = Complexers.complex(ri,deep);

            if (eval < target) {
                if (target - eval > 4069) {
                    Main.expCount++;
                    verbose("Large than (" + Main.expCount + ")");
                    expression.append("<&b>*<&r><&a>").append(Increasers.power(ri,3,deep)).append("<&r>");
                } else if (target - eval > 1048) {
                    Main.expCount++;
                    verbose("Large than (" + Main.expCount + ")");
                    expression.append("<&b>*<&r><&a>").append(Increasers.power(ri,2,deep)).append("<&r>");
                } else if (target - eval > 128) {
                    Main.factorCount++;
                    verbose("Big than (" + Main.factorCount + ")");
                    expression.append("<&b>*<&r><&a>").append(Increasers.multiply(ri,9,deep)).append("<&r>");
                }
                Main.addCount++;
                expression.append("<&b>+<&r><&e>").append(toAdd).append("<&r>");
                verbose("Less than (" + Main.addCount + ")");
            }

            if (eval > target) {
                Main.subCount++;
                expression.insert(0,"<&c>(<&r>").append("<&c>)<&r>");
                expression.append("<&b>-<&r><&e>").append(toAdd).append("<&r>");
                verbose("Greater than (" + Main.subCount + ")");
            }
        }

        verbose("Broke out of loop. Value: " + eval(expression.toString()));
        verbose("Expression: " + expression);
        verbose("Expression (Cleaned): " + removeColors(expression.toString()));
        return expression.toString();
    }

    /**
     * ObfIntD will work with DuckGroups's Counting bot
     * @param target Integer to reach
     * @param deep When True, doubles the use of Complexers and Increasers
     * @return A colored string
     */
    public static String obfIntD(int target, boolean deep) {
        if (deep) System.out.println("Deep Obfuscation is coming soon!");
        StringBuilder expression = new StringBuilder();

        Random random = new Random();

        int initializer = random.nextInt(9)+1;
        verbose("Initializing Expression: " + initializer);
        expression.append("<&dh><&f>").append(initializer).append("<&r>");

        while (eval(expression.toString()) != target) {
            Main.total++;
            int eval = (int) eval(expression.toString());
            int ri = random.nextInt(9)+1;


            final String toAdd = Complexers.complex(ri,deep);

            if (eval < target) {
                if (target - eval > 4096) {
                Main.expCount++;
                expression.append("<&b>*<&r>").append(Increasers.power(ri,4,deep));
                } else if (target - eval > 1048) {
                    Main.expCount++;
                    expression.append("<&b>*<&r>").append(Increasers.power(ri,2,deep));
                } else if (target - eval > 128) {
                    Main.factorCount++;
                    expression.append("<&b>*<&r>").append(Increasers.multiply(ri,2,deep));
                }
                Main.addCount++;
                expression.append("<&b>+<&r>").append(toAdd);
            }
            if (eval > target) {
                if (eval - target > 4096) {
                    Main.expCount++;
                    expression.append("<&b>-<&r>").append(Increasers.power(ri,5,deep));
                } else if (eval - target> 1048) {
                    Main.expCount++;
                    expression.append("<&b>-<&r>").append(Increasers.power(ri,3,deep));
                } else if (eval - target > 128) {
                    Main.factorCount++;
                    expression.append("<&b>-<&r>").append(Increasers.multiply(ri,2,deep));
                }
                Main.subCount++;
                expression.insert(0,"<&c>(<&r>").append("<&c>)<&r>");
                expression.append("<&b>-<&r>").append(toAdd);
            }
        }
        return expression.toString();
    }
}
