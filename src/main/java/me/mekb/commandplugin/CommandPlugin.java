package me.mekb.commandplugin;

import me.mekb.commandplugin.Commands.Gamemode;
import me.mekb.commandplugin.Commands.Give;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class CommandPlugin extends JavaPlugin {
    public Server server;
    private World world;

    public PluginManager pluginManager;

    @Override
    public void onEnable() {
        server = getServer();
        pluginManager = server.getPluginManager();
        getCommand("gamemode").setExecutor(new Gamemode());
        getCommand("give").setExecutor(new Give());
    }


    @Override
    public void onDisable() {
    }
}
