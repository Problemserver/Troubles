package net.problemzone.troubles.modules.game.spectator;

import net.problemzone.troubles.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SpectatorManager {

    private final List<Player> spectators = new ArrayList<>();

    public void setPlayerAsSpectator(Player player){

        spectators.add(player);

        player.getInventory().clear();
        player.setHealth(Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_MAX_HEALTH)).getDefaultValue());
        player.setArrowsInBody(0);

        player.setPlayerListName(ChatColor.GRAY + player.getName() + ChatColor.RED + " ✗");
        Bukkit.getOnlinePlayers().forEach(p -> p.hidePlayer(Main.getJavaPlugin(), player));

        player.setInvisible(true);
        player.setInvulnerable(true);
        player.setCollidable(false);
        player.setAllowFlight(true);
        player.setFlying(true);
    }

    public void removePlayerFromSpectator(Player player){
        spectators.remove(player);
        player.setPlayerListName(player.getName());
        player.setInvisible(false);
        player.setAllowFlight(false);
        player.setFlying(false);
    }

    public boolean isSpectator(Player player){
        return spectators.contains(player);
    }

    public List<Player> getSpectators() {
        return spectators;
    }
}
