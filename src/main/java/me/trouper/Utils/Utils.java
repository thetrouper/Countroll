package me.trouper.Utils;

import me.trouper.Data.MC2Ansi;
import me.trouper.Countroll;
import me.trouper.Functions.Eval;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Map;

public class Utils {
    public static int calcExp(int difference) {
        int result = 1;
        
        if (difference >= 4096) result = 2;
        if (difference >= 8192) result = 3;
        if (difference >= 16384) result = 4;
        if (difference >= 32768) result = 5;
        if (difference >= 65536) result = 6;
        if (difference >= 131072) result = 7;
        if (difference >= 262144) result = 8;
        if (difference >= 524288) result = 9;
        if (difference >= 1048576) result = 10;

        return result;
    }
    public static void copyToClip(String text) {
        StringSelection parsed = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(parsed,null);
    }
    public static String removeColors(String input) {
        return input.replaceAll("<&[0-9a-fr]>|<&[0-9a-frh]h>", "");
    }
    public static String activateColors(String input) {
        Map<String, String> minecraftToAnsi = MC2Ansi.getColors();

        Map<String, String> minecraftBackgroundsToAnsi = MC2Ansi.getBackgrounds();

        for (Map.Entry<String, String> entry : minecraftToAnsi.entrySet()) {
            input = input.replace(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, String> entry : minecraftBackgroundsToAnsi.entrySet()) {
            input = input.replace(entry.getKey(), entry.getValue());
        }

        input += "\u001B[0m\u001B[49m";

        return input;
    }

    public static void printHelp() {
        System.out.println("""
                Usage: java -jar Countroll-<version>.jar [options]
                Options: values are formated as such: -m=d or -t=root
                  --copy, -c      Copy the generated expression to the clipboard
                  --verbose, -v   Enable verbose mode
                  --deep, -d      Enable deep obfuscation (under development)
                  --color, -rgb   Enable colored output
                  --help, --h, -h Show this help message
                  --mode, -m      Toggle the mode Values (Long): [duckgroup, numselli] Values (Brief): [d, n]
                  --toggle, -t    Toggle off Complexer Values: [divide, power, root, mrDividend, mrDivisor]
                Note: When using multiple options, separate them with spaces.""");
        System.exit(0);
    }
    public static void printColorKey() {
        String colorKey = "\nColor Key: " +
                "\n<&c>Red Parentheses:<&r> Gets Subtracted" +
                "\n<&b><&eh>Blue/Yellow:<&r> Perfect Square" +
                "\n<&a>Green:<&r> Increaser" +
                "\n<&9>Blue:<&r> Operation" +
                "\n<&e>Yellow:<&r> Complexer";
        System.out.println(activateColors(colorKey));
    }

    /**
     * Returns the divisor of a mod equation given the modulus and dividend
     * 5%x=2 -> x=3
     * @param modulus Remainder
     * @param dividend The number that is getting divided
     * @return The divisor
     */
    public static int moduRootDivisor(int dividend, int modulus) {

        int divisor = dividend - modulus;
        Verbose.send("UTIL","<&1h><&e>Finding mrDivisor:<&r> " +
                "\nDividend (Given): " + dividend +
                "\nDivisor (Unknown): " + divisor +
                "\nModulus (Given): " + modulus +
                "\nCheck: " + dividend + "%" + divisor + "=" + Eval.eval(dividend + "%" + divisor));
        return divisor;
          /*
        int divisor = 1;
        while (divisor * dividend % modulus != 0 || divisor != 1) {
            divisor++;
        }
        return divisor;*/
    }

    /**
     * Returns the dividend of a mod equation given the modulus and divisor
     * x%3=2 -> x=5
     * @param modulus Remainder
     * @param divisor The number that does the dividing
     * @return The dividend
     */
    public static int moduRootDividend(int divisor, int modulus) {
        int dividend = modulus + divisor;
        Verbose.send("UTIL","<&1h><&e>Finding mrDivisor:<&r> " +
                "\nDividend (Unknown): " + dividend +
                "\nDivisor (Given): " + divisor +
                "\nModulus (Given): " + modulus);
        return dividend;
    }

}
