package net.nostalase.netab.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class config {
    private static FileConfiguration config = Bukkit.getServer().getPluginManager().getPlugin("NeTab").getConfig();

    public static String getTitle() {
        return ChatColor.translateAlternateColorCodes('&',
                config.getString ("title"));
    }

    public static String getFooter() {
        return ChatColor.translateAlternateColorCodes('&',
                config.getString ("footer"));
    }
}
