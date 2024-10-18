package com.gray.tools;

import com.gray.tools.command.*;
import com.gray.tools.command.admin.*;
import com.gray.tools.event.PlayerJoinEvent;
import com.gray.tools.inventory.DiscordInventory;
import com.gray.tools.inventory.MediaInventory;
import com.gray.tools.inventory.TrashInventory;
import com.gray.tools.spawnsystem.SpawnCommand;
import com.gray.tools.spawnsystem.admin.DelSpawnCommand;
import com.gray.tools.spawnsystem.admin.SetSpawnCommand;
import com.gray.tools.util.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class ToolsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {

        //               <--- Plugin Console Loader --->
        getLogger().log(Level.INFO, "Loading plugin...");
        getLogger().log(Level.INFO, "Plugin succesfully loaded!");
        getLogger().log(Level.INFO, " ");
        getLogger().log(Level.INFO, "Plugin author: " + getDescription().getAuthors().get(0));
        getLogger().log(Level.INFO, "Plugin version: " + getDescription().getVersion());
        getLogger().log(Level.INFO, " ");


        String author = getDescription().getAuthors().get(0);
        if (!author.equals("Pawelusz")) {
            getLogger().log(Level.SEVERE, "Plugin author is not Gray! Disabling plugin...");
            getServer().getPluginManager().disablePlugin(this);
            return;

        }


        //              <--- Registering commands --->
        getCommand("gamemode").setExecutor(new GamemodeCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("invsee").setExecutor(new InvseeCommand());
        getCommand("enderchest").setExecutor(new EnderChestCommand());
        getCommand("crafting").setExecutor(new CraftCommand());
        getCommand("helpop").setExecutor(new HelpopCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("gamma").setExecutor(new GammaCommand());
        getCommand("adminchat").setExecutor(new AdminChatCOmmand());
        getCommand("speed").setExecutor(new SpeedCommand());

        //              <--- Registering Spawn System --->
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("setspawn").setExecutor(new SetSpawnCommand());
        getCommand("delspawn").setExecutor(new DelSpawnCommand());

        //              <--- Registering Command Inventory --->
        getCommand("media").setExecutor(new MediaInventory());
        getCommand("trash").setExecutor(new TrashInventory());
        getCommand("discord").setExecutor(new DiscordInventory());

        //             <--- Registering Events --->

        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(), this);


        //             <--- Register Runnable --->

        Bukkit.getScheduler().runTaskLater(this, () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(ColorUtil.color("Server zostanie zrestartowany za 10 sekund"));
            }
        }, 200);

        Bukkit.getScheduler().runTaskTimer(this, () -> {

        }, 300, 20);
    }

    //                  <--- Plugin Disabler --->
    @Override
    public void onDisable() {
        getLogger().log(Level.INFO, "Disabled plugin :(");
    }
}
