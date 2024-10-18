package com.gray.tools.command.admin;

import com.gray.tools.util.ColorUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvseeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;

        if (!player.hasPermission("tools.invsee")) {
            player.sendMessage(ColorUtil.color("&4Blad!&c Nie posiadasz uprawnien do tej komendy!"));
            return false;
        }

        if (args.length == 0) {
            player.sendMessage(ColorUtil.color("&4Blad!&c Poprawne uzycie: /invsee <gracz>"));
            return false;
        }

        Player target = player.getServer().getPlayer(args[0]);

        player.openInventory(target.getInventory());
        player.sendMessage(ColorUtil.color("&aOtworzono ekwipunek gracza " + target.getName()));

        target.sendMessage(ColorUtil.color("&aGracz " + player.getName() + " otworzyl twoj ekwipunek"));
        return false;
    }
}
