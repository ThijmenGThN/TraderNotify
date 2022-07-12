package nl.thijmenheuvelink.tradernotify;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class scheduler extends JavaPlugin {

    public static void seekTrader(JavaPlugin plugin) {

        // Required to prevent duplicate messaging.
        final boolean[] emitAllowed = {true};

        // Schedule continues wandering trader finder.
        BukkitScheduler scheduler = plugin.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(plugin, () -> {

            // Loop through all entities to find wandering trader.
            boolean found = utils.findTrader(plugin);

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
                    utils.playerBroadcast(plugin, message);

                    // Display in server console.
                    utils.log(message);
                }

                // Disallow to prevent duplicates.
                emitAllowed[0] = false;

                // Allow to listen for new wandering traders.
            } else emitAllowed[0] = true;

        }, 0L, 600L);
    }

}