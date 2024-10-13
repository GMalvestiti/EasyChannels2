package net.riser876.easychannels.helpers;

import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.function.BiConsumer;

public class CommandHelper {

    public static void register(String literal, Object permission, BiConsumer<Text, ServerPlayerEntity> sendMessage) {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal(literal)
                    .then(CommandManager.argument("message", StringArgumentType.greedyString())
                            .requires((source) -> PermissionsApiHelper.hasPermissionWithNotification(permission, source.getPlayer()))
                            .executes((context) -> {
                                Text message = Text.of(StringArgumentType.getString(context, "message"));
                                ServerPlayerEntity sender = context.getSource().getPlayer();
                                sendMessage.accept(message, sender);
                                return 1;
                            })
                    )
            );
        });
    }
}