package net.riser876.easychannels.config.data;

import com.google.gson.annotations.SerializedName;

public class LocalChannelData {
    @SerializedName("enabled")
    public boolean enabled = true;

    @SerializedName("radius")
    public int radius = 50;

    @SerializedName("format")
    public String format = "<white><bold>[L]</bold></white> <gold>${player}</gold> <gray>>></gray> <white>${message}";

    @SerializedName("permission")
    public String permission = null;

    @SerializedName("op")
    public int op = 0;
}
