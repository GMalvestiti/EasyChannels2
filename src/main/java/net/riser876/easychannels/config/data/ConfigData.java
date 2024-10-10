package net.riser876.easychannels.config.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ConfigData {
    @SerializedName("local")
    public LocalData local = new LocalData();

    @SerializedName("channels")
    public List<ChannelData> channels = createDefaultChannels();

    private static List<ChannelData> createDefaultChannels() {
        List<ChannelData> defaultChannels = new ArrayList<>();
        defaultChannels.add(new ChannelData());
        return defaultChannels;
    }
}
