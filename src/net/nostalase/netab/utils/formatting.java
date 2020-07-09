package net.nostalase.netab.utils;

import net.minecraft.server.v1_16_R1.MinecraftServer;
import net.nostalase.netab.Main;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;

public class formatting {
    public static String format(String input, Player player){
        long now_ut = System.currentTimeMillis() / 1000L;


        return input
                .replace("$tps", String.valueOf(MinecraftServer.getServer().recentTps[0]).substring(0, 4))
                .replace("$online_time", time_format(now_ut-Main.online_time.get(player.getUniqueId())))
                .replace("$player", player.getDisplayName())
                .replace("$max_players", String.valueOf(Bukkit.getMaxPlayers()))
                .replace("$online_players", String.valueOf(Bukkit.getOnlinePlayers().size()))
                ;
    }
    public static String time_format(long ut){
        if(ut<60){
            return String.valueOf(ut)+"seg";
        } else {
            String seconds = String.valueOf(((int) ut-((int) ut/60)*60));
            String minutes = String.valueOf(((int) ut/60));
            if(seconds.length()==1){
                seconds = "0"+seconds;
            }

            if(minutes.length()==1){
                minutes = "0"+minutes;
            }

            return minutes+":"+seconds;
        }
    }
}
