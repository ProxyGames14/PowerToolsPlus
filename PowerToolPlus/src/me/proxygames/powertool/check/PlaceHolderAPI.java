package me.proxygames.powertool.check;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.clip.placeholderapi.PlaceholderAPI;
import me.proxygames.powertool.main;

public class PlaceHolderAPI {

	
 public static String add(String message, Player player) {
	    if(Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
	    	main.placeholderapi = true;	    	
	    } else {
	    	main.placeholderapi = false;
	    	return message;
	    }
	    
	 if(!main.placeholderapi) {
		 return message;
	 }
	 else {
		 return PlaceholderAPI.setPlaceholders(player, message);
		 
	 }
 }
}
