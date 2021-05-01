package net.problemzone.troubles.modules.game;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class GameListener implements Listener {

    private final GameManager gameManager;

    public GameListener(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){
        gameManager.removePlayer(e.getPlayer());
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        gameManager.removePlayer(e.getEntity());
    }

    @EventHandler
    public void preGameDamageListener(EntityDamageEvent e) {
        if(gameManager.getGameState() != GameState.RUNNING){
            e.setCancelled(true);
        }
    }

}