package org.example.util;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {
    
    final static String CADENACONEXION = "mongodb://admin:admin@localhost:27017/FUMBBL?authSource=FUMBBL";
    private static String NOMBRE_BD="FUMBBL";
    private static MongoClient cliente;
    private static MongoDatabase database;


    public static MongoClient getMongoClient() {
        if (cliente == null) {
            cliente= MongoClients.create(CADENACONEXION);
        }
        return cliente;
    }
    public static MongoDatabase getConnection(){
        return getMongoClient().getDatabase(NOMBRE_BD);
    }
    public static void cerrarConexion() {
        if (cliente != null) {
            cliente.close();
            cliente = null;
        }
    }




}
