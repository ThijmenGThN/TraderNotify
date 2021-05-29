package com.github.thijmengthn.spigot;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Utils {

    public static void reply(CommandSender sender, String msg) {

        // Emit message to command sender exclusively
        String notice = ChatColor.LIGHT_PURPLE + "[TraderNotify] ";
        sender.sendMessage(notice + ChatColor.WHITE + msg);

    }

    public static void log(String msg) {

        // Emit message to console exclusively
        Bukkit.getLogger().info(ChatColor.LIGHT_PURPLE + "[TraderNotify] " + ChatColor.WHITE + msg);

    }

    public static void playerBroadcast(String msg) {

        // Emit message to each player on the server
        for (Player player : Bukkit.getOnlinePlayers()) player.sendMessage(msg);

    }

    public static void update(JavaPlugin plugin, String updateUrl) {
        try {

            // Get update data from remote
            URL url = new URL(updateUrl);
            Scanner s = new Scanner(url.openStream());

            // Set update data
            String version = plugin.getDescription().getVersion();
            String latest = s.nextLine();
            URL download = new URL(s.nextLine());
            String deprecated = s.nextLine();

            // Delete old versions
            for (String dep : deprecated.split(" ")) {
                new File("plugins/TraderNotify-" + dep + ".jar").delete();
            }

            // Check for update
            if (version.equals(latest)) return;

            // Download update
            InputStream in = download.openStream();
            Files.copy(in, Paths.get("plugins/TraderNotify-" + latest + ".jar"), StandardCopyOption.REPLACE_EXISTING);

        } catch (Exception error) {

            // Throw error
            Utils.log("An error has occurred: " + error);

        }
    }

}

