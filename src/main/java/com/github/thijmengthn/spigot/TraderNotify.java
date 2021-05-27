package com.github.thijmengthn.spigot;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public final class TraderNotify extends JavaPlugin {

    // Required to prevent duplicate messaging.
    Boolean emitAllowed = true;

    @Override
    public void onEnable() {

        // If missing generate new config file from default.
        saveDefaultConfig();

        // Schedule continues wandering trader finder.
        BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, () -> {

            // Loop through all entities to find wandering trader.
            boolean found = false;
            for (Entity i : Bukkit.getWorlds().get(0).getEntities()) {
                if (i.getName().equals("Wandering Trader") || i.getName().equals("Trader Llama"))
                    found = true;
            }

            // If a wandering trader has been found in the world.
            if (found) {

                // Check if this isn't a duplicate message.
                if (emitAllowed) {

                    // Construct and convert message from config.
                    String message = ChatColor.translateAlternateColorCodes(
                            '&',
                            getConfig().getString("message")
                    );

                    // Broadcast to all players.
                    Utils.playerBroadcast(message);

                    // Display in server console.
                    Utils.log(message);

                }

                // Disallow to prevent duplicates.
                emitAllowed = false;

                // Allow to listen for new wandering traders.
            } else emitAllowed = true;

        }, 0L, 600L);

        // Metrics
        new Metrics(this, 11485);

        // Mark as enabled
        Utils.log(ChatColor.GREEN + "Plugin Enabled");

    }

    @Override
    public void onDisable() {

        // Mark as disabled
        Utils.log(ChatColor.RED + "Plugin Disabled");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Parse all available commands.
        switch (label.toLowerCase()) {
            case "reload-tradernotify":

                // Check if player has sufficient permission.
                if (!sender.hasPermission("tradernotify.reload")) {
                    Utils.reply(sender, ChatColor.RED + "You do not have permission to run this command.");
                    return false;
                }

                // If missing generate new config file from default.
                saveDefaultConfig();

                // Reload config file
                reloadConfig();

                Utils.reply(sender, "The config has been reloaded.");
                return true;
        }

        return false;
    }

}

