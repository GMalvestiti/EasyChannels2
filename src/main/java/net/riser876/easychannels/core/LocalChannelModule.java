package net.riser876.easychannels.core;

import net.fabricmc.fabric.api.message.v1.ServerMessageEvents;
import net.minecraft.network.message.SignedMessage;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Box;

import net.riser876.easychannels.EasyChannels;
import net.riser876.easychannels.config.Config;
import net.riser876.easychannels.helpers.PlaceholderApiHelper;

public class LocalChannelModule {
    private static final int LOCAL_CHANNEL_RADIUS = Config.getLocalChannelRadius();
    private static final Text LOCAL_CHANNEL_FORMAT_TEXT = PlaceholderApiHelper.getFormatText(Config.getLocalChannelFormat());
    private static final int LOCAL_CHANNEL_OPERATOR = Config.getLocalChannelOperator();

    public static void register() {
        ServerMessageEvents.ALLOW_CHAT_MESSAGE.register((message, sender, params) -> {
            sendMessageToNearbyPlayers(message, sender);
            return false;
        });

        EasyChannels.LOGGER.info("[EasyChannels] Local channel module registered");
    }

    private static void sendMessageToNearbyPlayers(SignedMessage message, ServerPlayerEntity sender) {
        Text text = PlaceholderApiHelper.formatPlayerMessage(LOCAL_CHANNEL_FORMAT_TEXT, sender, message.getContent());

        Box boundingBox = sender.getBoundingBox().expand(LOCAL_CHANNEL_RADIUS);

        for (ServerPlayerEntity player : sender.getServerWorld().getEntitiesByClass(ServerPlayerEntity.class, boundingBox, entity -> true)) {
            player.sendMessage(text);
        }
    }
}
