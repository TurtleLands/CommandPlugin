package me.mekb.commandplugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can execute this command");
            return true;
        }
        Player player = (Player) sender;
        switch (s.toLowerCase()) {
            case "gms":
            case "gm0":
                player.setGameMode(GameMode.SURVIVAL);
                return true;
            case "gmc":
            case "gm1":
                player.setGameMode(GameMode.CREATIVE);
                return true;
            case "gma":
            case "gm2":
                player.setGameMode(GameMode.ADVENTURE);
                return true;
            case "gmsp":
            case "gm3":
                player.setGameMode(GameMode.SPECTATOR);
                return true;
        }
        if (strings.length != 1) return false;
        switch (strings[0].toLowerCase()) {
            case "s":
            case "survival":
            case "0":
                player.setGameMode(GameMode.SURVIVAL);
                return true;
            case "c":
            case "creative":
            case "1":
                player.setGameMode(GameMode.CREATIVE);
                return true;
            case "a":
            case "adventure":
            case "2":
                player.setGameMode(GameMode.ADVENTURE);
                return true;
            case "sp":
            case "spectator":
            case "3":
                player.setGameMode(GameMode.SPECTATOR);
                return true;
        }
        return false;
    }
}
