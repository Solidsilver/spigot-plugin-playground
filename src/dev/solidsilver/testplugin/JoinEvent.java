package dev.solidsilver.testplugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
//        String packUrl = "https://serve.solidsilver.dev/CustomItemsTest_latest.zip";
//        event.getPlayer().setResourcePack(packUrl);
    }
}
