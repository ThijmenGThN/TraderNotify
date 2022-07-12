package nl.thijmenheuvelink.tradernotify;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class utils {

    public static void startupEssentials(JavaPlugin plugin) {

        // Check if metrics are enabled in config
        if (plugin.getConfig().getString("enable-metrics").equalsIgnoreCase("true")) // Enable metrics
            new Metrics(plugin, 11485);
        else // Show option disabled warning
            log(ChatColor.RED+"Metrics have been disabled, enable to dismiss this warning.");

        // Check if updates are enabled in config
        if (plugin.getConfig().getString("enable-updates").equalsIgnoreCase("true")) // Update plugin
            update(plugin, "https://raw.githubusercontent.com/ThijmenGThN/TraderNotify/master/update.txt");
        else // Show option disabled warning
            log(ChatColor.RED+"Updates have been disabled, enable to dismiss this warning.");
    }

    public static void reply(CommandSender sender, String msg) {

        // Console blacklist
        if (sender.getName().equalsIgnoreCase("console")) return;

        // Emit message to command sender exclusively
        String notice = ChatColor.LIGHT_PURPLE + "[TraderNotify] ";
        sender.sendMessage(notice + ChatColor.WHITE + msg);
    }

    public static void log(String msg) {

        // Emit message to console exclusively
        Bukkit.getLogger().info(ChatColor.LIGHT_PURPLE + "[TraderNotify] " + ChatColor.WHITE + msg);
    }

    public static void playerBroadcast(JavaPlugin plugin, String msg) {

        // Emit message to each player on the server
        for (Player player : Bukkit.getOnlinePlayers()) {

            // Check if config has permissions enabled
            if (plugin.getConfig().getString("use-permissions").equalsIgnoreCase("true")) {

                // Check if user has getNotified permission
                if (player.hasPermission("tradernotify.getNotified"))
                    player.sendMessage(msg);

            } else player.sendMessage(msg);
        }
    }

    public static void loadConfig(JavaPlugin plugin) {

        // Configuration loader
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();
        plugin.reloadConfig();
    }

    public static boolean findTrader(JavaPlugin plugin) {

        // Get listener type from config
        String listener = plugin.getConfig().getString("listener");

        AtomicBoolean found = new AtomicBoolean(false);

        // Find in first world
        if (listener.equalsIgnoreCase("DEFAULT"))
            for (Entity i : Bukkit.getWorlds().get(0).getEntities())
                if (i.getName().equals("Wandering Trader"))
                    found.set(true);

        // Find in all worlds
        if (listener.equalsIgnoreCase("ALL"))
            Bukkit.getWorlds().forEach(world -> {
                for (Entity i : world.getEntities())
                    if (i.getName().equals("Wandering Trader"))
                        found.set(true);
            });

        return found.get();
    }

    public static void consoleBanner(JavaPlugin plugin, ChatColor color, String field1, String field2) {
        log(color + "\n╔══ TraderNotify " + plugin.getDescription().getVersion() + " ══════════════" +
                "\n║ " +
                "\n║ " + field1 +
                "\n║ " + field2 +
                "\n║ " +
                "\n║ Open an issue on GitHub, you can do that here." +
                "\n║ " + ChatColor.AQUA + "https://github.com/ThijmenGThN/TraderNotify/issues/new" + color +
                "\n║ " +
                "\n║ You can also open a ticket on Discord." +
                "\n║ " + ChatColor.AQUA + "https://discord.gg/7cqHVQyFmU" + color +
                "\n║ " +
                "\n╚══");
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

            // Delete old versions
            for (File file : new File("plugins/").listFiles())
                if (file.isFile())

                    // Skip installed version and latest
                    if (!file.getName().endsWith(version + ".jar"))

                        // Prune old versions
                        if (file.getName().startsWith("TraderNotify-"))
                            file.delete();

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
