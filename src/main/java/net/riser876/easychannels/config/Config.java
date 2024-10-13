package net.riser876.easychannels.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import net.fabricmc.loader.api.FabricLoader;
import net.riser876.easychannels.config.data.ConfigData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Config {
    public static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("easychannels.json");
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    private static ConfigData configData = null;

    public static void load() {
        if (Files.notExists(CONFIG_PATH)) {
            loadDefaultConfig();
            return;
        }

        try {
            String json = new String(Files.readAllBytes(CONFIG_PATH));
            configData = gson.fromJson(json, ConfigData.class);
            saveConfig();
        } catch (IOException | JsonSyntaxException e) {
            e.printStackTrace();
        }
    }

    private static void loadDefaultConfig() {
        configData = new ConfigData();
        saveConfig();
    }

    private static void saveConfig() {
        try {
            String json = gson.toJson(configData);
            Files.write(CONFIG_PATH, json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getLocalChannelRadius() {
        return configData.localChannel.radius;
    }

    public static boolean isLocalChannelEnabled() {
        return configData.localChannel.enabled;
    }

    public static String getLocalChannelFormat() {
        return configData.localChannel.format;
    }

    public static int getLocalChannelOperator() {
        return configData.localChannel.op;
    }

    public static boolean isGlobalChannelEnabled() {
        return configData.globalChannel.enabled;
    }

    public static boolean isGlobalChannelDimensionOnly() {
        return configData.globalChannel.dimensionOnly;
    }

    public static String getGlobalChannelLiteral() {
        return configData.globalChannel.literal;
    }

    public static String getGlobalChannelFormat() {
        return configData.globalChannel.format;
    }

    public static int getGlobalChannelOperator() {
        return configData.globalChannel.op;
    }
}
