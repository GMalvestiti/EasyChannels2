package net.riser876.easychannels.helpers;

import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.Objects;
import java.util.function.BiConsumer;

public class CommandHelper {
    private static final String ARG_NAME = "message";

    public static void register(String literal, Object permission, BiConsumer<Text, ServerPlayerEntity> sendMessage) {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal(literal)
                    .then(CommandManager.argument(ARG_NAME, StringArgumentType.greedyString())
                            .executes((context) -> {
                                ServerPlayerEntity sender = context.getSource().getPlayer();

                                if (!PermissionsApiHelper.hasPermissionWithNotification(permission, sender)) {
                                    return 0;
                                }

                                Text message = Text.of(StringArgumentType.getString(context, ARG_NAME));
                                sendMessage.accept(message, sender);
                                return 1;
                            })
                    )
            );
        });
    }
}