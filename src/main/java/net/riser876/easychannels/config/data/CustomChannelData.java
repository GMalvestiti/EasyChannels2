package net.riser876.easychannels.config.data;

import com.google.gson.annotations.SerializedName;

public class CustomChannelData {
    @SerializedName("enabled")
    public boolean enabled = true;

    @SerializedName("command")
    public String command = "g";

    @SerializedName("format")
    public String format = "${message}";

    @SerializedName("permission")
    public String permission = null;

    @SerializedName("op")
    public int op = 0;
}
