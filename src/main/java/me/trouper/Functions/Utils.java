package me.trouper.Functions;

import me.trouper.Main;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class Utils {
    public static void copyToClip(String text) {
        StringSelection parsed = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(parsed,null);
    }
    public static void verbose(String text) {
        if (Main.verbose) System.out.println(text);
    }
}
