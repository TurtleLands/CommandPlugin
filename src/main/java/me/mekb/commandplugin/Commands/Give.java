package me.mekb.commandplugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Give implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can execute this command");
            return true;
        }
        if (strings.length < 1 || strings.length > 3) return false;
        Player player = (Player) sender;
        String item = strings[0].toUpperCase();
        Material material = Material.getMaterial(item);
        if (material == null) return false;
        int amount = 1;
        if (strings.length >= 2) {
            String amountStr = strings[1];
            try {
                amount = Integer.parseInt(amountStr);
            } catch (NumberFormatException e) {
                return false;
            }
            if (amount < 0 || amount > 64) return false;
        }
        short damage = 0;
        if (strings.length == 3) {
            String damageStr = strings[2];
            try {
                damage = Short.parseShort(damageStr);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        player.getInventory().addItem(new ItemStack(material, amount, damage));
        return true;
    }
}
