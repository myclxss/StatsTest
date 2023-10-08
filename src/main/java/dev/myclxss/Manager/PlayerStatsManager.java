package dev.myclxss.Manager;

import org.bukkit.entity.Player;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;

import java.util.HashMap;

public class PlayerStatsManager {
    private HashMap<String, Integer> playerStats = new HashMap<>();
    private MongoDBManager mongoDBManager;

    public PlayerStatsManager(MongoDBManager mongoDBManager) {
        this.mongoDBManager = mongoDBManager;
    }

    public void addKill(Player player) {
        String playerName = player.getName();
        int kills = playerStats.getOrDefault(playerName, 0);
        kills++;
        playerStats.put(playerName, kills);
    }

    public int getKills(Player player) {
        return playerStats.getOrDefault(player.getName(), 0);
    }

    public void saveStats(Player player) {
        int kills = getKills(player);
        mongoDBManager.getDatabase().getCollection("asesinatos").updateOne(
                Filters.eq("playerName", player.getName()),
                Updates.set("kills", kills),
                new UpdateOptions().upsert(true));
    }
}