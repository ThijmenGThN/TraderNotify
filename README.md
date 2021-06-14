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
3. Start / restart your server ( you only have to do this once ).

Tip: To reload the config, use /reload-tradernotify.

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
# ╠════ Broadcast Message ══════════════
# ║
# ║ message: "&dA Wandering Trader has appeared!"
# ║
# ║ Description: This will be displayed when a wandering trader has appeared.
# ║ TIP: Color codes can be used, no variables are available.
# ║
# ╠════ World Listener ══════════════
# ║
# ║ listener: DEFAULT
# ║
# ║ Description: Which worlds should the plugin listener to?
# ║ Option 1: <DEFAULT> ( listener: DEFAULT ) Uses the first world that gets loaded, should be overworld.
# ║ Option 2: <ALL> ( listener: ALL ) Listen to all available worlds, this also includes dimensions.
# ║
# ╚══
message: "&dA Wandering Trader has appeared!"
listener: DEFAULT
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
