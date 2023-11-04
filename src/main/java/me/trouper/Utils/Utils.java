package me.trouper.Utils;

import me.trouper.Data.MC2Ansi;
import me.trouper.Main;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Map;

public class Utils {
    public static void copyToClip(String text) {
        StringSelection parsed = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(parsed,null);
    }
    public static void verbose(String text) {
        if (Main.verbose) System.out.println(text);
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
        System.out.println("Usage: java -jar Countroll-<version>.jar [options]");
        System.out.println("Options:");
        System.out.println("  --copy, -c    Copy the generated expression to the clipboard");
        System.out.println("  --verbose, -v Enable verbose mode");
        System.out.println("  --deep, -d    Enable deep obfuscation (under development)");
        System.out.println("  --color, -rgb Enable colored output");
        System.out.println("  --help, --h, -h Show this help message");
        System.out.println("Note: When using multiple options, separate them with spaces.");
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
    /*
    public static String highlightReg(String exp) {
        final String result = exp
                .replaceAll("\\(", ANSI.WHITE + "(" + ANSI.RESET)
                .replaceAll("\\)", ANSI.WHITE + ")" + ANSI.RESET)
                .replaceAll("\\*", ANSI.BLUE + "*" + ANSI.RESET)
                .replaceAll("/", ANSI.BLUE + "/" + ANSI.RESET)
                .replaceAll("\\+", ANSI.BLUE + "+" + ANSI.RESET)
                .replaceAll("-", ANSI.BLUE + "-" + ANSI.RESET)
                .replaceAll("\\^", ANSI.BLUE + "^" + ANSI.RESET)
                .replaceAll("\\d+", ANSI.GREEN + "$0" + ANSI.RESET);
        verbose("Attempting Ansi Highlight: " + result);
        return result;
    }

    public static String highlightDeep(String exp) {
        final String result = exp
                .replaceAll("\\(", ANSI.CYAN + "*" + ANSI.RESET)
                .replaceAll("\\)", ANSI.CYAN + "*" + ANSI.RESET)
                .replaceAll("\\*", ANSI.BLUE + "*" + ANSI.RESET)
                .replaceAll("/", ANSI.BLUE + "/" + ANSI.RESET)
                .replaceAll("\\+", ANSI.BLUE + "+" + ANSI.RESET)
                .replaceAll("-", ANSI.BLUE + "-" + ANSI.RESET)
                .replaceAll("\\^", ANSI.BLUE + "^" + ANSI.RESET)
                .replaceAll("\\d+", ANSI.PURPLE + "$0" + ANSI.RESET);
        verbose("Attempting Ansi Highlight (Deep): " + result);
        return result;
    }
    public static String fixAnsi(String input) {
        Pattern pattern = Pattern.compile("(\\[\\d+m)");
        Matcher matcher = pattern.matcher(input);
        StringBuffer sb = new StringBuffer();

        while (matcher.find()) {
            // Check if the escape code was not properly closed (e.g., missing reset code)
            if (input.substring(matcher.start()).indexOf(ANSI.RESET) < 0) {
                String escapeCode = matcher.group(1);
                // Re-escape the ANSI escape code
                matcher.appendReplacement(sb, escapeCode);
            }
        }
        matcher.appendTail(sb);

        return sb.toString();
    }*/
}
