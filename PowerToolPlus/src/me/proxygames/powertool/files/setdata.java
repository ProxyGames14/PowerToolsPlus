package me.proxygames.powertool.files;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class setdata {
	
	public static void data(Player player, int type, String[] querylist, CommandSender sender) {
	    File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("PowerToolsPlus").getDataFolder(), File.separator + "DataBase");
        File f = new File(userdata, File.separator + player.getUniqueId() + ".yml");
	    FileConfiguration playerData = YamlConfiguration.loadConfiguration(f); 

	    
		String item = checkitem.getitemid(player);
		
		if(item.equalsIgnoreCase("0--1")) {
			sender.sendMessage(color("&7[&6Power&atool&7] &e➣ &7Sorry this plugin doesnt support air!"));
			return;
		}
		
		switch (type) {
		case 1: playerData.set("Items.List."+ item +".right_click", querylist);
		break;
		case 2: playerData.set("Items.List."+item+".shift_right_click", querylist);
		break;
		case 3: playerData.set("Items.List."+item+".left_click", querylist);
		break;
		case 4: playerData.set("Items.List."+item+".shift_left_click", querylist);
		break;
		}
		
        try {
			playerData.save(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public static String color(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}

}
