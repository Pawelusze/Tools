package com.gray.tools.spawnsystem;

import com.gray.tools.util.ColorUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpawnCommand implements CommandExecutor{

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player player = (Player) commandSender;

        if (player.getWorld().getSpawnLocation() == null) {
            player.sendMessage(ColorUtil.color("&4Blad!&c Spawn nie zostal ustawiony!"));
            return false;
        }

        player.teleport(player.getWorld().getSpawnLocation());
        player.sendTitle(ColorUtil.color(" "), (ColorUtil.color("&aPrzeteleportowano na spawn")));
        return false;
    }
}
