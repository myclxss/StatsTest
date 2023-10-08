package dev.myclxss.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import dev.myclxss.Manager.PlayerStatsManager;

public class PlayerQuitEventListener implements Listener {
    private PlayerStatsManager statsManager;

    public PlayerQuitEventListener(PlayerStatsManager statsManager) {
        this.statsManager = statsManager;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        // Guarda las estadísticas del jugador al desconectarse
        statsManager.saveStats(player);
    }
}