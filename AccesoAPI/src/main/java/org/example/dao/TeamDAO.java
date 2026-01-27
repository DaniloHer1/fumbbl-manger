package org.example.dao;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.example.model.dto.Team;
import org.example.util.MongoConnection;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TeamDAO {

    private MongoCollection<Document> coleccionTeams;
    Gson gson;

    public TeamDAO() {
        MongoDatabase database = MongoConnection.getConnection();
        this.coleccionTeams = database.getCollection("teams");
        this.gson = new Gson();
    }

    public void insertarTeam(Team team) {

        String json = gson.toJson(team);
        Document doc = Document.parse(json);

        doc.put("_id", team.getId());

        doc.remove("players");

        coleccionTeams.insertOne(doc);
    }

    public Team buscarPorID(int id) {

        Document query = new Document("_id", id);
        Document doc = coleccionTeams.find(query).first();

        if (doc != null) {
            String json = doc.toJson();
            return gson.fromJson(json, Team.class);
        }
        return null;
    }

    public List<Team> sacarTodos() {
        List<Team> listaEquipos = new ArrayList<>();

        for (Document doc : coleccionTeams.find()) {

            String json = doc.toJson();
            Team equipo = gson.fromJson(json, Team.class);
            listaEquipos.add(equipo);

        }

        return listaEquipos;

    }

    void actualizarTeam(Team team) {

        String json = gson.toJson(team);
        Document nuevoDoc = Document.parse(json);
        nuevoDoc.put("_id", team.getId());

        Document query = new Document("_id", team.getId());

        coleccionTeams.replaceOne(query, nuevoDoc);

        System.out.println("Team actualizado: " + team.getName());


    }

    public Document sacarEquipoConJugadores(int teamId){


        List<Document> agregacion= Arrays.asList(
                new Document("$match",new Document("_id",teamId)),
                new Document("$lookup",
                        new Document("from","players")
                                .append("localField","_id")
                                .append("foreignField","teamId")
                                .append("as","jugadores"))
        );

        Document resultado = coleccionTeams.aggregate(agregacion).first();

        return resultado;
    }


    void borrarTeam(int id) {
        Document query = new Document("_id", id);
        coleccionTeams.deleteOne(query);
        System.out.println("Team Eliminado: ID "+id);
    }

}
