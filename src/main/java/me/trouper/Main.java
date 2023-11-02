package me.trouper;

import me.trouper.Functions.Complexers;
import me.trouper.Functions.Utils;

import java.util.Random;
import java.util.Scanner;

import static me.trouper.Functions.Eval.*;
import static me.trouper.Functions.Utils.verbose;

public class Main {
    public static boolean verbose;
    public static boolean deep;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean doCopy = false;


        for (String arg : args) {
            switch (arg) {
                case "--copy" -> doCopy = true;
                case "--verbose" -> verbose = true;
                case "--deep" -> deep = true;
            }
        }

        while (true) {
            System.out.print("Enter Target Integer: ");
            if (scanner.hasNextInt()) {
                int target = scanner.nextInt();
                String expression = obfInt(target,deep);
                double output = eval(expression);

                System.out.println("\nTarget Integer: " + target);
                if (output == target) {
                    System.out.println("Expression Verified Correct: \n" + expression);
                    if (doCopy) Utils.copyToClip(expression);
                } else {
                    System.out.println("!!!! INCORRECT !!!! \n" + expression);
                }
            } else {
                System.out.println("Exiting the program.");
                break;
            }
        }

        scanner.close();
    }

    public static String obfInt(int target, boolean deep) {
        if (deep) System.out.println("Deep Obfuscation is still in development!");
        StringBuilder expression = new StringBuilder();
        Random random = new Random();

        int initializer = random.nextInt(9)+1;
        verbose("Initializing Expression: " + initializer);
        expression.append(initializer);

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
                        "\nCaught at: \n" + expression);
                break;
            }

            verbose("Random: " + ri);
            verbose("Current: " + eval(expression.toString()));

            if (isPerfectSquare(eval)) {
                perfectCount++;
                verbose("PERFECT SQUARE TIME! (" + perfectCount+ ")");
                expression.insert(0,"sqrt(").append(")");
                eval = (int) eval(expression.toString());
            }

            if (target - eval > 1000) {
                mult = true;
                cubeCount++;
                verbose("Enormous than (" + cubeCount + ")");
                expression.append("+").append(Complexers.power(ri,3));
            } else if (target - eval > 100) {
                factorCount++;
                verbose("Large than (" + factorCount + ")");
                expression.append("+").append(Complexers.multiply(ri,10));
                continue;
            }

            if (eval < target) {
                addCount++;
                if (op == 0) {
                    divideCount++;
                } else {
                    rootCount++;
                }
                expression.append((mult) ? "*" : "+").append((op == 0) ? Complexers.divide(ri) : Complexers.root(ri));
                verbose("Less than (" + addCount + ")");
            }

            if (eval > target) {
                subCount++;
                if (op == 0) {
                    divideCount++;
                } else {
                    rootCount++;
                }
                expression.insert(0,"(").append(")");

                expression.append("-").append((op == 0) ? Complexers.divide(ri) : Complexers.root(ri));
                verbose("Greater than (" + subCount + ")");
            }
        }

        verbose("Broke out of loop. Value: " + eval(expression.toString()));
        verbose("Expression: " + expression);
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
