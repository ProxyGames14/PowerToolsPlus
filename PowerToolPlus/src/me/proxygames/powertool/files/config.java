package me.proxygames.powertool.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import me.proxygames.powertool.main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class config {

	    
	  static FileConfiguration config;
	  public static File congiffile;


	  
	    public static FileConfiguration getConfigFile()
	    {
	      return config;
	    }
	    
	    
		 public static void CreateConfig() {  
	    
	     congiffile = new File(main.plug.getDataFolder(), "config.yml");
	    
	    
	    if (!congiffile.exists()) {
		      congiffile.getParentFile().mkdirs();
		      main.plug.saveResource("config.yml", false);
		    }
	    
	    
	    config = new YamlConfiguration();
	    
	    
	    
	    try {
			config.load(congiffile);
		} catch (FileNotFoundException e) {
			main.plug.getServer().getConsoleSender().sendMessage(ChatColor.RED + "ERROR 126: Coud not load config.yml");
			e.printStackTrace();
		} catch (IOException e) {
			main.plug.getServer().getConsoleSender().sendMessage(ChatColor.RED + "ERROR 134: Coud not load config.yml");
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			main.plug.getServer().getConsoleSender().sendMessage(ChatColor.RED + "ERROR 197: Coud not load config.yml");
			e.printStackTrace();
		}
	    
	    
	    
		try {
			getConfigFile().save(congiffile);
		} catch (IOException e) {
			main.plug.getServer().getConsoleSender().sendMessage(ChatColor.RED + "ERROR 453: Coud not save config.yml");
			e.printStackTrace();
		}
		  }
}
