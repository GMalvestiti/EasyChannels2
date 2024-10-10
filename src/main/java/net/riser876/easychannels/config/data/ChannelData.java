package net.riser876.easychannels.config.data;

import com.google.gson.annotations.SerializedName;

public class ChannelData {
    @SerializedName("enabled")
    public boolean enabled = true;

    @SerializedName("command")
    public String command = "g";

    @SerializedName("prefix")
    public String prefix = "§d§l[GLOBAL]§l§d ";

    @SerializedName("suffix ")
    public String suffix  = "§d§l >> §l§d";

    @SerializedName("permission")
    public String permission = "example.global";

    @SerializedName("op")
    public int op = 0;
}
