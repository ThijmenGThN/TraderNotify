package com.github.thijmengthn.spigot;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class TraderNotify extends JavaPlugin {


    @Override
    public void onEnable() {

        // If missing generate new config file from default.
        saveDefaultConfig();

        // Schedule seeker
        Scheduler.seek(this);

        // Metrics
        new Metrics(this, 11485);

        // Check version
        version.check(this);

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
                Utils.log("The config has been reloaded.");
                return true;
        }

        return false;
    }

}

