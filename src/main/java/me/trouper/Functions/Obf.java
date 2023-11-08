package me.trouper.Functions;

import me.trouper.Countroll;
import me.trouper.Utils.Verbose;

import java.util.Random;

import static me.trouper.Functions.Eval.*;
import static me.trouper.Functions.Eval.eval;
import static me.trouper.Utils.Utils.removeColors;

public class Obf {
    public static String obfInt(int target) {
        Verbose.send("PROC", "Starting Obfuscation (Universal)");
        StringBuilder expression = new StringBuilder();
        Random rand = new Random();

        // INIT
        int init = rand.nextInt(9)+1;
        Verbose.send("PROC", "Initializing Expression: " + init);
        expression.append("<&dh><&f>").append(init).append("<&r>");

        // MAIN LOOP
        Verbose.send("PROC", "Beginning Main Loop: ");
        while (eval(expression.toString()) != target) {
            Countroll.total++;
            int current = (int) eval(expression.toString());
            int ri = rand.nextInt(9)+1;
            if (Countroll.showProgress) System.out.println("Current Evaluation: " + current);

            // Checking for it still being a whole number
            if (!isInt(eval(expression.toString()))) {
                System.out.println("Something went horribly wrong, Here is the relevant info." +
                        "\nEvaluation: " + eval(expression.toString()) +
                        "\nRandom Pick: " + ri +
                        "\nCaught at: \n" + removeColors(expression.toString()));
                break;
            }

            String comp = Complexers.complex(ri,Countroll.deep);
            // Case for if its below
            if (current < target) {
                Countroll.addCount++;
                expression.append("<&b>+<&r><&e>").append(comp).append("<&r>");
                if (target - current > 128) {
                    expression.append("<&b>*<&r><&e>").append(Increasers.increase(current,target,ri,Countroll.deep)).append("<&r>");
                }
            }

            // Case for if its above
            if (current > target) {
                Countroll.subCount++;
                expression.append("<&b>-<&r><&e>").append(comp).append("<&r>");
                if (current - target > 128) {
                    expression.append("<&b>-<&r><&e>").append(Increasers.increase(target,current,ri,Countroll.deep)).append("<&r>");
                }
            }
        }
        Verbose.send("PROC", "Broke out of loop.");
        return expression.toString();
    }
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
        Verbose.send("PROC","Initializing Expression: " + initializer);
        expression.append("<&dh><&f>").append(initializer).append("<&r>");


        while (eval(expression.toString()) != target) {
            Countroll.total++;
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

            Verbose.send("LOOP","Random: " + ri);
            Verbose.send("LOOP","Current: " + eval(expression.toString()));

            if (isPerfectSquare(eval) && eval != 1) {
                Countroll.perfectCount++;
                Verbose.send("LOOP","PERFECT SQUARE TIME! (" + Countroll.perfectCount+ ")");
                expression.insert(0,"<&eh><&b>sqrt(<&r>").append("<&eh><&b>)<&r>");
                eval = (int) eval(expression.toString());
            }

            final String toAdd = Complexers.complex(ri,deep);

            if (eval < target) {
                if (target - eval > 4069) {
                    Countroll.expCount++;
                    Verbose.send("LOOP","Large than (" + Countroll.expCount + ")");
                    expression.append("<&b>*<&r><&a>").append(Increasers.power(ri,3,deep)).append("<&r>");
                } else if (target - eval > 1048) {
                    Countroll.expCount++;
                    Verbose.send("LOOP","Large than (" + Countroll.expCount + ")");
                    expression.append("<&b>*<&r><&a>").append(Increasers.power(ri,2,deep)).append("<&r>");
                } else if (target - eval > 128) {
                    Countroll.factorCount++;
                    Verbose.send("LOOP","Big than (" + Countroll.factorCount + ")");
                    expression.append("<&b>*<&r><&a>").append(Increasers.multiply(ri,9,deep)).append("<&r>");
                }
                Countroll.addCount++;
                expression.append("<&b>+<&r><&e>").append(toAdd).append("<&r>");
                Verbose.send("LOOP","Less than (" + Countroll.addCount + ")");
            }

            if (eval > target) {
                Countroll.subCount++;
                expression.insert(0,"<&c>(<&r>").append("<&c>)<&r>");
                expression.append("<&b>-<&r><&e>").append(toAdd).append("<&r>");
                Verbose.send("LOOP","Greater than (" + Countroll.subCount + ")");
            }
        }

        Verbose.send("PROC","Broke out of loop. Value: " + eval(expression.toString()));
        Verbose.send("EVAL","Expression: " + expression);
        Verbose.send("EVAL","Expression (Cleaned): " + removeColors(expression.toString()));
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
        expression.append("<&dh><&f>").append(initializer).append("<&r>");

        while (eval(expression.toString()) != target) {
            Countroll.total++;
            int eval = (int) eval(expression.toString());
            int ri = random.nextInt(9)+1;


            final String toAdd = Complexers.complex(ri,deep);

            if (eval < target) {
                if (target - eval > 4096) {
                Countroll.expCount++;
                expression.append("<&b>*<&r>").append(Increasers.power(ri,4,deep));
                } else if (target - eval > 1048) {
                    Countroll.expCount++;
                    expression.append("<&b>*<&r>").append(Increasers.power(ri,2,deep));
                } else if (target - eval > 128) {
                    Countroll.factorCount++;
                    expression.append("<&b>*<&r>").append(Increasers.multiply(ri,2,deep));
                }
                Countroll.addCount++;
                expression.append("<&b>+<&r>").append(toAdd);
            }
            if (eval > target) {
                if (eval - target > 4096) {
                    Countroll.expCount++;
                    expression.append("<&b>-<&r>").append(Increasers.power(ri,5,deep));
                } else if (eval - target> 1048) {
                    Countroll.expCount++;
                    expression.append("<&b>-<&r>").append(Increasers.power(ri,3,deep));
                } else if (eval - target > 128) {
                    Countroll.factorCount++;
                    expression.append("<&b>-<&r>").append(Increasers.multiply(ri,2,deep));
                }
                Countroll.subCount++;
                expression.insert(0,"<&c>(<&r>").append("<&c>)<&r>");
                expression.append("<&b>-<&r>").append(toAdd);
            }
        }
        return expression.toString();
    }
}
