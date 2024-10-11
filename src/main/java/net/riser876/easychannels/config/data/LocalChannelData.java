package net.riser876.easychannels.config.data;

import com.google.gson.annotations.SerializedName;

public class LocalChannelData {
    @SerializedName("enabled")
    public boolean enabled = true;

    @SerializedName("radius")
    public int radius = 50;
}
