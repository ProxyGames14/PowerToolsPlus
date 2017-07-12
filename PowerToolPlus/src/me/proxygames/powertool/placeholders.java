package me.proxygames.powertool;

import me.proxygames.powertool.check.PlaceHolderAPI;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class placeholders {

	
	  public static String set(Player p, String text)
	  {
		  String gamemode = p.getGameMode().toString().toLowerCase();
		text = text
				.replace("%player%", p.getName())
				.replace("%ip%", p.getAddress().toString().replace("/", ""))
				.replace("%health%", Math.floor(p.getHealth()) + "")
				.replace("%food%", p.getFoodLevel() + "")
		        .replace("%world%", p.getWorld().getName())
		        .replace("%level%", p.getLevel() + "")	
		        .replace("%xp%", p.getExp() + "")	
		        .replace("%uuid%", p.getUniqueId().toString())
				.replace("%x%", p.getLocation().getBlockX() + "")
				.replace("%z%", p.getLocation().getBlockZ() + "")		
				.replace("%y%", p.getLocation().getBlockY() + "")
				.replace("%gamemode%", gamemode.substring(0, 1).toUpperCase() + gamemode.substring(1)) 
				.replace("%online%", Bukkit.getOnlinePlayers().size() + "")
		        .replace("%displayname%", p.getDisplayName());
		
		
		
	    return (PlaceHolderAPI.add(text, p));
	  }

}
