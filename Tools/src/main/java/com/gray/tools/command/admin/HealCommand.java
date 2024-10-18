package com.gray.tools.command.admin;

import com.gray.tools.util.ColorUtil;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player player = (Player) commandSender;

        if (!player.hasPermission("tools.heal")) {
            player.sendMessage("§4Blad!§c Nie posiadasz uprawnien do tej komendy!");
            return false;
        }

        final double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();

        player.setHealth(maxHealth);
        player.sendMessage(ColorUtil.color("&aPoprawnie uzdrowiono twoje zdrowie"));
        return false;
    }
}
