package me.proxygames.powertool.files;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class reload {
  static int amount = 0;
  
  public static void reloading() {

  config.CreateConfig();
  
	    if(!new File(Bukkit.getServer().getPluginManager().getPlugin("PowerToolsPlus").getDataFolder(), "DataBase").exists()) {
		    File dir = new File(Bukkit.getServer().getPluginManager().getPlugin("PowerToolsPlus").getDataFolder(), "DataBase");
		    dir.mkdir(); 	
	    } 
	  
    File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("PowerToolsPlus").getDataFolder(), File.separator + "DataBase");
    File[] files = userdata.listFiles();

    for (File f:files)  
    {
         amount++;
    	
    	FileConfiguration playerData = YamlConfiguration.loadConfiguration(f); 
        try {
			playerData.save(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
    

  }
  public static int GetAmount() {
	  int last = amount;
	  amount = 0;
	  return last + 1;
  }


}