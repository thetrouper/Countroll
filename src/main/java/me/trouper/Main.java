package me.trouper;

import me.trouper.Functions.Obf;
import me.trouper.Utils.Timer;
import me.trouper.Utils.Utils;

import java.util.Scanner;

import static me.trouper.Functions.Eval.eval;
import static me.trouper.Utils.Utils.removeColors;

public class Main {
    public static boolean verbose;
    public static boolean deep;
    public static boolean color;
    public static boolean printHelp;
    /* Statistics */
    public static int expCount = 0;
    public static int factorCount = 0;
    public static int addCount = 0;
    public static int subCount = 0;
    public static int divideCount = 0;
    public static int powerCount = 0;
    public static int rDivisorCount = 0;
    public static int rDividendCount = 0;
    public static int rootCount = 0;
    public static int perfectCount = 0;
    public static int total = 0;
    public static void clearStats() {
         expCount = 0;
         factorCount = 0;
         addCount = 0;
         subCount = 0;
         divideCount = 0;
         powerCount = 0;
         rDivisorCount = 0;
         rDividendCount = 0;
         rootCount = 0;
         perfectCount = 0;
         total = 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean doCopy = false;
        String mode = "N";


        for (String arg : args) {
            switch (arg) {
                case "--copy", "-c" -> doCopy = true;
                case "--verbose", "-v" -> verbose = true;
                case "--deep", "-d" -> deep = true;
                case "--color", "-rgb" -> color = true;
                case "--help", "--h", "-h" -> printHelp = true;
                case "--mode=numselli", "-m=n" -> mode = "N";
                case "--mode=duckgroup", "-m=d" -> mode = "D";
                case "--mode=TEST" -> mode = "TEST";
            }
        }

        if (mode.equals("TEST")) {
            while (true) {
                System.out.print("Enter an expression (or 'exit' to exit): ");
                String userInput = scanner.next();

                if (userInput.equals("exit")) {
                    System.exit(0);
                }

                try {
                    double result = eval(userInput);
                    System.out.println("Result: " + result);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }

        if (printHelp) Utils.printHelp();
        if (color) Utils.printColorKey();

        while (true) {
            System.out.print("Enter Target Integer: ");
            if (scanner.hasNextInt()) {
                int target = scanner.nextInt();
                Timer obfTimer = Timer.start();
                String expression = null;
                switch (mode) {
                    case "N" -> expression = Obf.obfIntN(target, deep);
                    case "D" -> expression = Obf.obfIntD(target, deep);
                }
                long obfTime = obfTimer.end().timePassed();
                double output = eval(removeColors(expression));

                System.out.println("\nStatistics" +
                        "\nExponents: " + expCount +
                        "\nFactors: " + factorCount +
                        "\nAdditions: " + addCount +
                        "\nSubtractions: " + subCount +
                        "\nDivisors: " + divideCount +
                        "\nPowers: " + powerCount +
                        "\nmRootDividends: " + rDividendCount +
                        "\nmRootDivisors: " + rDivisorCount +
                        "\nRoots Taken: " + rootCount +
                        "\nPerfect Squares Found: " + perfectCount +
                        "\nTotal steps taken: " + total);
                System.out.println("\nElapsed Time: " + obfTime + "ms");
                System.out.println("\nTarget Integer: " + target);

                if (output == target) {
                    System.out.println(Utils.activateColors("<&2h><&f>Expression Correct<&r>\n\n" + ((color) ? expression : removeColors(expression))));
                    if (doCopy) Utils.copyToClip(removeColors(expression));
                    clearStats();
                } else {
                    System.out.println(Utils.activateColors("<&ch><&0>!!!! INCORRECT !!!!<&r>\n\n" + ((color) ? expression : removeColors(expression))));
                }
            } else {
                System.out.println("Exiting the program.");
                break;
            }
        }

        scanner.close();
    }

}
