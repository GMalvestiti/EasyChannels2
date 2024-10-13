package net.riser876.easychannels.config.data;

import com.google.gson.annotations.SerializedName;

public class ConfigData {
    @SerializedName("local")
    public LocalChannelData localChannel = new LocalChannelData();

    @SerializedName("channels")
    public GlobalChannelData globalChannel = new GlobalChannelData();

    /*private static List<GlobalChannelData> createDefaultCustomChannels() {
        List<GlobalChannelData> defaultCustomChannels = new ArrayList<>();
        defaultCustomChannels.add(new GlobalChannelData());
        return defaultCustomChannels;
    }*/
}
