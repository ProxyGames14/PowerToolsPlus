package me.proxygames.powertool.check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


import me.proxygames.powertool.main;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class UpdateChecker {
	
	static String currentVersion = main.plug.getDescription().getVersion();
	 
	private static String readurl = "https://raw.githubusercontent.com/proxygames14/PowerToolsPlus/master/version";
	private static double version;
	private static double newversion;

	public static void startUpdateCheck() {

	try {
	URL urls = new URL(readurl);
	BufferedReader brs = new BufferedReader(new InputStreamReader(urls.openStream()));
	String line = brs.readLine();
	String newvervionstring = line.substring(12);
	double newversion = Double.parseDouble(newvervionstring.replace(".", ""));
	double version = Double.parseDouble(currentVersion.replace(".", ""));
	if(newversion > version) {
		main.plug.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', 
				"&dUPDATE > &bPowerToolsPlus &ev" + line.substring(13) + " &bHas been released! Get it now on BukkitDev!"
				));
	} else {
		main.plug.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', 
				"&aPowerToolsPlus &ev" + currentVersion + " &ais up to date"
				));
	}
	brs.close();
	} catch (IOException e) {
		
	}	
	}
	
	public static String SendUpdateChecks(Player p) {

	try {
	URL urls = new URL(readurl);
	BufferedReader brs = new BufferedReader(new InputStreamReader(urls.openStream()));
	String line = brs.readLine();
	String newvervionstring = line.substring(12);
	newversion = Double.parseDouble(newvervionstring.replace(".", ""));
	version = Double.parseDouble(currentVersion.replace(".", ""));
	if(newversion > version) {
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
				"&7[&6Power&atool&7] ➢ &bPowerToolsPlus &ev" + line.substring(13) + " &bHas been released!\nGet it now on BukkitDev! &fhttps://dev.bukkit.org/projects/PowerToolsPlus"
				));
	}
	brs.close();
	} catch (IOException e) {
		
	}	
	if(!(newversion > version)) {
		return "up";
	}
	return null;
	}



	public static String GetNewestVersion() {

	 String readurl1 = "https://raw.githubusercontent.com/proxygames14/PowerToolsPlus/master/version";
	try {
	URL urls = new URL(readurl1);
	BufferedReader brs = new BufferedReader(new InputStreamReader(urls.openStream()));
	String line = brs.readLine();
	brs.close();

	return line.substring(13);

	} catch (IOException e) {
		
	}

	return "ERROR";
	}
	
}
