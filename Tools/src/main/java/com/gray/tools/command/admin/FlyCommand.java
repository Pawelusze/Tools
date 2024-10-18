package com.gray.tools.command.admin;

import com.gray.tools.util.ColorUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;

        if (!player.hasPermission("tools.fly")) {
            player.sendMessage(ColorUtil.color("&4Blad!&c Nie posiadasz uprawnien do tej komendy!"));
            return false;
        }

        player.setAllowFlight(!player.getAllowFlight());
        player.sendMessage(ColorUtil.color("&aTryb latania zostal " + (player.getAllowFlight() ? "&2wlaczony" : "&2wylaczony")));

        return true;
    }
}
