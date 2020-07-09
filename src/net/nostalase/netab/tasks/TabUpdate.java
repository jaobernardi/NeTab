package net.nostalase.netab.tasks;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.cacheddata.CachedDataManager;
import net.luckperms.api.cacheddata.CachedMetaData;
import net.luckperms.api.context.ContextManager;
import net.luckperms.api.model.user.User;
import net.luckperms.api.model.user.UserManager;
import net.nostalase.netab.utils.config;
import net.nostalase.netab.utils.formatting;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class TabUpdate implements Runnable{
    @Override
    public void run() {
        LuckPerms api = LuckPermsProvider.get();
        UserManager manager = api.getUserManager();
        ContextManager cm = api.getContextManager();
        for(Player p:Bukkit.getOnlinePlayers()){
            User user = manager.getUser(p.getUniqueId());
            CachedDataManager usercachedata = user.getCachedData();
            CachedMetaData cachedata = usercachedata.getMetaData();
            p.setPlayerListHeaderFooter(
                    formatting.format(config.getTitle(), p),
                    formatting.format(config.getFooter(), p));
            p.setPlayerListName(ChatColor.translateAlternateColorCodes('&',
                    cachedata.getPrefix()+" "+p.getDisplayName()+" "+cachedata.getSuffix()));

        }
    }
}
