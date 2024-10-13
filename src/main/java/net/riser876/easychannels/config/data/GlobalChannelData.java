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
    public String format = "<yellow><bold>[G]</bold></yellow> <gold>${player}</gold> <gray>>></gray> <yellow>${message}";

    @SerializedName("op")
    public int op = 0;
}
