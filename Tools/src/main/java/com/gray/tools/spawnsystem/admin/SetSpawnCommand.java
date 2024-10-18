package com.gray.tools.spawnsystem.admin;

import com.gray.tools.util.ColorUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetSpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player player = (Player) commandSender;

        if (!player.hasPermission("admin.tools.setspawn")) {
            player.sendMessage(ColorUtil.color("&4Blad!&c Nie posiadasz uprawnien do tej komendy!"));
            return false;
        }

        player.getWorld().setSpawnLocation(player.getLocation());
        player.sendMessage(ColorUtil.color("&2Sukces!&a Ustawiono pomyslnie ustawiono nowa lokalizacje spawnu!"));

        return false;
    }
}
