package nl.thijmenheuvelink.tradernotify;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
    
    @Override
    public void onEnable() {

        // Get server version
        int serverVersion = Integer.parseInt(
            getServer().getBukkitVersion()
                .split("-")[0]
                .split("\\.")[1]);

        // Check server version
        if (serverVersion < 14) 
            utils.consoleBanner(this, ChatColor.RED,
                "This version of Minecraft is not supported by this plugin!",
                "Reach out to support may you think that this is an error.");
        else 
            // Show display board
            utils.consoleBanner(this, ChatColor.LIGHT_PURPLE,
                "To request a feature or support, reach out using the urls below.",
                "Looking for contributors, you can fork Trader Notify on GitHub.");

        // Config loader
        utils.loadConfig(this);

        // Metrics and auto-updater (config initiated)
        utils.startupEssentials(this);

        // Schedule seeker
        scheduler.seekTrader(this);
    }

}
