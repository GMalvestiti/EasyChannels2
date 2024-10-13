package net.riser876.easychannels.core;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import net.riser876.easychannels.EasyChannels;
import net.riser876.easychannels.config.Config;
import net.riser876.easychannels.helpers.CommandHelper;
import net.riser876.easychannels.helpers.PlaceholderApiHelper;
import net.riser876.easychannels.helpers.PlayerManagerHelper;

import java.util.function.BiConsumer;

public class GlobalChannelModule {
    private static final Text GLOBAL_CHANNEL_FORMAT_TEXT = PlaceholderApiHelper.getFormatText(Config.getGlobalChannelFormat());
    private static final String GLOBAL_CHANNEL_LITERAL = Config.getGlobalChannelLiteral();
    private static final int GLOBAL_CHANNEL_OPERATOR = Config.getGlobalChannelOperator();

    public static void register() {
        BiConsumer<Text, ServerPlayerEntity> messageSender;

        if (Config.isGlobalChannelDimensionOnly()) {
            messageSender = GlobalChannelModule::sendMessageToDimension;
        } else {
            messageSender = GlobalChannelModule::sendMessageToServer;
        }

        CommandHelper.register(GLOBAL_CHANNEL_LITERAL, messageSender);

        EasyChannels.LOGGER.info("[EasyChannels] Global channel module registered");
    }

    private static void sendMessageToDimension(Text message, ServerPlayerEntity sender) {
        Text text = PlaceholderApiHelper.formatPlayerMessage(GLOBAL_CHANNEL_FORMAT_TEXT, sender, message);

        for (ServerPlayerEntity player : sender.getServerWorld().getPlayers()) {
            player.sendMessage(text);
        }
    }

    private static void sendMessageToServer(Text message, ServerPlayerEntity sender) {
        Text text = PlaceholderApiHelper.formatPlayerMessage(GLOBAL_CHANNEL_FORMAT_TEXT, sender, message);

        for (ServerPlayerEntity player : PlayerManagerHelper.PLAYER_MANAGER.getPlayerList()) {
            player.sendMessage(text);
        }
    }
}
