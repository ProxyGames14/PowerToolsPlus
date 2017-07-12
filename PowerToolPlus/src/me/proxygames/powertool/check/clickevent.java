package me.proxygames.powertool.check;

import me.proxygames.powertool.Executer;
import me.proxygames.powertool.files.checkitem;

import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class clickevent {
	
	public static void CheckClick(Action action, Player player, PlayerInteractEvent event) {
				
		
		
		if(action.name().equalsIgnoreCase("RIGHT_CLICK_BLOCK")) {
			if(fixcall(event)) {
				if(shift(player)) click(action, player, event, 2);	
				else click(action, player, event, 1);
			}
			return;
		}
		if(action.name().equalsIgnoreCase("RIGHT_CLICK_AIR")) {
			if(fixcall(event)) {
				if(shift(player)) click(action, player, event, 2);
				else click(action, player, event, 1);
			}
			return;
		}
		if(action.name().equalsIgnoreCase("LEFT_CLICK_BLOCK")) {
			if(fixcall(event)) {
				if(shift(player)) click(action, player, event, 4);	
				else click(action, player, event, 3);
			}
			return;
		}
		if(action.name().equalsIgnoreCase("LEFT_CLICK_AIR")) {
			if(fixcall(event)) {
				if(shift(player)) click(action, player, event, 4);
				else click(action, player, event, 3);
			}
			return;
		}
												
	}
	
	public static void click(Action action, Player player, PlayerInteractEvent event, int type) {		
		if(!checkitem.checkitemid(player)) return;
		Executer.executer(player, type);
	}
	public static boolean fixcall(PlayerInteractEvent event) {
		if(event.getHand().equals(EquipmentSlot.HAND)) return true;
		else return false;
	}
	public static boolean shift(Player player) {
		if(player.isSneaking()) return true;
		else return false;
	}
}
