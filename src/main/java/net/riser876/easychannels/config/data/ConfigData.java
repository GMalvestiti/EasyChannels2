package net.riser876.easychannels.config.data;

import com.google.gson.annotations.SerializedName;

public class ConfigData {

    @SerializedName("enable")
    public boolean enable = true;

    @SerializedName("permissions_required_message")
    public String permissionsRequiredMessage = "<red>You don't have the required permissions to use this chat channel.";

    @SerializedName("enable_fabric_permissions_api")
    public boolean enableFabricPermissionsApi = false;

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
