package me.proxygames.powertool;

import java.util.List;

import me.proxygames.powertool.files.checkitem;
import me.proxygames.powertool.files.filemenu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Executer {

	
	public static void executer(Player player, int type) {
		FileConfiguration file = filemenu.getplayerfile(player);
		String item = checkitem.getitemid(player);
		switch (type) {
		
		case 1: if(file.getStringList("Items.List." + item + ".right_click") != null)
			    executermenu(file.getStringList("Items.List." + item + ".right_click"), player);
		        break;
		case 2: if(file.getStringList("Items.List." + item + ".shift_right_click") != null)
			    executermenu(file.getStringList("Items.List." + item + ".shift_right_click"), player);
		        break;
		case 3: if(file.getStringList("Items.List." + item + ".left_click") != null)
			    executermenu(file.getStringList("Items.List." + item + ".left_click"), player);
                break;
		case 4: if(file.getStringList("Items.List." + item + ".shift_left_click") != null)
			    executermenu(file.getStringList("Items.List." + item + ".shift_left_click"), player);
        		break;
		}
	}
	public static void executermenu(List<String> list, Player player) {
		

		
		for(String message : list) {
			
			
			if(message.startsWith("op:")) {
			player.setOp(true);
			player.performCommand(placeholders.set(player, color(message.substring(4))));
			if(message.substring(3).startsWith("/op")) return;
			player.setOp(false);
			
			
			} else if(message.startsWith("cmd:")) {
			main.plug.getServer().dispatchCommand(player, placeholders.set(player, color(message.substring(5))));
			
			
			} else if (message.startsWith("console:")) { 
			main.plug.getServer().dispatchCommand(main.plug.getServer().getConsoleSender(), placeholders.set(player ,color(message.substring(8))));	
			
			
			} else if (message.startsWith("player:")) {
				String CommandPlayer = message.substring(7+1, message.indexOf(")"));
				@SuppressWarnings("deprecation")
				Player target = Bukkit.getPlayer(CommandPlayer);
				if(!target.isOnline()) return;
				target.performCommand(placeholders.set(target, color(message.substring(10 + CommandPlayer.length()))));
				
				
			} else if (message.startsWith("playerop:")) {
					String CommandPlayer = message.substring(9+1, message.indexOf(")"));
					@SuppressWarnings("deprecation")
					Player target = Bukkit.getPlayer(CommandPlayer);
					if(!target.isOnline()) return;
					target.setOp(true);
					target.performCommand(placeholders.set(target, color(message.substring(12 + CommandPlayer.length()))));
					if(message.substring(11 + CommandPlayer.length()).startsWith("/op")) return;
					target.setOp(false);
					
			} else if (message.startsWith("bc:")) {
			Bukkit.broadcastMessage(placeholders.set(player, color(message.substring(3))));	
			
			
			} else if (message.startsWith("world:")) {
				String targetworld = message.substring(6+1, message.indexOf(")"));				
				World world = Bukkit.getWorld(targetworld);
				if(world == null){
					player.sendMessage("World '" + targetworld + "' does not exists");
				}
				player.teleport(world.getSpawnLocation());
				
			} else if (message.startsWith("text:")) {
				player.sendMessage(placeholders.set(player, color(message.substring(5))));	
				
			}else {
			player.sendMessage(placeholders.set(player, color(message)));
			}

		}
		
	}
	
	
	public static String color(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
}
