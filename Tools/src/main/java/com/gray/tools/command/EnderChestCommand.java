package com.gray.tools.command;

import com.gray.tools.util.ColorUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnderChestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;

        if (!player.hasPermission("tools.enderchest")) {
            player.sendMessage(ColorUtil.color("&4Blad!&c Nie posiadasz uprawnien do tej komendy!"));
            return false;
        }

        player.openInventory(player.getEnderChest());
        player.sendMessage(ColorUtil.color("&aOtworzono swojego enderchesta"));
        return false;
    }
}
