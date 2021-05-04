package net.problemzone.troubles.modules;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class WorldProtectionListener implements Listener {

    @EventHandler
    //Cancels Block Breaks
    public void onBlockBreak(BlockBreakEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    //Cancels Block Placing
    public void onBlockPlace(BlockPlaceEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    //Cancels all Interactions
    public void onPlayerInteract(PlayerInteractEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    //Cancels all Block Changes
    public void onEntityBlockChange(EntityChangeBlockEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    //Cancel Hunger
    public void onHungerDrain(FoodLevelChangeEvent e){
        e.setCancelled(true);
    }

}