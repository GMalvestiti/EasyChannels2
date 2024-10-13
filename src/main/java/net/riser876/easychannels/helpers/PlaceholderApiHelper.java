package net.riser876.easychannels.helpers;

import eu.pb4.placeholders.api.Placeholders;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.Map;

import static eu.pb4.placeholders.api.TextParserUtils.formatText;

public class PlaceholderApiHelper {
    public static Text getFormatText(String formatText) {
        return formatText(formatText);
    }

    public static Text formatPlayerMessage(Text format, ServerPlayerEntity sender, Text message) {
        Map<String, Text> placeholders = Map.of(
                "message", message,
                "player", sender.getName()
        );

        return Placeholders.parseText(format, Placeholders.PREDEFINED_PLACEHOLDER_PATTERN, placeholders);
    }
}