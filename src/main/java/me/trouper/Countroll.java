package me.trouper;

import me.trouper.Data.ConfigManager;
import me.trouper.Functions.Complexers;
import me.trouper.Functions.Obf;
import me.trouper.Utils.Timer;
import me.trouper.Utils.Utils;
import me.trouper.Utils.Verbose;

import java.util.Scanner;

import static me.trouper.Functions.Eval.eval;
import static me.trouper.Utils.Utils.copyToClip;
import static me.trouper.Utils.Utils.removeColors;

public class Countroll {
    public static boolean showProgress;
    public static boolean doCopy;
    public static boolean deep;
    public static boolean color;
    public static boolean printHelp;
    public static String mode;

    /* Statistics */
    public static int errorCount = 0;
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
         errorCount = 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConfigManager.loadConfig();

        parseCommandLineArguments(args);

        Verbose.send("INIT", "Loading config");
        Verbose.send("INIT", "Config loaded, mode: " + mode);

        if (mode.equals("D")) {
            Complexers.useRoot = false;
        }

        if (mode.equals("TEST")) {
            handleTestMode(scanner);
        }

        if (printHelp) {
            Utils.printHelp();
            System.exit(0);
        }
        if (color) {
            Utils.printColorKey();
        }

        handleTargetIntegers(scanner);
        scanner.close();
    }

    private static void parseCommandLineArguments(String[] args) {
        for (String arg : args) {
            switch (arg) {
                case "--copy", "-c" -> doCopy = true;
                case "--verbose", "-v" -> Verbose.all = true;
                case "--deep", "-d" -> deep = true;
                case "--color", "-rgb" -> color = true;
                case "--help", "--h", "-h" -> printHelp = true;
                case "--mode=test", "-m=t" -> mode = "TEST";
                case "--mode=duckgroup", "-m=d" -> mode = "D";
                case "--mode=numselli", "-m=n" -> mode = "N";
                case "--mode=universal", "-m=u" -> mode = "U";
            }
        }
    }

    private static void handleTestMode(Scanner scanner) {
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

    private static void handleTargetIntegers(Scanner scanner) {
        while (true) {
            System.out.print("Enter Target Integer: ");
            if (scanner.hasNextInt()) {
                int target = scanner.nextInt();

                Timer obfTimer = Timer.start();
                String expression = Obf.obfInt(target);
                long obfTime = obfTimer.end().timePassed();

                double output = eval(removeColors(expression));

                printStatistics(obfTime);
                printReport(target,expression,output);
                if (doCopy) copyToClip(removeColors(expression));
            } else {
                System.out.println("Exiting the program.");
                break;
            }
        }
    }
    private static void printReport(int target, String expression, double output) {
        String report;
        if (target == output) {
             report = String.format("""
                 ╔═══════[ Report ]═════════
                 ║ Target Integer: %d
                 ║ Final Result: %s <&ah><&b>✔<&r>
                 ║ Expression Length: %s
                 ╚══════════════════════════
                     
             >> %s
             """,target,output,expression.length(),expression);
        } else {
            report = String.format("""
                ╔═══════[ Report ]═════════
                ║ Target Integer: %d
                ║ Final Result: %s <&ch><&e>❌<&r>
                ║ Expression Length: %s
                ╚══════════════════════════
                
            >>  %s
            """,target,output,expression.length(),expression);
        }
        System.out.println((color) ? Utils.activateColors(report) : removeColors(report));
    }

    private static void printStatistics(long time) {
        String statistics = String.format("""
        
        ╔═══════[ Statistics ]═════════
        ║ Exponents: %d
        ║ Factors: %d
        ║ Additions: %d
        ║ Subtractions: %d
        ║ Divisors: %d
        ║ Powers: %d
        ║ mRootDividends: %d
        ║ Roots Taken: %d
        ║ Perfect Squares Found: %d
        ║ Errors: %d
        ╠══════════════════════════════
        ║ Total steps taken: %d
        ║ Elapsed Time: %d
        ╚══════════════════════════════
    """, expCount, factorCount, addCount, subCount, divideCount, powerCount, rDividendCount, rootCount, perfectCount, errorCount, total, time);
        System.out.println(statistics);
    }
}
