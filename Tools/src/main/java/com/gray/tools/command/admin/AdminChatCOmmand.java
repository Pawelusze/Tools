package com.gray.tools.command.admin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AdminChatCOmmand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player player = (Player) commandSender;

        if (!player.hasPermission("tools.adminchat")) {
            player.sendMessage("§4Blad!§c Nie posiadasz uprawnien do tej komendy!");
            return false;
        }

        if (args.length == 0) {
            player.sendMessage("§4Blad!§c Poprawne uzycie: /adminchat <wiadomosc>");
            return false;
        }

        StringBuilder message = new StringBuilder();
        for (String arg : args) {
            message.append(arg).append(" ");
        }

        if (player.hasPermission("tools.adminchat")) {
            player.sendMessage("§7[§cAdminChat§7] §7" + player.getName() + "§8: §f" + message);
        }
        return false;
    }
}
