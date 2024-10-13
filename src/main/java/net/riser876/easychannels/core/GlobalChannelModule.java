package net.riser876.easychannels.core;

import net.minecraft.network.message.SignedMessage;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.riser876.easychannels.config.Config;
import net.riser876.easychannels.helpers.PlaceholderApiHelper;

import java.util.Objects;

public class GlobalChannelModule {
    private static final Text GLOBAL_CHANNEL_FORMAT_TEXT = PlaceholderApiHelper.getFormatText(Config.getGlobalChannelFormat());

    public static void register() {
        if (Objects.isNull(ModuleLoader.MINECRAFT_SERVER)) {
            return;
        }
    }

    private static void sendMessageToServer(SignedMessage message, ServerPlayerEntity sender) {
        Text text = PlaceholderApiHelper.formatPlayerMessage(GLOBAL_CHANNEL_FORMAT_TEXT, sender, message.getContent());

        for (ServerPlayerEntity player : Objects.requireNonNull(sender.getServer()).getPlayerManager().getPlayerList()) {
            player.sendMessage(text);
        }
    }
}
