package net.riser876.easychannels.config.data;

import com.google.gson.annotations.SerializedName;

public class ConfigData {
    @SerializedName("local_channel")
    public LocalChannelData localChannel = new LocalChannelData();

    @SerializedName("global_channel")
    public GlobalChannelData globalChannel = new GlobalChannelData();

    /*private static List<GlobalChannelData> createDefaultCustomChannels() {
        List<GlobalChannelData> defaultCustomChannels = new ArrayList<>();
        defaultCustomChannels.add(new GlobalChannelData());
        return defaultCustomChannels;
    }*/
}
