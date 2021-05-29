package com.github.thijmengthn.spigot;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class Scheduler extends JavaPlugin {

    public static void seek(JavaPlugin plugin) {

        // Required to prevent duplicate messaging.
        final boolean[] emitAllowed = {true};

        // Schedule continues wandering trader finder.
        BukkitScheduler scheduler = plugin.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(plugin, () -> {

            // Loop through all entities to find wandering trader.
            boolean found = false;
            for (Entity i : Bukkit.getWorlds().get(0).getEntities()) {
                if (i.getName().equals("Wandering Trader") || i.getName().equals("Trader Llama"))
                    found = true;
            }

            // If a wandering trader has been found in the world.
            if (found) {

                // Check if this isn't a duplicate message.
                if (emitAllowed[0]) {

                    // Construct and convert message from config.
                    String message = ChatColor.translateAlternateColorCodes(
                            '&',
                            plugin.getConfig().getString("message")
                    );

                    // Broadcast to all players.
                    Utils.playerBroadcast(message);

                    // Display in server console.
                    Utils.log(message);

                }

                // Disallow to prevent duplicates.
                emitAllowed[0] = false;

            } else {

                // Allow to listen for new wandering traders.
                emitAllowed[0] = true;
                
            }

        }, 0L, 600L);
    }

}
