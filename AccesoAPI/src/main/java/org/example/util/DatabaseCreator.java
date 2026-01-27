package org.example.util;

import com.mongodb.client.MongoDatabase;

public class DatabaseCreator {
    private MongoDatabase database;

    public DatabaseCreator() {
        this.database = MongoConnection.getConnection();
    }

    public void inicializar() {

        createCollections();

    }

    private void createCollections() {
        boolean teamExiste = collectionExists("teams");
        boolean playerExiste = collectionExists("players");

        if (!teamExiste) {
            database.createCollection("teams");
        }else {
            System.out.println("Ya existe la Coleccion teams");
        }

        if (!playerExiste) {
            database.createCollection("players");
        }else {
            System.out.println("Ya existe la Coleccion players");
        }
    }

    private boolean collectionExists(String collection) {
        for (String nombre : database.listCollectionNames()) {
            if (nombre.equals(collection)) {
                return true;
            }
        }
        return false;
    }
}
