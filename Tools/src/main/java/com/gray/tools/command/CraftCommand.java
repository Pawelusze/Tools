package com.gray.tools.command;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.gray.tools.util.ColorUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class CraftCommand implements CommandExecutor {

    private Cache<UUID, Long> cooldown = CacheBuilder.newBuilder().expireAfterWrite
            (5, TimeUnit.SECONDS).build();

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player player = (Player) commandSender;

        if (!cooldown.asMap().containsKey(player.getUniqueId())) {

        } else {
            player.sendMessage(ColorUtil.color("&4Blad! &cPoczekaj chwile zanim uzyskasz dostep do tej komendy!"));
            return false;
        }
        if (!player.hasPermission("tools.craft")) {
            player.sendMessage(ColorUtil.color("&4Blad!&c Nie posiadasz uprawnien do tej komendy!"));
        }

        player.openWorkbench(player.getLocation(), true);
        return false;
    }
}
