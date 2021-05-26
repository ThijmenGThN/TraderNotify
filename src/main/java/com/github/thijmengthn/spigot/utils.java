package com.github.thijmengthn.spigot;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class utils {

    public static void reply(CommandSender sender, String msg) {
        String notice = ChatColor.LIGHT_PURPLE + "[TraderNotify] ";
        sender.sendMessage(notice + ChatColor.WHITE + msg);
    }

    public static void log(String msg) {
        Bukkit.getLogger().info(ChatColor.LIGHT_PURPLE + "[TraderNotify] " + ChatColor.WHITE + msg);
    }

    public static void playerBroadcast(String msg) {
        for (Player player : Bukkit.getOnlinePlayers()) player.sendMessage(msg);
    }

}
