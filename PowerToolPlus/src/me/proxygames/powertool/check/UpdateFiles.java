package me.proxygames.powertool.check;

import java.io.IOException;

import me.proxygames.powertool.files.config;
public class UpdateFiles {
public static void config() {
	
	String noperm = "&cSorry you dont have that permission! You need &e%permission%";
	
	if(config.getConfigFile().getString("UpdateChecker") == null) config.getConfigFile().set("UpdateChecker", true);
	if(config.getConfigFile().getString("DisableBlockToolGrief") == null) config.getConfigFile().set("DisableBlockToolGrief", true);
	if(config.getConfigFile().getString("NoPermissions") == null) config.getConfigFile().set("NoPermissions", noperm);
	try {
		config.getConfigFile().save(config.congiffile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
