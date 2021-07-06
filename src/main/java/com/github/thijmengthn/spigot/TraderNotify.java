package com.github.thijmengthn.spigot;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class TraderNotify extends JavaPlugin {

    @Override
    public void onEnable() {

        // Get server version
        int serverVersion = Integer.parseInt(
                getServer().getBukkitVersion()
                        .split("-")[0]
                        .split("\\.")[1]);

        // Check server version
        if (serverVersion < 14) {
            Utils.consoleBanner(this, ChatColor.RED,
                    "This version of Minecraft is not supported by this plugin!",
                    "Reach out to support may you think that this is an error.");

            return;
        }

        // Init Metrics ( third-party )
        new Metrics(this, 11485);

        // Config loader
        Utils.loadConfig(this);

        // Schedule seeker
        Scheduler.seekTrader(this);

        // Show display board
        Utils.consoleBanner(this, ChatColor.LIGHT_PURPLE,
                "To request a feature or support, reach out using the urls below.",
                "Looking for contributors, you can fork Trader Notify on GitHub.");

        // Update plugin
        Utils.update(this, "https://raw.githubusercontent.com/ThijmenGThN/TraderNotify/master/update.txt");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Parse all available commands.
        switch (label.toLowerCase()) {

            // Reload plugin configuration
            case "reload-tradernotify":

                // Check if player has sufficient permission.
                if (!sender.hasPermission("tradernotify.reload")) {
                    Utils.reply(sender, ChatColor.RED + "You do not have permission to run this command.");
                    return false;
                }

                // Config loader
                Utils.loadConfig(this);

                // Notify command initiator
                Utils.reply(sender, "The config has been reloaded.");
                Utils.log("The config has been reloaded.");
                return true;
        }

        return false;
    }

}

