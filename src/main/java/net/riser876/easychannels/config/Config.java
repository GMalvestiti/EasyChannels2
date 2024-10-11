package net.riser876.easychannels.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import net.fabricmc.loader.api.FabricLoader;
import net.riser876.easychannels.config.data.ConfigData;
import net.riser876.easychannels.config.data.CustomChannelData;
import net.riser876.easychannels.config.data.LocalChannelData;

import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Config {
    public static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("easychannels.json");
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static ConfigData configData = null;

    public static void loadConfig() {
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

    public static ConfigData getConfigData() {
        return configData;
    }

    public static LocalChannelData getLocalChannel() {
        return configData.localChannel;
    }

    public static List<CustomChannelData> getCustomChannels() {
        return configData.customChannels;
    }

    public static List<CustomChannelData> getEnabledCustomChannels() {
        return configData.customChannels.stream().filter(channel -> channel.enabled).toList();
    }
}
