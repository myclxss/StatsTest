package dev.myclxss.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import dev.myclxss.Manager.PlayerStatsManager;

public class PlayerKillListener implements Listener {
    private PlayerStatsManager statsManager;

    public PlayerKillListener(PlayerStatsManager statsManager) {
        this.statsManager = statsManager;
    }

    @EventHandler
    public void onPlayerKill(PlayerDeathEvent event) {
        Player killer = event.getEntity().getKiller();

        if (killer != null) {
            // El jugador killer asesinó a otro jugador
            statsManager.addKill(killer);
        }
    }
}
