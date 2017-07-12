package me.proxygames.powertool;


import me.proxygames.powertool.check.UpdateChecker;
import me.proxygames.powertool.check.UpdateFiles;
import me.proxygames.powertool.command.Commands;
import me.proxygames.powertool.files.config;
import me.proxygames.powertool.files.filemenu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {
	public static main plug;
	public static boolean placeholderapi;
	public main() {
	    plug = this;
	}
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		PluginDescriptionFile pdfile = getDescription();
		ConsoleCommandSender clogger = this.getServer().getConsoleSender();
	    clogger.sendMessage(ChatColor.GOLD + "---------------------------------------");
	    clogger.sendMessage(ChatColor.AQUA + pdfile.getName() + " Has Been Enabled");
	    clogger.sendMessage(ChatColor.GREEN + "Plugin version: " + ChatColor.YELLOW + "v" +getDescription().getVersion());
	    clogger.sendMessage(ChatColor.GOLD + "---------------------------------------");
	
	    auctions();
	    if(Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
	    	placeholderapi = true;	    	
	    } else {
	    	placeholderapi = false;
	    }
	}
	
	
	public void auctions() {
		Handlers();
	    DataBase();
        config.CreateConfig();
        UpdateFiles.config();
        UpdateChecker.startUpdateCheck();
	}
	
	public void DataBase() {
		for(Player player : Bukkit.getServer().getOnlinePlayers())
		filemenu.CreateFile(player);
	}
	
	public void Handlers() {
		getServer().getPluginManager().registerEvents(new EventHandlers(), this);
		getCommand("powertool").setExecutor(new Commands());
	}
	
	
}
