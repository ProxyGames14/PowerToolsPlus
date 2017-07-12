package me.proxygames.powertool.files;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class filemenu {

		public static void CreateFile(Player player) {
		    String playeruuid = player.getUniqueId().toString();	 
		    
		    if(!new File("plugins/PowerToolsPlus").exists()) {
			    File dir = new File("PowerToolsPlus");
			    dir.mkdir(); 	
		    }
		    
		    if(!new File(Bukkit.getServer().getPluginManager().getPlugin("PowerToolsPlus").getDataFolder(), "DataBase").exists()) {
			    File dir = new File(Bukkit.getServer().getPluginManager().getPlugin("PowerToolsPlus").getDataFolder(), "DataBase");
			    dir.mkdir(); 	
		    }
		    

		    
		    File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("PowerToolsPlus").getDataFolder(), File.separator + "DataBase");
	        File f = new File(userdata, File.separator + playeruuid + ".yml");
		    FileConfiguration playerData = YamlConfiguration.loadConfiguration(f); 
		    

		    if(!f.exists()){
		        try {
					f.createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 
		                        
		                        playerData.set("Name",player.getName());
		                        playerData.set("Items.List","");
		                        
		                        try {
									playerData.save(f);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} 
		    }		 
		    
		    playerData.set("Name",player.getName());
		    }
		
		public static void Reset(Player player, int type) {
		    String playeruuid = player.getUniqueId().toString();	 
		    
		    if(!new File("plugins/PowerToolsPlus").exists()) {
			    File dir = new File("PowerToolsPlus");
			    dir.mkdir(); 	
		    }
		    
		    if(!new File(Bukkit.getServer().getPluginManager().getPlugin("PowerToolsPlus").getDataFolder(), "DataBase").exists()) {
			    File dir = new File(Bukkit.getServer().getPluginManager().getPlugin("PowerToolsPlus").getDataFolder(), "DataBase");
			    dir.mkdir(); 	
		    }
		    

		    
		    File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("PowerToolsPlus").getDataFolder(), File.separator + "DataBase");
	        File f = new File(userdata, File.separator + playeruuid + ".yml");
		    FileConfiguration playerData = YamlConfiguration.loadConfiguration(f); 
		    

		    if(f.exists()){
		  //if(playerData.getString("Items.List." + checkitem.getitemid(player)) == null) return;

				switch (type) {
				
				case 1: player.sendMessage(color("&7[&6Power&atool&7] &e➣ &aSuccesfully cleared the &eright_click &adata!"));
					    if(playerData.getString("Items.List." + checkitem.getitemid(player)+".right_click") == null) return;
					    playerData.set("Items.List." + checkitem.getitemid(player)+".right_click",null);
				        break;
				case 2: player.sendMessage(color("&7[&6Power&atool&7] &e➣ &aSuccesfully cleared the &eshift_right_click &adata!"));
					    if(playerData.getString("Items.List." + checkitem.getitemid(player)+".right_click") == null) return;
					    playerData.set("Items.List." + checkitem.getitemid(player)+".shift_right_click",null);
				        
						break;
				case 3: player.sendMessage(color("&7[&6Power&atool&7] &e➣ &aSuccesfully cleared the &eleft_click &adata!"));
					    if(playerData.getString("Items.List." + checkitem.getitemid(player)+".right_click") == null) return;
						playerData.set("Items.List." + checkitem.getitemid(player)+".left_click",null);				     
		        		break;
				case 4: player.sendMessage(color("&7[&6Power&atool&7] &e➣ &aSuccesfully cleared the &3shift_left_click &adata!"));
					    if(playerData.getString("Items.List." + checkitem.getitemid(player)+".right_click") == null) return; 
					    playerData.set("Items.List." + checkitem.getitemid(player)+".shift_left_click",null);		        
						break;
				case 5: playerData.set("Items.List","");
				        break;
				}        
		                        
		                        
		                        try {
									playerData.save(f);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} 
		    }		 		    	
		    }
		
		public static FileConfiguration getplayerfile(Player player) {
			CreateFile(player);
		    File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("PowerToolsPlus").getDataFolder(), File.separator + "DataBase");
	        File f = new File(userdata, File.separator + player.getUniqueId() + ".yml");
		    FileConfiguration playerData = YamlConfiguration.loadConfiguration(f); 
			return playerData;
		}
		
		public static void saveFiles(Player player) {
			
		    File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("PowerToolsPlus").getDataFolder(), File.separator + "DataBase");
	        File f = new File(userdata, File.separator + player.getUniqueId() + ".yml");
		    FileConfiguration playerData = YamlConfiguration.loadConfiguration(f); 
			
	        try {
				playerData.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		public static String color(String s) {
			return ChatColor.translateAlternateColorCodes('&', s);
		}
		}
		
		
		
