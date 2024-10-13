package net.riser876.easychannels;

import net.fabricmc.api.ModInitializer;
import net.riser876.easychannels.config.Config;
import net.riser876.easychannels.core.GlobalChannelModule;
import net.riser876.easychannels.core.LocalChannelModule;
import net.riser876.easychannels.helpers.PermissionsApiHelper;
import net.riser876.easychannels.helpers.PlayerManagerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EasyChannels implements ModInitializer {

    public static final String MOD_ID = "easychannels";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        Config.load();
        EasyChannels.LOGGER.info("[EasyChannels] Configuration loaded");
        loadModules();
    }

    public void loadModules() {
        if (!Config.isModEnabled()) {
            EasyChannels.LOGGER.info("[EasyChannels] Mod is disabled. Skipping module loading.");
            return;
        }

        PermissionsApiHelper.init();

        if (Config.isLocalChannelEnabled()) {
            LocalChannelModule.register();
        }

        if (Config.isGlobalChannelEnabled()) {
            PlayerManagerHelper.init();
        }

        if (Config.isGlobalChannelEnabled()) {
            GlobalChannelModule.register();
        }
    }
}
