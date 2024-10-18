package com.gray.tools.command.customitems;

import com.gray.tools.util.ColorUtil;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class BloodSword implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player player = (Player) commandSender;

        if (!player.hasPermission("tools.customitems")) {
            player.sendMessage("&4Blad! &cNie posiadasz uprawnien do tej komendy!");

            if (player.getInventory().getItemInMainHand() != null &&
                    player.getInventory().getItemInMainHand().getType() != Material.AIR) {

                AttributeModifier modifier = new AttributeModifier("generic.attack_damage",
                        5, AttributeModifier.Operation.ADD_NUMBER);
                ItemStack itemStack = player.getInventory().getItemInMainHand();
                ItemMeta itemMeta = itemStack.getItemMeta();
                itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
                itemStack.setItemMeta(itemMeta);
                player.sendMessage(ColorUtil.color("&aYou have successfully created a BloodSword!"));
            }
            return false;
        }
        return false;
    }
}
