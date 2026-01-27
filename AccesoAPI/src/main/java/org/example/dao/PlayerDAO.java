package org.example.dao;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.example.model.dto.Player;
import org.example.model.dto.Team;
import org.example.util.MongoConnection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerDAO {
    private MongoCollection<Document> coleccionPlayers;
    Gson gson;
    public PlayerDAO() {
        MongoDatabase database = MongoConnection.getConnection();
        this.coleccionPlayers = database.getCollection("players");
        this.gson = new Gson();
    }
    public void insertarPlayer(Player player) {

        String json = gson.toJson(player);
        Document doc = Document.parse(json);

        doc.put("_id", player.getId());

        coleccionPlayers.insertOne(doc);

        System.out.println("Player insertado: " + player.getName());
    }

    Team buscarPorID(int id) {

        Document query = new Document("_id", id);
        Document doc = coleccionPlayers.find(query).first();

        if (doc != null) {
            String json = doc.toJson();
            return gson.fromJson(json, Team.class);
        }
        return null;
    }

    public List<Player> buscarPorTeamId(int teamId){

        List<Player> players =new ArrayList<>();
        Document query=new Document("teamId",teamId);

        for (Document doc:coleccionPlayers.find(query)){
            String json= doc.toJson();
            Player player=gson.fromJson(json,Player.class);
            players.add(player);

        }
        return players;
    }

    public List<Player> sacarTodos() {

        List<Player> listaJugadores = new ArrayList<>();

        for (Document doc : coleccionPlayers.find()) {

            String json = doc.toJson();
            Player jugador = gson.fromJson(json, Player.class);
            listaJugadores.add(jugador);

        }

        return listaJugadores;

    }

    void actualizarTeam(Player player) {

        String json = gson.toJson(player);
        Document nuevoDoc = Document.parse(json);
        nuevoDoc.put("_id", player.getId());

        Document query = new Document("_id", player.getId());

        coleccionPlayers.replaceOne(query, nuevoDoc);

        System.out.println("Player actualizado: " + player.getName());


    }

    void borrarTeam(int id) {
        Document query = new Document("_id", id);
        coleccionPlayers.deleteOne(query);
        System.out.println("Player Eliminado: ID "+id);
    }

    // Consultas Agregacion
    public List<Document> sacarConteoPorPosicion(int teamId) {

        List<Document> conteo = Arrays.asList(
                // Match
                new Document("$match",
                        new Document("teamId", teamId)
                ),

                new Document("$group",
                        new Document("_id", "$position")
                                .append("total", new Document("$sum", 1))
                                .append("touchdownsTotal",
                                        new Document("$sum", "$record.touchdowns"))
                ),


                new Document("$sort",
                        new Document("total", -1)
                )
        );

        List<Document> resultado = new ArrayList<>();
        coleccionPlayers.aggregate(conteo).into(resultado);

        return resultado;
    }


    public List<Document> sacarTopGoleadores(int teamId,int limite){


        List<Document> conteo= Arrays.asList(

                new Document("$match",
                        new Document("teamId",teamId)
                ),

                new Document("$project",
                        new Document("name",1)
                                .append("position",1)
                                .append("touchdowns","$record.touchdowns")
                ),

                new Document("$sort",
                        new Document("touchdowns",-1)
                ),

                new Document("$limit",limite)

        );

        List<Document> resultado=new ArrayList<>();

        coleccionPlayers.aggregate(conteo).into(resultado);

        return resultado;
    }

}
