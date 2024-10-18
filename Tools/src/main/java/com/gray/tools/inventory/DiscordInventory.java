package com.gray.tools.inventory;

import com.gray.tools.util.ColorUtil;
import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.components.GuiType;
import dev.triumphteam.gui.guis.Gui;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class DiscordInventory implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player player = (Player) commandSender;

        if(!(player instanceof Player)) {
            player.sendMessage(ColorUtil.color("&4Blad!&c Musisz byc graczem aby uzyc tej komendy!"));
            return false;
        }

        Gui gui = Gui.gui(GuiType.HOPPER)
                .title(Component.text("Discord"))
                .create();

        gui.disableAllInteractions();

        ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
        ItemBuilder itemBuilder = ItemBuilder.from(itemStack)
                .name(Component.text(ColorUtil.color("&b&lDISCORD")))
                .lore(
                        Component.text(ColorUtil.color(" ")),
                        Component.text(ColorUtil.color("&fLink do naszego discorda:")),
                        Component.text(ColorUtil.color("&ddc.graymc.pl&F -> Wbijaj nie &c&nczekaj!&f")),
                        Component.text(ColorUtil.color(" ")),
                        Component.text(ColorUtil.color("&aŻyczymy miłego grania na naszym serwerze&c :)"))
                );

        gui.setItem(2, itemBuilder.asGuiItem());

        ItemStack itemStack1 = new ItemStack(Material.PLAYER_HEAD);
        ItemBuilder itemBuilder1 = ItemBuilder.from(itemStack1)
                .name(Component.text(ColorUtil.color("&c&lYOUTUBE")))
                .lore(
                        Component.text(ColorUtil.color(" ")),
                        Component.text(ColorUtil.color("&fLink do naszego youtuba:")),
                        Component.text(ColorUtil.color("&dyt.graymc.pl&F -> Wbijaj nie &c&nczekaj!&f")),
                        Component.text(ColorUtil.color(" ")),
                        Component.text(ColorUtil.color("&aŻyczymy miłego grania na naszym serwerze&c :)"))
                );

        gui.open(player);
        return true;
    }
}
