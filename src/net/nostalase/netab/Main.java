package net.nostalase.netab;

import net.minecraft.server.v1_16_R1.MinecraftServer;
import net.nostalase.netab.events.Listen;
import net.nostalase.netab.tasks.TabUpdate;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Main extends JavaPlugin {
    public static Map<UUID, Long> online_time = new HashMap<>();
    public static TabUpdate tabUpdate;

    @Override
    public void onEnable() {
        setupConfig();
        setupTasks();

        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents(new Listen(), this);
    }

    public void setupConfig(){
        if (!(new File(getDataFolder (), "config.yml").exists())) {
            this.saveDefaultConfig ();
        }
    }

    public void setupTasks(){
        online_time.clear();
        for(Player p: Bukkit.getOnlinePlayers()){
            online_time.put(p.getUniqueId(), System.currentTimeMillis() / 1000L);
        }
        tabUpdate = new TabUpdate();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, tabUpdate, 0L, 10L);
    }
}
