package net.riser876.easychannels.config.data;

import com.google.gson.annotations.SerializedName;

public class LocalChannelData {
    @SerializedName("enabled")
    public boolean enabled = true;

    @SerializedName("radius")
    public int radius = 50;

    @SerializedName("format")
    public String format = "<gold>${player}</gold> <dark_gray>>></dark_gray> ${message}";

    @SerializedName("permission")
    public String permission = null;

    @SerializedName("op")
    public Integer op = null;
}
