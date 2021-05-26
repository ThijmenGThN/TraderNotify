package com.github.thijmengthn.spigot;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class TraderNotify extends JavaPlugin implements Listener {

    // Plugin standards

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);

        saveDefaultConfig();
        log(ChatColor.BLUE + getConfig().getString("message"));

        log(ChatColor.GREEN + "Plugin Enabled");
    }

    @Override
    public void onDisable() {
        log(ChatColor.RED + "Plugin Disabled");
    }

    // Quality of life functions

    public static void log(String msg) {
        Bukkit.getLogger().info(ChatColor.LIGHT_PURPLE + "[TraderNotify] " + ChatColor.WHITE + msg);
    }

    public static void broadcast(String msg) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(msg);
        }
    }

    public static void reply(CommandSender sender, String msg) {
        String notice = ChatColor.LIGHT_PURPLE + "[TraderNotify] ";
        sender.sendMessage(notice + ChatColor.WHITE + msg);
    }

    public static boolean permCheck(CommandSender sender, String perm) {
        if (sender.hasPermission(perm)) return false;

        reply(sender, ChatColor.RED + "You do not have permission to run this command.");
        return true;
    }

    public String message() {
        return ChatColor.translateAlternateColorCodes('&', getConfig().getString("message"));
    }

    // Global Listeners

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (permCheck(sender, "tradernotify")) return false;

        saveDefaultConfig();
        reloadConfig();

        reply(sender, "The config has been reloaded.");
        return true;
    }

    @EventHandler
    public void CreatureSpawnEvent(CreatureSpawnEvent event) {
        if (!event.getEntity().getName().equals("Wandering Trader"))
            return;

        log(message());
        broadcast(message());
    }

}
