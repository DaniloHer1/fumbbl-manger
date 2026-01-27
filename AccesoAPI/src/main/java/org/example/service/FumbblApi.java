package org.example.service;

import com.google.gson.Gson;
import org.example.model.dto.Team;

import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class FumbblApi {
    private static final String BASE_URL = "https://fumbbl.com/api/";
    private Gson gson;

    public FumbblApi() {
        this.gson = new Gson();
    }

    public Team getTeamById(int teamId) {

        String url = BASE_URL + "team/get/" + teamId;

        try {
            URL url1 = new URI(url).toURL();
            var infoString = new StringBuilder();
            Scanner sc = new Scanner(url1.openStream());

            while (sc.hasNext()) {
                infoString.append(sc.nextLine());
            }
            sc.close();
            String jsonString = infoString.toString();
            return gson.fromJson(jsonString, Team.class);


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
