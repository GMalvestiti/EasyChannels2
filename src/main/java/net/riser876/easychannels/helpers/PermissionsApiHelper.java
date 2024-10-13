package net.riser876.easychannels.helpers;

import me.lucko.fabric.api.permissions.v0.Permissions;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.riser876.easychannels.EasyChannels;
import net.riser876.easychannels.config.Config;

import java.util.function.BiFunction;

public class PermissionsApiHelper {
    private static final Text PERMISSION_REQUIRED_MESSAGE_TEXT = PlaceholderApiHelper.getFormatText(Config.getPermissionsRequiredMessage());;

    private static BiFunction<Object, ServerPlayerEntity, Boolean> permissionChecker;

    public static void init() {
        if (Config.isFabricPermissionsApiEnabled()) {
            permissionChecker = (permission, player) -> hasPermissionFabricApi((String) permission, player);
        } else {
            permissionChecker = (permission, player) -> hasPermissionVanilla((Integer) permission, player);
        }

        EasyChannels.LOGGER.info("[EasyChannels] Permissions API initialized");
    }

    public static boolean hasPermission(Object permission, ServerPlayerEntity player) {
        return permissionChecker.apply(permission, player);
    }

    public static boolean hasPermissionWithNotification(Object permission, ServerPlayerEntity player) {
        boolean hasPermission = permissionChecker.apply(permission, player);

        if (!hasPermission) {
            sendPermissionRequiredMessage(player);
        }

        return hasPermission;
    }

    private static boolean hasPermissionVanilla(int operatorLevel, ServerPlayerEntity player) {
        return player.hasPermissionLevel(operatorLevel);
    }

    private static boolean hasPermissionFabricApi(String permission, ServerPlayerEntity player) {
        return Permissions.check(player, permission);
    }

    public static void sendPermissionRequiredMessage(ServerPlayerEntity player) {
        player.sendMessage(PERMISSION_REQUIRED_MESSAGE_TEXT, false);
    }

    public static Object getPermission(String permission, int operatorLevel) {
        if (Config.isFabricPermissionsApiEnabled()) {
            return permission;
        } else {
            return operatorLevel;
        }
    }
}
