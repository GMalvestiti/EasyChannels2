package net.riser876.easychannels.core;

import net.fabricmc.fabric.api.message.v1.ServerMessageEvents;
import net.minecraft.network.message.MessageType;
import net.minecraft.network.message.SentMessage;
import net.minecraft.network.message.SignedMessage;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Box;
import net.riser876.easychannels.config.Config;

public class LocalChannelManager {
    private static final int LOCAL_CHANNEL_RADIUS = Config.getLocalChannelRadius();

    public static void init() {
        if (!Config.isLocalChannelEnabled()) {
            return;
        }

        ServerMessageEvents.ALLOW_CHAT_MESSAGE.register((message, sender, params) -> {
            sendMessageToNearbyPlayers(message, sender, params);
            return false;
        });
    }

    private static void sendMessageToNearbyPlayers(SignedMessage message, ServerPlayerEntity sender, MessageType.Parameters params) {
        Box boundingBox = sender.getBoundingBox().expand(LOCAL_CHANNEL_RADIUS);

        ServerWorld world = sender.getServerWorld();

        for (ServerPlayerEntity player : world.getEntitiesByClass(ServerPlayerEntity.class, boundingBox, entity -> true)) {
            player.sendChatMessage(SentMessage.of((SignedMessage) message), false, params);
        }
    }
}
