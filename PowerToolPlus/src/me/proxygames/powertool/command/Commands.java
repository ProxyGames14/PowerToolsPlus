package me.proxygames.powertool.command;

import me.proxygames.powertool.check.UpdateChecker;
import me.proxygames.powertool.files.adddata;
import me.proxygames.powertool.files.filemenu;
import me.proxygames.powertool.files.reload;
import me.proxygames.powertool.files.setdata;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] a) {
	    if(!sender.hasPermission("powertoolplus.command")) {
	    	Permissions.Send(sender, "powertoolplus.command");
	    	return false;
		}
	    
		if(checkvalid(a, sender)) return false;
		
		if(a[0].equalsIgnoreCase("help")) {
			
		    if(!sender.hasPermission("powertoolplus.command.help")) {
		    	Permissions.Send(sender, "powertoolplus.command.help");
		    	return false;
			}
			
			sender.sendMessage(color("&6&lPower&a&ltool &eHelp menu &7Page 1/1"));
			sender.sendMessage(color(" \n"));
			sender.sendMessage(color("&b➢ &a/pt &6right_click &e| &6left_click &d[text]"));
			sender.sendMessage(color("&b➢ &a/pt &6shift_right_click &e| &6shift_left_click &d[text]"));
			sender.sendMessage(color("&b➢ &a/pt &6add &d[type] [text]"));//
			sender.sendMessage(color("&b➢ &a/pt &6clear &d[type]"));
			sender.sendMessage(color("&b➢ &a/pt &6reset"));
			sender.sendMessage(color("&b➢ &a/pt &6reload"));
			sender.sendMessage(color("&b➢ &a/pt &6checkupdates"));
			return false;
		}
		
		if(a[0].equalsIgnoreCase("checkupdates")) {
		    if(!sender.hasPermission("powertoolplus.command.checkupdates")) {
		    	Permissions.Send(sender, "powertoolplus.command.checkupdates");
		    	return false;
			}
		    
		    if(UpdateChecker.SendUpdateChecks((Player) sender) == "up") {
		    sender.sendMessage(color("&7[&6Power&atool&7] &b➢ &7This version is up to date!"));
		    return false;
		    }
		}
		
		if(a[0].equalsIgnoreCase("add")) {
		    if(!sender.hasPermission("powertoolplus.command.add")) {
		    	Permissions.Send(sender, "powertoolplus.command.add");
		    	return false;
			}
		    
			if(a.length == 2) {
				sender.sendMessage(color("&7[&6Power&atool&7] &e➣ &7You need to fill something in!"));
				return false;
			}
			if(a[1].equalsIgnoreCase("right_click")) {
		    adddata.add((Player)sender, 1, a, sender);
			return false;
			} else
			if(a[1].equalsIgnoreCase("shift_right_click")) {
			adddata.add((Player)sender, 2, a, sender);
			return false;
			} else
			if(a[1].equalsIgnoreCase("left_click")) {
			adddata.add((Player)sender, 3, a, sender);
			return false;
			} else
			if(a[1].equalsIgnoreCase("shift_left_click")) {
			adddata.add((Player)sender, 4, a, sender);
			return false;
			} else {
				sender.sendMessage(color("&7[&6Power&atool&7] &e➣ &7Please select a vallid data-type!"));
				return false;
			}	
		}
		
		
		if(a[0].equalsIgnoreCase("clear")) {
		    if(!sender.hasPermission("powertoolplus.command.clear")) {
		    	Permissions.Send(sender, "powertoolplus.command.clear");
		    	return false;
			}
			if(a[1].equalsIgnoreCase("right_click")) {
			filemenu.Reset((Player)sender, 1);
			return false;
			} else
			if(a[1].equalsIgnoreCase("shift_right_click")) {
			filemenu.Reset((Player)sender, 2);
			return false;
			} else
			if(a[1].equalsIgnoreCase("left_click")) {
			filemenu.Reset((Player)sender, 3);
			return false;
			} else
			if(a[1].equalsIgnoreCase("shift_left_click")) {
			filemenu.Reset((Player)sender, 4);
			return false;
			} else {
				sender.sendMessage(color("&7[&6Power&atool&7] &e➣ &7Please select a vallid data-type!"));
				return false;
			}
		}
		
		if(a[0].equalsIgnoreCase("reset")) {
		    if(!sender.hasPermission("powertoolplus.command.reset")) {
		    	Permissions.Send(sender, "powertoolplus.command.reset");
		    	return false;
			}
			filemenu.Reset((Player)sender, 5);
			sender.sendMessage(color("&7[&6Power&atool&7] &e➣ &aSuccesfully resetted all your data!"));
		}
		
		if(a[0].equalsIgnoreCase("reload")) {
		    if(!sender.hasPermission("powertoolplus.command.reload")) {
		    	Permissions.Send(sender, "powertoolplus.command.reload");
		    	return false;
			}
			for(Player p : Bukkit.getOnlinePlayers())
			filemenu.saveFiles(p);
			reload.reloading();
			sender.sendMessage(color("&7[&6Power&atool&7] &e➣ &aReloaded plugin! &fFiles: &e" + reload.GetAmount()));
		}
		
		
		if(a[0].equalsIgnoreCase("right_click")) {
		    if(!sender.hasPermission("powertoolplus.command.right.click")) {
		    	Permissions.Send(sender, "powertoolplus.command");
		    	return false;
			}
			sender.sendMessage(color("&7[&6Power&atool&7] &e➣ &aSuccesfully setted &eright_click data &aon your tool!"));
			Player player = (Player) sender;
			set(player, 1, a, sender);
			return false;
		} else if(a[0].equalsIgnoreCase("shift_right_click")) {
		    if(!sender.hasPermission("powertoolplus.command.shift.right.click")) {
		    	Permissions.Send(sender, "powertoolplus.command");
		    	return false;
			}
			sender.sendMessage(color("&7[&6Power&atool&7] &e➣ &aSuccesfully setted &eshift_right_click data &aon your tool!"));
			Player player = (Player) sender;
			set(player, 2, a, sender);
			return false;
		} else if(a[0].equalsIgnoreCase("left_click")) {
		    if(!sender.hasPermission("powertoolplus.command.left.click")) {
		    	Permissions.Send(sender, "powertoolplus.command");
		    	return false;
			}
			sender.sendMessage(color("&7[&6Power&atool&7] &e➣ &aSuccesfully setted &eleft_click data &aon your tool!"));
			Player player = (Player) sender;
			set(player, 3, a, sender);
			return false;
		} else if(a[0].equalsIgnoreCase("shift_left_click")) {
		    if(!sender.hasPermission("powertoolplus.command.shift.left.click")) {
		    	Permissions.Send(sender, "powertoolplus.command");
		    	return false;
			}
			sender.sendMessage(color("&7[&6Power&atool&7] &e➣ &aSuccesfully setted &eshift_left_click data &aon your tool!"));
			Player player = (Player) sender;
			set(player, 4, a, sender);
			return false;
		}
		
		return false;
	}
	
	public void set(Player player, int type, String[] a, CommandSender sender) {
		StringBuilder query = new StringBuilder();
		for(int i = 1; i < a.length; i++) {
			if(i > 1) query.append(" ");
			query.append(a[i]);
		}
		String[] querylist = {query.toString()};
		setdata.data(player, type, querylist, sender);
	}
	public String color(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	
	public boolean checkvalid(String[] a, CommandSender sender) {
		if(
				a.length == 0
				||
				(a.length == 1 && !a[0].equalsIgnoreCase("help") && !a[0].equalsIgnoreCase("checkupdates") && !a[0].equalsIgnoreCase("reset") && !a[0].equalsIgnoreCase("reload"))		
				) {
		sender.sendMessage(color("&7[&6Power&atool&7] &e➣ &7Wrong usage! type /pt help for info"));
		return true;
		}
		else {
			return false;
		}
	}

}
