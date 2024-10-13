package net.riser876.easychannels.helpers;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.PlayerManager;

public class PlayerManagerHelper {
    public static PlayerManager PLAYER_MANAGER = null;

    public static void init() {
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            PlayerManagerHelper.PLAYER_MANAGER = server.getPlayerManager();
        });

        ServerLifecycleEvents.SERVER_STOPPED.register(server -> {
            PlayerManagerHelper.PLAYER_MANAGER = null;
        });
    }
}
