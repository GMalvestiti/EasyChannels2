package net.riser876.easychannels.config.data;

import com.google.gson.annotations.SerializedName;

public class GlobalChannelData {
    @SerializedName("enabled")
    public boolean enabled = true;

    @SerializedName("dimension_only")
    public boolean dimensionOnly = false;

    @SerializedName("command")
    public String literal = "g";

    @SerializedName("format")
    public String format = "<yellow><bold>[G]</bold></yellow> <gold>${player}</gold> <dark_gray>>></dark_gray> ${message}";

    @SerializedName("permission")
    public String permission = null;

    @SerializedName("op")
    public Integer op = null;
}
