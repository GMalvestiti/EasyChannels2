package net.riser876.easychannels.core;

import net.fabricmc.fabric.api.message.v1.ServerMessageEvents;
import net.minecraft.network.message.SignedMessage;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Box;
import net.riser876.easychannels.EasyChannels;
import net.riser876.easychannels.config.Config;
import net.riser876.easychannels.helpers.PermissionsApiHelper;
import net.riser876.easychannels.helpers.PlaceholderApiHelper;

public class LocalChannelModule {
    private static final int CHANNEL_RADIUS = Config.getLocalChannelRadius();
    private static final String CHANNEL_FORMAT = Config.getLocalChannelFormat();
    private static final Object CHANNEL_PERMISSION = PermissionsApiHelper.getPermission("easychannels.channel.local", Config.getLocalChannelOperator());

    public static void register() {
        ServerMessageEvents.ALLOW_CHAT_MESSAGE.register((message, sender, params) -> {
            sendMessageToNearbyPlayers(message, sender);
            return false;
        });

        EasyChannels.LOGGER.info("[EasyChannels] Local channel module registered");
    }

    private static void sendMessageToNearbyPlayers(SignedMessage message, ServerPlayerEntity sender) {
        if (!PermissionsApiHelper.hasPermissionWithNotification(CHANNEL_PERMISSION, sender)) {
            return;
        }

        Text text = PlaceholderApiHelper.formatPlayerMessage(CHANNEL_FORMAT, sender, message.getContent());

        Box boundingBox = sender.getBoundingBox().expand(CHANNEL_RADIUS);

        for (ServerPlayerEntity player : sender.getServerWorld().getEntitiesByClass(ServerPlayerEntity.class, boundingBox, entity -> true)) {
            player.sendMessage(text);
        }
    }
}
