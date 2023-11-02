package me.trouper;

import me.trouper.Functions.Complexers;

import java.util.Random;
import java.util.Scanner;

import static me.trouper.Functions.Eval.eval;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Target Integer (or a non-integer to exit): ");
            if (scanner.hasNextInt()) {
                int target = scanner.nextInt();
                String expression = generateObfuscatedExpression(target);
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

    public static String generateObfuscatedExpression(int target) {
        StringBuilder expression = new StringBuilder();
        Random random = new Random();

        int initializer = random.nextInt(9)+1;
        System.out.println("Initializing Expression: " + initializer);
        expression.append(initializer);

        while (eval(expression.toString()) != target) {
            System.out.println("Current: " + eval(expression.toString()));
            int ri = random.nextInt(9)+1;
            int op = random.nextInt(2);
            System.out.println("Random: " + ri);
            if (eval(expression.toString()) < target) {
                expression.append("+").append((op == 0) ? Complexers.divide(ri) : Complexers.root(ri));
                System.out.println("Less than");
            }
            if (eval(expression.toString()) > target) {
                expression.insert(0,"(").append(")");
                expression.append("-").append((op == 0) ? Complexers.divide(ri) : Complexers.root(ri));
                System.out.println("Greater than");
            }
        }

        System.out.println("Broke out of loop. Value: " + eval(expression.toString()));
        System.out.println("Expression: " + expression.toString());

        return expression.toString();
    }


}
