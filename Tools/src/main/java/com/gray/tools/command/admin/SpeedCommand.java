package com.gray.tools.command.admin;

import com.gray.tools.util.ColorUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player player = (Player) commandSender;

        if (args.length == 0) {
            player.sendMessage("§4Blad!§c Podaj predkosc gracza!");
            return false;
        }

        if (!player.hasPermission("tools.speed")) {
            player.sendMessage("§4Blad!§c Nie posiadasz uprawnien do tej komendy!");
            return false;
        }

        try {
            float speed = Float.parseFloat(args[0]);
            player.setWalkSpeed(speed);
            player.sendMessage(ColorUtil.color("&aPoprawnie ustawiono predkosc gracza na&2 " + speed));
        } catch (NumberFormatException e) {
            player.sendMessage(ColorUtil.color("§4Blad!§c Podaj poprawna liczbe!"));
        }
        return false;
    }
}
