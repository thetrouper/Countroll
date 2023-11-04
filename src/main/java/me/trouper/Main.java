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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean doCopy = false;


        for (String arg : args) {
            switch (arg) {
                case "--copy", "-c" -> doCopy = true;
                case "--verbose", "-v" -> verbose = true;
                case "--deep", "-d" -> deep = true;
                case "--color", "-rgb" -> color = true;
                case "--help", "--h", "-h" -> printHelp = true;
            }
        }

        if (printHelp) Utils.printHelp();
        if (color) Utils.printColorKey();

        while (true) {
            System.out.print("Enter Target Integer: ");
            if (scanner.hasNextInt()) {
                int target = scanner.nextInt();
                Timer obfTimer = Timer.start();
                String expression = Obf.obfInt(target, deep);
                long obfTime = obfTimer.end().timePassed();
                double output = eval(removeColors(expression));

                System.out.println("\nTarget Integer: " + target);
                System.out.println("\nElapsed Time: " + obfTime + "ms");


                if (output == target) {
                    System.out.println(Utils.activateColors("<&2h><&f>Expression Correct<&r>\n\n" + ((color) ? expression : removeColors(expression))));
                    if (doCopy) Utils.copyToClip(removeColors(expression));
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
