package dev.solidsilver.testplugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
       String packUrl = "https://download.mc-packs.net/pack/e30356494ccfb1ef567ca0e60b8f46935ab99d9b.zip";
       event.getPlayer().setResourcePack(packUrl);
    }
}
