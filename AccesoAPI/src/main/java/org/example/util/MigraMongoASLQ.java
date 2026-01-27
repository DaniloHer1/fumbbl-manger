package org.example.util;

import org.example.dao.PlayerDAO;
import org.example.dao.TeamDAO;
import org.example.model.dto.Player;
import org.example.model.dto.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public class MigraMongoASLQ {
    public void migrarEquipo() throws SQLException {

        TeamDAO mongoDAO = new TeamDAO();
        List<Team> listaEquipo = mongoDAO.sacarTodos();

        if (listaEquipo.isEmpty()) {
            System.out.println("Lista vacia");
        }

        Connection connection = MySQLConnection.getConnection();
        String sql = ("""
                INSERT INTO teams (id, name, coach_id, coach_name, roster_id, roster_name,team_value, current_team_value,
                 treasury, fan_factor, rerolls, apothecary, games, wins, ties, losses) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                  """);

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        int cont = 0;
        for (Team t : listaEquipo) {
            preparedStatement.setInt(1, t.getId());
            preparedStatement.setString(2, t.getName());

            if (t.getCoach() != null) {
                preparedStatement.setInt(3, t.getCoach().getId());
                preparedStatement.setString(4, t.getCoach().getName());
            } else {
                preparedStatement.setNull(3, Types.INTEGER);
                preparedStatement.setNull(4, Types.VARCHAR);
            }
            if (t.getRoster() != null) {
                preparedStatement.setInt(5, t.getRoster().getId());
                preparedStatement.setString(6, t.getRoster().getName());
            } else {
                preparedStatement.setNull(5, Types.INTEGER);
                preparedStatement.setNull(6, Types.VARCHAR);
            }
            preparedStatement.setInt(7, t.getTeamValue());
            preparedStatement.setInt(8, t.getCurrentValue());
            preparedStatement.setInt(9, t.getTreasury());
            preparedStatement.setInt(10, t.getFanFactor());
            preparedStatement.setInt(11, t.getRerolls());
            preparedStatement.setString(12, t.getApothecary());

            if (t.getRecord() != null) {
                preparedStatement.setInt(13, t.getRecord().getGames());
                preparedStatement.setInt(14, t.getRecord().getWins());
                preparedStatement.setInt(15, t.getRecord().getTies());
                preparedStatement.setInt(16, t.getRecord().getLosses());
            } else {
                preparedStatement.setNull(13, Types.INTEGER);
                preparedStatement.setNull(14, Types.INTEGER);
                preparedStatement.setNull(15, Types.INTEGER);
                preparedStatement.setNull(16, Types.INTEGER);

            }

            preparedStatement.execute();
            cont++;
            System.out.println("EQUIPO MIGRADO: " + t.getName());
        }

        preparedStatement.close();
        System.out.println("EQUIPOS MIGRADOS " + cont);
    }

    public void migrarJugador() throws SQLException {

        PlayerDAO mongoDAO = new PlayerDAO();
        List<Player> listajugador = mongoDAO.sacarTodos();

        if (listajugador.isEmpty()) {
            System.out.println("Lista vacia ");
        }

        Connection connection = MySQLConnection.getConnection();
        String sql = ("""
                INSERT INTO players (id, team_id, number, name, position, position_id,injuries, skills, games, completions, touchdowns, casualties, mvps, spp)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                  """);

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        int cont = 0;
        for (Player p : listajugador) {
            preparedStatement.setInt(1, p.getId());
            preparedStatement.setInt(2, p.getTeamId());
            preparedStatement.setInt(3, p.getNumber());
            preparedStatement.setString(4, p.getName());
            preparedStatement.setString(5, p.getPosition());
            preparedStatement.setInt(6, p.getPositionId());
            preparedStatement.setInt(6, p.getPositionId());
            preparedStatement.setString(7, p.getInjuries());

            String skills = "";

            if (p.getSkills() != null && !p.getSkills().isEmpty()) {
                skills = String.join(",", p.getSkills());
            }
            preparedStatement.setString(8, skills);

            if (p.getRecord() != null) {

                preparedStatement.setInt(9, p.getRecord().getGames());
                preparedStatement.setInt(10, p.getRecord().getCompletions());
                preparedStatement.setInt(11, p.getRecord().getTouchdowns());
                preparedStatement.setInt(12, p.getRecord().getCasualities());
                preparedStatement.setInt(13, p.getRecord().getMvps());
                preparedStatement.setInt(14, p.getRecord().getSsp());

            }else{
                preparedStatement.setNull(9,Types.INTEGER);
                preparedStatement.setNull(10,Types.INTEGER);
                preparedStatement.setNull(11,Types.INTEGER);
                preparedStatement.setNull(12,Types.INTEGER);
                preparedStatement.setNull(13,Types.INTEGER);
                preparedStatement.setNull(14,Types.INTEGER);
            }

            preparedStatement.execute();
            cont++;
            System.out.println("JUGADOR MIGRADO: " + p.getName());
        }

        preparedStatement.close();
        System.out.println("JUGADORES MIGRADOS " + cont);
    }
    public void migracionCompleta(){
        try {
            migrarEquipo();
            migrarJugador();
            System.out.println("MIGRACION COMPLETADA");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
