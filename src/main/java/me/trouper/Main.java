package me.trouper;

import me.trouper.Functions.Complexers;

import java.util.Random;
import java.util.Scanner;

import static me.trouper.Functions.Eval.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Target Integer: ");
            if (scanner.hasNextInt()) {
                int target = scanner.nextInt();
                String expression = obfInt(target);
                double output = eval(expression);

                System.out.println("\nTarget Integer: " + target);
                if (output == target) {
                    System.out.println("Expression Verified Correct: \n" + expression);
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

    public static String obfInt(int target) {
        StringBuilder expression = new StringBuilder();
        Random random = new Random();

        int initializer = random.nextInt(9)+1;
        System.out.println("Initializing Expression: " + initializer);
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

            if (!isInt(eval(expression.toString()))) {
                System.out.println("Something went horribly wrong, Here is the relevant info." +
                        "\nEvaluation: " + eval(expression.toString()) +
                        "\nRandom Pick: " + ri +
                        "\nOperation: " + op +
                        "\nCaught at: \n" + expression);
                break;
            }

            System.out.println("Random: " + ri);
            System.out.println("Current: " + eval(expression.toString()));

            if (isPerfectSquare(eval)) {
                perfectCount++;
                System.out.println("PERFECT SQUARE TIME! (" + perfectCount+ ")");
                expression.insert(0,"sqrt(").append(")");
                eval = (int) eval(expression.toString());
            }

            if (target - eval > 1000) {
                cubeCount++;
                System.out.println("Enormous than (" + cubeCount + ")");
                expression.append("+").append(Complexers.power(ri,3));
            } else if (target - eval > 100) {
                factorCount++;
                System.out.println("Large than (" + factorCount + ")");
                expression.append("+").append(Complexers.multiply(ri,10));
            }

            if (eval < target) {
                addCount++;
                if (op == 0) {
                    divideCount++;
                } else {
                    rootCount++;
                }
                expression.append("+").append((op == 0) ? Complexers.divide(ri) : Complexers.root(ri));
                System.out.println("Less than (" + addCount + ")");
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
                System.out.println("Greater than (" + subCount + ")");
            }
        }

        System.out.println("Broke out of loop. Value: " + eval(expression.toString()));
        System.out.println("Expression: " + expression.toString());
        System.out.println("Statistics: " +
                "\nCubes: " + cubeCount +
                "\nFactors: " + factorCount +
                "\nAdditions: " + addCount +
                "\nSubtractions: " + subCount +
                "\nRoots Taken: " + rootCount +
                "\nDivisors " + divideCount +
                "\nPerfect Squares Found: " + perfectCount +
                "\nTotal steps taken: " + total);
        return expression.toString();
    }
}
