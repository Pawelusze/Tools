package com.gray.tools.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HelpopCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player player = (Player) commandSender;

        if (args.length == 0) {
            player.sendMessage("§cPoprawne uzycie: /helpop <wiadomosc>");
            return false;
        }

        StringBuilder message = new StringBuilder();
        for (String arg : args) {
            message.append(arg).append(" ");
        }

        player.sendMessage("§aTwoja wiadomosc zostala wyslana do administracji!");

        if (player.hasPermission("tools.helpop")) {
            player.sendMessage("§7[§aHelpop§7] §7" + player.getName() + "§8: §f" + message);
        }
        return false;
    }
}
