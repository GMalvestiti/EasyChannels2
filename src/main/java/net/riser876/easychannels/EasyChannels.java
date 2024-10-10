package net.riser876.easychannels;

import net.fabricmc.api.ModInitializer;

import net.riser876.easychannels.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EasyChannels implements ModInitializer {

    public static final String MOD_ID = "easychannels";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Hello Fabric world!");
        Config.loadConfig();
    }
}
