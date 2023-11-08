package me.trouper.Data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import me.trouper.Countroll;
import me.trouper.Functions.Complexers;
import me.trouper.Utils.Verbose;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ConfigManager {
    private static final String CONFIG_FILENAME = "countroll.json";

    public static void loadConfig() {
        File configFile = new File(CONFIG_FILENAME);

        if (!configFile.exists()) {
            generateDefaultConfig();
        } else {
            try (Reader reader = new FileReader(configFile)) {
                Gson gson = new Gson();
                Map<String, Object> config = gson.fromJson(reader, HashMap.class);
                getConfig(config);
            } catch (JsonSyntaxException | JsonIOException | IOException e) {
                e.printStackTrace();
                generateDefaultConfig();
            }
        }
    }

    private static void generateDefaultConfig() {
        Map<String, Object> defaultConfig = new HashMap<>();
        defaultConfig.put("useDivide", true);
        defaultConfig.put("usePower", true);
        defaultConfig.put("useRoot", true);
        defaultConfig.put("useModDividend", true);
        defaultConfig.put("doCopy", false);
        defaultConfig.put("deep", false);
        defaultConfig.put("color", true);
        defaultConfig.put("printHelp", false);
        defaultConfig.put("mode", "U");
        defaultConfig.put("show.progress", false);
        defaultConfig.put("verbose.all",false);
        defaultConfig.put("verbose.processes",true);
        defaultConfig.put("verbose.loops",false);
        defaultConfig.put("verbose.eval",false);
        defaultConfig.put("verbose.complexers",false);
        defaultConfig.put("verbose.increasers",false);
        defaultConfig.put("verbose.utils",false);
        defaultConfig.put("verbose.errors",true);

        try (Writer writer = new FileWriter(CONFIG_FILENAME)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(defaultConfig, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        getConfig(defaultConfig);
    }

    private static void getConfig(Map<String, Object> config) {
        Verbose.send("INIT", "Loading main class variables");
        Complexers.useDivide = (boolean) config.get("useDivide");
        Complexers.usePower = (boolean) config.get("usePower");
        Complexers.useRoot = (boolean) config.get("useRoot");
        Complexers.useRDividend = (boolean) config.get("useModDividend");
        Countroll.showProgress = (boolean) config.get("show.progress");
        Countroll.doCopy = (boolean) config.get("doCopy");
        Countroll.deep = (boolean) config.get("deep");
        Countroll.color = (boolean) config.get("color");
        Countroll.printHelp = (boolean) config.get("printHelp");
        Countroll.mode = (String) config.get("mode");
        Verbose.all = (boolean) config.get("verbose.all");
        Verbose.processes = (boolean) config.get("verbose.processes");
        Verbose.loops = (boolean) config.get("verbose.loops");
        Verbose.eval = (boolean) config.get("verbose.eval");
        Verbose.complexers = (boolean) config.get("verbose.complexers");
        Verbose.increasers = (boolean) config.get("verbose.increasers");
        Verbose.utils = (boolean) config.get("verbose.utils");
        Verbose.errors = (boolean) config.get("verbose.errors");
        Verbose.send("INIT","mode = " + Countroll.mode);
    }
}
