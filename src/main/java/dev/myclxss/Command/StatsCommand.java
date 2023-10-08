package dev.myclxss.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.myclxss.Manager.PlayerStatsManager;

public class StatsCommand implements CommandExecutor {
    private PlayerStatsManager statsManager;

    public StatsCommand(PlayerStatsManager statsManager) {
        this.statsManager = statsManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            int kills = statsManager.getKills(player);
            player.sendMessage("Tus estadísticas: Kills: " + kills);
        } else {
            sender.sendMessage("Este comando solo puede ser ejecutado por jugadores.");
        }
        return true;
    }
}
