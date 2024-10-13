package net.riser876.easychannels.core;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import net.riser876.easychannels.EasyChannels;
import net.riser876.easychannels.config.Config;

public class ModuleLoader {
    public static MinecraftServer MINECRAFT_SERVER = null;

    public static void register() {
        loadServer();
        loadModules();
    }

    private static void loadServer() {
        if (!Config.isGlobalChannelEnabled()) {
            return;
        }

        ServerLifecycleEvents.SERVER_STARTED.register(minecraftServer -> {
            MINECRAFT_SERVER = minecraftServer;
        });
    }

    private static void loadModules() {
        LocalChannelModule.register();
        EasyChannels.LOGGER.info("[EasyChannels] Local channel module loaded");
        GlobalChannelModule.register();
        EasyChannels.LOGGER.info("[EasyChannels] Global channel module loaded");
    }
}
