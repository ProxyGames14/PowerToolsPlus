package me.proxygames.powertool.files;

import org.bukkit.entity.Player;

public class checkitem {

	
	@SuppressWarnings("deprecation")
	public static boolean checkitemid(Player player) {
		String item = player.getItemInHand().getTypeId() + "-" + player.getItemInHand().getDurability();
		if(filemenu.getplayerfile(player).getString("Items.List." + item) == null) return false;
		else return true;
	}
	@SuppressWarnings("deprecation")
	public static String getitemid(Player player) {
		return (player.getItemInHand().getTypeId() + "-" + player.getItemInHand().getDurability());
	}
}
