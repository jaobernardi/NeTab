package net.nostalase.netab.events;

import net.nostalase.netab.Main;
import net.nostalase.netab.utils.config;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Listen implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Main.online_time.put(event.getPlayer().getUniqueId(), System.currentTimeMillis() / 1000L);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        Main.online_time.remove(event.getPlayer().getUniqueId());
    }
}
