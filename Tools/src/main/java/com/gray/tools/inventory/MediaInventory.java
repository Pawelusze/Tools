package com.gray.tools.inventory;

import com.gray.tools.util.ColorUtil;
import dev.triumphteam.gui.components.GuiType;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.builder.item.ItemBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MediaInventory implements CommandExecutor {

    public MediaInventory() {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Komenda dostępna tylko dla graczy.");
            return true;
        }

        Player player = (Player) sender;

        Gui gui = Gui.gui(GuiType.HOPPER)
                .title(Component.text("Media"))
                .create();

        gui.disableAllInteractions();
        
        ItemStack itemStack = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemBuilder itemBuilder = ItemBuilder.from(itemStack)
                .name(Component.text(ColorUtil.color("&b&lMINI YT")))
                .lore(
                        Component.text(ColorUtil.color("&7Wymagania na rangę MiniMedia:")),
                        Component.text(ColorUtil.color(" ")),
                        Component.text(ColorUtil.color("&f1&8 - &7Minimum 300 &asubskrypcji")),
                        Component.text(ColorUtil.color("&f2&8 - &7Minimalnie 10 like pod każdym filmem")),
                        Component.text(ColorUtil.color("&f3&8 - &7Minimalnie 35 wyświetleń pod każdym filmem w ciągu &f24h&8")),
                        Component.text(ColorUtil.color("&f4&8 - &7Minimalnie 10 komentarzy pod każdym filmem")),
                        Component.text(ColorUtil.color(" ")),
                        Component.text(ColorUtil.color("&7Aby zgłosić się na rangę MiniMedia, napisz do nas na kanale &f#zgłoszenia"))
                );

        gui.setItem(1, itemBuilder.asGuiItem());

        ItemStack itemStack1 = new ItemStack(Material.DIAMOND_HELMET);
        ItemBuilder itemBuilder1 = ItemBuilder.from(itemStack1)
                .name(Component.text(ColorUtil.color("&b&lMEDIA")))
                .lore(
                        Component.text(ColorUtil.color("&7Wymagania na rangę Media:")),
                        Component.text(ColorUtil.color(" ")),
                        Component.text(ColorUtil.color("&f1&8 - &7Minimum 500 &asubskrypcji")),
                        Component.text(ColorUtil.color("&f2&8 - &7Minimalnie 15 like pod każdym filmem")),
                        Component.text(ColorUtil.color("&f3&8 - &7Minimalnie 50 wyświetleń pod każdym filmem w ciągu &f24h&8")),
                        Component.text(ColorUtil.color(" ")),
                        Component.text(ColorUtil.color("&7Aby zgłosić się na rangę Media, napisz do nas na kanale &f#zgłoszenia"))
                );

        gui.setItem(3, itemBuilder1.asGuiItem());

        gui.open(player);
        return true;
    }
}

