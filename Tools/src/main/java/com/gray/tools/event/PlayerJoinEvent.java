package com.gray.tools.event;

import com.gray.tools.util.ColorUtil;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.List;

import static org.bukkit.Bukkit.broadcastMessage;

public class PlayerJoinEvent implements Listener {

    @EventHandler
    public void onJoin(org.bukkit.event.player.PlayerJoinEvent event) {
        Player player = event.getPlayer();

        player.sendMessage(ColorUtil.color("&fIWitamy na serwerze&a " + player.getName()));
        player.sendMessage(ColorUtil.color("&fZyczymy pieknej gry na naszym serwerze!"));
        player.sendMessage(ColorUtil.color(" "));
        player.sendMessage(ColorUtil.color("&bINFORMACJE"));
        player.sendMessage(ColorUtil.color("&fDiscord: &bhttps://discord.gg/gray"));
        player.sendMessage(ColorUtil.color("&fForum: &ahttps://gray.com"));
        player.sendMessage(ColorUtil.color("&fSklep: &ehttps://sklep.gray.com"));

        event.setJoinMessage(null);
        event.setJoinMessage(ColorUtil.color("&fGracz o nicku&a&n " + player.getName()
                + "&fdolaczył na serwer!"));


        if (player.hasPlayedBefore()) {
            player.sendMessage(ColorUtil.color(" "));
        } else {
            broadcastMessage(ColorUtil.color("&fGracz&a " + player.getName() + " &fdolaczyl na serwer po raz pierwszy!"));
        }

    }
}
