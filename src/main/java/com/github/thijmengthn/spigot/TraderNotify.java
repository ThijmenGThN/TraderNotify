package com.github.thijmengthn.spigot;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class TraderNotify extends JavaPlugin {

    @Override
    public void onEnable() {

        // Get server version
        String serverFullVersion = getServer().getBukkitVersion().split("-")[0];
        int serverMinorVersion = Integer.parseInt(serverFullVersion.split("\\.")[1]);

        // Check server version
        if (serverMinorVersion < 14) {
            Utils.log(ChatColor.RED +
                    "\n╔══ TraderNotify " + this.getDescription().getVersion() + " ══════════════" +
                    "\n║ " +
                    "\n║ This version of Minecraft is not supported by this plugin!" +
                    "\n║ Reach out to support may you think that this is an error." +
                    "\n║ " +
                    "\n║ Open an issue on GitHub, you can do that here." +
                    "\n║ " + ChatColor.AQUA + "https://github.com/ThijmenGThN/TraderNotify/issues/new" + ChatColor.RED +
                    "\n║ " +
                    "\n║ You can also open a ticket on Discord." +
                    "\n║ " + ChatColor.AQUA + "https://discord.gg/7cqHVQyFmU" + ChatColor.RED +
                    "\n║ " +
                    "\n╚══");

            // Disable plugin due to unsupported version
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        // Init Metrics ( third-party )
        new Metrics(this, 11485);

        // Config loader
        Utils.loadConfig(this);

        // Schedule seeker
        Scheduler.seekTrader(this);

        // Show display board
        Utils.log(ChatColor.LIGHT_PURPLE +
                "\n╔══ TraderNotify " + this.getDescription().getVersion() + " ══════════════" +
                "\n║ " +
                "\n║ Are you having trouble with the plugin?" +
                "\n║ " +
                "\n║ Open an issue on GitHub, you can do that here." +
                "\n║ " + ChatColor.AQUA + "https://github.com/ThijmenGThN/TraderNotify/issues/new" + ChatColor.LIGHT_PURPLE +
                "\n║ " +
                "\n║ You can also open a ticket on Discord." +
                "\n║ " + ChatColor.AQUA + "https://discord.gg/7cqHVQyFmU" + ChatColor.LIGHT_PURPLE +
                "\n║ " +
                "\n╚══");

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

                Utils.reply(sender, "The config has been reloaded.");
                Utils.log("The config has been reloaded.");
                return true;

        }

        return false;
    }

}

