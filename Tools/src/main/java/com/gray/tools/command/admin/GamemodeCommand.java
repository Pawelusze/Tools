package com.gray.tools.command.admin;

import com.gray.tools.util.ColorUtil;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GamemodeCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage(ColorUtil.color("&4Blad!&c Poprawne uzycie: /gm <tryb>"));
            return false;
        }

        if (!player.hasPermission("tools.gamemode")) {
            player.sendMessage(ColorUtil.color("&4Blad!&c Nie posiadasz uprawnien do tej komendy!"));
            return false;
        }

        switch (args[0]) {
            case "0":
                player.setGameMode(GameMode.SURVIVAL);
                player.sendTitle(ColorUtil.color("&6&lGAMEMODE"), (ColorUtil.color("&fZmienio tryb gry na&6 SURVIVAL")));
                break;
            case "1":
                player.setGameMode(GameMode.CREATIVE);
                player.sendTitle(ColorUtil.color("&6&lGAMEMODE"), (ColorUtil.color("&fZmienio tryb gry na&6 CREATIVE")));
                break;
            case "2":
                player.setGameMode(GameMode.ADVENTURE);
                player.sendTitle(ColorUtil.color("&6&lGAMEMODE"), (ColorUtil.color("&fZmienio tryb gry na&6 ADVENTURE")));
                break;
            case "3":
                player.setGameMode(GameMode.SPECTATOR);
                player.sendTitle(ColorUtil.color("&6&lGAMEMODE"), (ColorUtil.color("&fZmienio tryb gry na&6 SPECTATOR")));
                break;

            default:
                player.sendMessage(ColorUtil.color("&4Blad!&c Poprawne uzycie: /gm <tryb>"));
                break;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        if (args.length == 1) {
            return Arrays.asList("0", "1", "2", "3");
        }
        return new ArrayList<>();
    }
}
