package dev.myclxss;

import org.bukkit.plugin.java.JavaPlugin;

import dev.myclxss.Command.StatsCommand;
import dev.myclxss.Listener.PlayerKillListener;
import dev.myclxss.Listener.PlayerQuitEventListener;
import dev.myclxss.Manager.MongoDBManager;
import dev.myclxss.Manager.PlayerStatsManager;

public class StatsTest extends JavaPlugin {

    private MongoDBManager mongoDBManager;
    private PlayerStatsManager statsManager;

    @Override
    public void onEnable() {

        // Inicializa la conexión a MongoDB
        mongoDBManager = new MongoDBManager(this);

        // Inicializa el administrador de estadísticas
        statsManager = new PlayerStatsManager(mongoDBManager);

        // Registra los listeners de eventos
        // Registra los listeners de eventos
        getServer().getPluginManager().registerEvents(new PlayerKillListener(statsManager), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitEventListener(statsManager), this);


        // Registra el comando /estadisticas
        getCommand("estadisticas").setExecutor(new StatsCommand(statsManager));

    }

    public void onDisable() {
        // Cierra la conexión a MongoDB al desactivar el plugin
        if (mongoDBManager != null) {
            mongoDBManager.close();
        }
    }

}
