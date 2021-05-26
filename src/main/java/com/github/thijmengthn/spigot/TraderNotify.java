package com.github.thijmengthn.spigot;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class TraderNotify extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info(ChatColor.LIGHT_PURPLE + "Trader Notify is now enabled.");
    }

    @Override
    public void onDisable() {

    }
}
