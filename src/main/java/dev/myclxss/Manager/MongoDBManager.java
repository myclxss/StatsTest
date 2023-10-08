package dev.myclxss.Manager;

import org.bukkit.plugin.java.JavaPlugin;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoDBManager {

    private MongoClient mongoClient;
    private MongoDatabase database;

    public MongoDBManager(JavaPlugin plugin) {
        // Configura la conexión a MongoDB utilizando una URI
        String connectionString = "mongodb+srv://myclxss:anhuar2004@cluster0.lpdiqzf.mongodb.net/"; // Cambia esto según
                                                                                                    // tu configuración
        MongoClientURI uri = new MongoClientURI(connectionString);
        mongoClient = new MongoClient(uri);
        database = mongoClient.getDatabase("fullpvpdb"); // Cambia el nombre de la base de datos
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}