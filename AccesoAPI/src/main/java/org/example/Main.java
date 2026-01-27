package org.example;

import org.bson.Document;
import org.example.dao.PlayerDAO;
import org.example.dao.TeamDAO;
import org.example.model.dto.Player;
import org.example.model.dto.Record;
import org.example.model.dto.Team;
import org.example.service.FumbblApi;
import org.example.util.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {

            // 1. Crear esquema
            MySQLCreadorTablas schemaCreator = new MySQLCreadorTablas();
            schemaCreator.inicializar();

            // 2. Migrar
            MigraMongoASLQ migration = new MigraMongoASLQ();
            migration.migracionCompleta();



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MongoConnection.cerrarConexion();
            MySQLConnection.closeConnection();
        }
    }




    public static void inicializarBD(){
        DatabaseCreator creador=new DatabaseCreator();
        creador.inicializar();
    }
}