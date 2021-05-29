package com.github.thijmengthn.spigot;

import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.net.URL;
import java.util.Scanner;

public class version extends JavaPlugin {

    public static void check(TraderNotify plugin) {

        // Get version
        PluginDescriptionFile pdf = plugin.getDescription();
        String version = pdf.getVersion();

        // Display stats.
        String latest = "unknown";
        String state = ChatColor.RED + "Latest version undetectable!";

        try {

            // Get version from remote
            URL url = new URL("https://raw.githubusercontent.com/ThijmenGThN/TraderNotify/master/version.txt");
            Scanner s = new Scanner(url.openStream());

            // Read version
            latest = s.nextLine();

            // Check version
            if (version.equals(latest)) state = ChatColor.GREEN + "You're up to date!";

            if (!version.split("\\.")[2].equals(latest.split("\\.")[2]))
                state = ChatColor.WHITE + "A new patch update is available.";
            if (!version.split("\\.")[1].equals(latest.split("\\.")[1]))
                state = ChatColor.YELLOW + "A new minor update is available!";
            if (!version.split("\\.")[0].equals(latest.split("\\.")[0]))
                state = ChatColor.RED + "A new major update is available!";

        } catch (Exception e) {

            // Debugger
            if (plugin.getConfig().getString("debug").equals("true"))
                Utils.log("[Debug]: Fetch version error, " + e);

        }

        String versionNotify = ChatColor.LIGHT_PURPLE + "\n╔══ TraderNotify ══════════════" +
                "\n║ " +
                "\n║ " + state + ChatColor.LIGHT_PURPLE +
                "\n║ " +
                "\n║ Version: " + version +
                "\n║ Latest: " + latest +
                "\n║ ";

        if (!state.equals(ChatColor.GREEN + "You're up to date!")) {
            versionNotify = versionNotify + "\n║ It is recommended to always stay updated to the latest version " +
                    "\n║ of this plugin, updates mostly contain bug fixes and code " +
                    "\n║ improvements that might speed up your server." +
                    "\n║ " +
                    "\n║ The link below will take you to the most recent version," +
                    "\n║ " + ChatColor.AQUA + "https://www.spigotmc.org/resources/tradernotify.92776" + ChatColor.LIGHT_PURPLE +
                    "\n║ ";
        }

        versionNotify = versionNotify +
                "\n║ Wish to report a bug or request a feature? You can do so here," +
                "\n║ " + ChatColor.AQUA + "https://github.com/ThijmenGThN/TraderNotify/issues/new" + ChatColor.LIGHT_PURPLE +
                "\n║ " +
                "\n╚══";

        Utils.log(versionNotify);

    }

}
