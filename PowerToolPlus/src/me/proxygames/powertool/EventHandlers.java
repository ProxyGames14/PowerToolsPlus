package me.proxygames.powertool;



import me.proxygames.powertool.check.UpdateChecker;
import me.proxygames.powertool.check.clickevent;
import me.proxygames.powertool.files.checkitem;
import me.proxygames.powertool.files.config;
import me.proxygames.powertool.files.filemenu;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventHandlers implements Listener {
	
    @EventHandler
    public void BlockBreak(BlockBreakEvent event){
    	if(config.getConfigFile().getBoolean("DisableBlockToolGrief") == false) return;
    	if(checkitem.checkitemid(event.getPlayer())) event.setCancelled(true);     
    }
    @EventHandler
    public void BlockPlace(BlockPlaceEvent event){
    	if(config.getConfigFile().getBoolean("DisableBlockToolGrief") == false) return;
    	if(checkitem.checkitemid(event.getPlayer())) event.setCancelled(true);     
    }
    
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
    	if(event.getPlayer().hasPermission("powertoolplus.update.checker") && config.getConfigFile().getBoolean("UpdateChecker")) {
            UpdateChecker.SendUpdateChecks(event.getPlayer());
    	}
    	
       filemenu.CreateFile(event.getPlayer());
    }
	
	@EventHandler
	  public void ClickEvent(PlayerInteractEvent event)
	  {
          clickevent.CheckClick(event.getAction(), event.getPlayer(), event);
          
        }
	
}
