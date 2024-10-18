package com.gray.tools.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HelpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) commandSender;

        player.sendMessage("§8§m----------------------------------------");
        player.sendMessage("§7§lGrayTools §8- §7Pomoc");
        player.sendMessage(" ");
        player.sendMessage("§7§l/help §8- §7Pokazuje pomoc");
        player.sendMessage("§7§l/feed §8- §7Uzupelnia saturacje gracza");
        player.sendMessage("§7§l/fly §8- §7Wlacza latanie");
        player.sendMessage("§7§l/gamemode §8- §7Zmienia tryb gry");
        player.sendMessage("§7§l/heal §8- §7Uzupelnia zdrowie gracza");
        return false;
    }
}
