package me.proxygames.powertool.files;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class adddata {

	public static void add(Player player, int type, String[] a, CommandSender sender) {
		
	    File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("PowerToolsPlus").getDataFolder(), File.separator + "DataBase");
        File f = new File(userdata, File.separator + player.getUniqueId() + ".yml");
	    FileConfiguration playerData = YamlConfiguration.loadConfiguration(f); 

	    
		String item = checkitem.getitemid(player);
		
		
		
		if(item.equalsIgnoreCase("0--1")) {
			sender.sendMessage(color("&7[&6Power&atool&7] &e➣ &7Sorry this plugin doesnt support air!"));
			return;
		}
		List<String> querylist = playerData.getStringList("Items.List."+ item +"." + a[1]);
		
		StringBuilder query = new StringBuilder();
		for(int i = 2; i < a.length; i++) {
			if(i > 2) query.append(" ");
			query.append(a[i]);
		}
		
          querylist.add(query.toString());
		
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
		sender.sendMessage(color("&7[&6Power&atool&7] &e➣ &aYou succesfully added &e" + a[1].toLowerCase() + " &aData!"));
		
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
