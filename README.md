<br />
<p align="center">
  <a href="https://github.com/ThijmenGThN/TraderNotify">
    <img src="https://raw.githubusercontent.com/ThijmenGThN/TraderNotify/master/files/icons/icon-512x512.png" alt="TraderNotify" width="100" height="100">
  </a>

  <h3 align="center">TraderNotify</h3>

  <p align="center">
    Get notified when a Wandering Trader is in your world!
    <br />
    <a href="https://github.com/ThijmenGThN/TraderNotify/releases"><strong>Releases »</strong></a>
  </p>
</p>

## About The Project

TraderNotify is a neat plugin which is used to broadcast a customizable message into your world when a wandering trader has appeared.

<p align="center">
  <a href="https://github.com/ThijmenGThN/TraderNotify">
    <img src="https://raw.githubusercontent.com/ThijmenGThN/TraderNotify/master/files/gifs/notify.gif" alt="TraderNotify">
  </a>
</p>

## Getting Started

1. Download the latest version of the plugin [here](https://github.com/ThijmenGThN/TraderNotify/releases).
2. Move it over to your plugin's folder in the root of your server.
3. Restart your server or use the `/reload confirm` command.

## Configuration

<details>
<summary>Show Contents</summary>
<pre>
# ╔══ TraderNotify ══════════════
# ║
# ║ Are you having trouble with the plugin?
# ║
# ║ Open an issue on GitHub, you can do that here.
# ║ https://github.com/ThijmenGThN/TraderNotify/issues/new
# ║
# ║ You can also open a ticket on Discord.
# ║ https://discord.gg/7cqHVQyFmU
# ║
# ║
# ║
# ╠════ MESSAGE ══════════════
# ║
# ║ message: "&dA Wandering Trader has appeared!"
# ║
# ║ Description: This will be displayed when a wandering trader has appeared.
# ║ NOTE: Color codes can be used, no variables are available.
# ║
# ╠════ LISTENER ══════════════
# ║
# ║ listener: DEFAULT
# ║
# ║ Description: Which worlds should the plugin listen to?
# ║ Option 1: <DEFAULT> ( listener: DEFAULT ) Uses the first world that gets loaded, should be overworld.
# ║ Option 2: <ALL> ( listener: ALL ) Listen to all available worlds, this also includes dimensions.
# ║
# ╠════ USE PERMISSIONS ══════════════
# ║
# ║ use-permissions: false
# ║
# ║ Description: Require permissions, every permission node can be found at: https://www.spigotmc.org/resources/tradernotify.92776/
# ║ NOTE: Keeping this on false might be the best option, normal will only be able to recieve notifications and won't be able to change anything.
# ║ Option 1: <false> ( use-permissions: false ) Keep permissions off, this will use the default permission setting.
# ║ Option 2: <true> ( use-permissions: true ) Only players with specific permission nodes can do certain things.
# ║
# ╠════ ENABLE UPDATES ══════════════
# ║
# ║ enable-updates: true
# ║
# ║ Description: When this option has been enabled the server will periodically check for updates and if necessary update TraderNotify.
# ║ NOTE: It is RECOMMEND to keep this enabled, staying up to date will ensure the best experience possible.
# ║ Option 1: <false> ( enable-updates: false ) This will disable automatic updates, future bug fixes and improvments will have to be installed manually.
# ║ Option 2: <true> ( enable-updates: true ) TraderNotify will periodically check for updates, if there are any available it will update next time your server starts up.
# ║
# ╠════ ENABLE METRICS ══════════════
# ║
# ║ enable-metrics: true
# ║
# ║ Description: This will provide the plugin a limited amount of data which could help improve your experience. (thid-party remote service called bStats)
# ║ Option 1: <false> ( enable-metrics: false ) Metrics will not be tracked nor passed onto bStats.
# ║ Option 2: <true> ( enable-metrics: true ) You will help TraderNotify on gaining insight on limited server data, remotely on bStats.
# ║
# ╚══
message: "&dA Wandering Trader has appeared!"
listener: DEFAULT
use-permissions: false
enable-updates: true
enable-metrics: true
</pre>
</details>

## Commands & Permissions

<details>
<summary>Show Contents</summary>
<pre>
commands:
  reload-tradernotify:
    description: Reload the TraderNotify configuration file.
    usage: /reload-tradernotify
    permission: tradernotify.reload
</pre>
</details>

## Plugin Support

Are you having trouble with the plugin, would you like to report a bug or is it simply not working?
<br>
Open an issue on GitHub, you can do that [here](https://github.com/ThijmenGThN/TraderNotify/issues/new).

## Feature Requests

Great! You have a wonderful addition for this plugin, can't wait to hear about it.
<br>
The best way to make me notice your idea is by going [here](https://github.com/ThijmenGThN/TraderNotify/issues/new).

## Open Source - Contributing

Contributions are what make the open source community such an amazing place to be. Learn, inspire, and create. Any contributions you make are **greatly appreciated**.

<p align="center">
    <a href="https://github.com/ThijmenGThN/TraderNotify/issues">Issues</a> - 
    <a href="https://github.com/ThijmenGThN/TraderNotify/releases">Download</a> - 
    <a href="https://github.com/ThijmenGThN/TraderNotify">Source Code</a>
</p>
