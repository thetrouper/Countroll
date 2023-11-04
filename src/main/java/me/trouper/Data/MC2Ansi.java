package me.trouper.Data;

import java.util.HashMap;
import java.util.Map;

public class MC2Ansi {
    public static Map<String, String> getColors() {
        Map<String, String> minecraftToAnsi = new HashMap<>();
        minecraftToAnsi.put("<&0>", "\u001B[0;30m");
        minecraftToAnsi.put("<&1>", "\u001B[0;34m");
        minecraftToAnsi.put("<&2>", "\u001B[0;32m");
        minecraftToAnsi.put("<&3>", "\u001B[0;36m");
        minecraftToAnsi.put("<&4>", "\u001B[0;31m");
        minecraftToAnsi.put("<&5>", "\u001B[0;35m");
        minecraftToAnsi.put("<&6>", "\u001B[0;33m");
        minecraftToAnsi.put("<&7>", "\u001B[0;37m");
        minecraftToAnsi.put("<&8>", "\u001B[1;30m");
        minecraftToAnsi.put("<&9>", "\u001B[1;34m");
        minecraftToAnsi.put("<&a>", "\u001B[1;32m");
        minecraftToAnsi.put("<&b>", "\u001B[1;36m");
        minecraftToAnsi.put("<&c>", "\u001B[1;31m");
        minecraftToAnsi.put("<&d>", "\u001B[1;35m");
        minecraftToAnsi.put("<&e>", "\u001B[1;33m");
        minecraftToAnsi.put("<&f>", "\u001B[1;37m");
        minecraftToAnsi.put("<&r>", "\u001B[0m");
        return minecraftToAnsi;
    }
    public static Map<String, String> getBackgrounds() {
        Map<String, String> minecraftToAnsiBG = new HashMap<>();
        minecraftToAnsiBG.put("<&0h>", "\u001B[40m");
        minecraftToAnsiBG.put("<&1h>", "\u001B[44m");
        minecraftToAnsiBG.put("<&2h>", "\u001B[42m");
        minecraftToAnsiBG.put("<&3h>", "\u001B[46m");
        minecraftToAnsiBG.put("<&4h>", "\u001B[41m");
        minecraftToAnsiBG.put("<&5h>", "\u001B[45m");
        minecraftToAnsiBG.put("<&6h>", "\u001B[43m");
        minecraftToAnsiBG.put("<&7h>", "\u001B[47m");
        minecraftToAnsiBG.put("<&8h>", "\u001B[40;1m");
        minecraftToAnsiBG.put("<&9h>", "\u001B[44;1m");
        minecraftToAnsiBG.put("<&ah>", "\u001B[42;1m");
        minecraftToAnsiBG.put("<&bh>", "\u001B[46;1m");
        minecraftToAnsiBG.put("<&ch>", "\u001B[41;1m");
        minecraftToAnsiBG.put("<&dh>", "\u001B[45;1m");
        minecraftToAnsiBG.put("<&eh>", "\u001B[43;1m");
        minecraftToAnsiBG.put("<&fh>", "\u001B[47;1m");
        return minecraftToAnsiBG;
    }

}
