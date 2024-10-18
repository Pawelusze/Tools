package com.gray.tools.command;

import com.gray.tools.util.ColorUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player player = (Player) commandSender;

        if (!player.hasPermission("tools.feed")) {
            player.sendMessage("§4Blad!§c Nie posiadasz uprawnien do tej komendy!");
            return false;
        }

        player.setFoodLevel(20);
        player.sendMessage(ColorUtil.color("&aPoprawnie uzupelniono twoja saturacje"));
        return false;
    }
}