package me.proxygames.powertool.command;


import me.proxygames.powertool.files.config;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Permissions {
	public static void Send(CommandSender sender, String perm) {
		sender.sendMessage(colors(config.getConfigFile().getString("NoPermissions").replace("%permission%", perm)));
		return;
	}
	public static String colors(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	
}
