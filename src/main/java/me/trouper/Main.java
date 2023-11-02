package me.trouper;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.Random;
import java.util.Scanner;

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
            System.out.println("Random: " + ri);
            if (eval(expression.toString()) < target) {
                int squared = (int) Math.pow(ri,2);
                String back = "sqrt(" + squared + ")";
                expression.append("+").append(back);
                System.out.println("Less than");
            }
            if (eval(expression.toString()) > target) {
                int f = random.nextInt(9)+1;
                int doubled = ri * f;
                String back = "(" + doubled + "/" + f +")";
                expression.insert(0,"(");
                expression.append(")").append("-").append(back);
                System.out.println("Greater than");
            }
        }

        System.out.println("Broke out of loop. Value: " + eval(expression.toString()));
        System.out.println("Expression: " + expression.toString());

        return expression.toString();
    }

    public static double eval(String expression) {
        Expression exp = new ExpressionBuilder(expression).build();
        return exp.evaluate();
    }
/*
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a target Integer: ");
            if (reader.hasNextInt()) {
                int target = reader.nextInt();
                String obfuscatedExpression = generateObfuscatedExpression(target);
                Expression exp = new ExpressionBuilder(obfuscatedExpression).build();
                if (exp.evaluate() == target) {
                    System.out.println("Target Integer: " + target + "\n" +
                            "Output is Verified Correct!\n" +
                            "Expression: " + obfuscatedExpression);
                } else {
                    System.out.println("Target Integer: " + target + "\n" +
                            "INCORRECT OUTPUT GENERATED!\n" +
                            "Expression: " + obfuscatedExpression);
                }
            } else {
                System.out.println("Exiting the program.");
                break;
            }
        }

        reader.close();
    }
 */
}
