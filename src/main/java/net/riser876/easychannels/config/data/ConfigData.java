package net.riser876.easychannels.config.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ConfigData {
    @SerializedName("local")
    public LocalChannelData localChannel = new LocalChannelData();

    @SerializedName("channels")
    public List<CustomChannelData> customChannels = createDefaultCustomChannels();

    private static List<CustomChannelData> createDefaultCustomChannels() {
        List<CustomChannelData> defaultCustomChannels = new ArrayList<>();
        defaultCustomChannels.add(new CustomChannelData());
        return defaultCustomChannels;
    }
}
