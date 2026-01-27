import DAO.PlayerDAO;
import DAO.TeamDAO;
import Entidades.PlayersEntity;
import Entidades.TeamsEntity;
import util.HibernateUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            TeamDAO teamDAO = new TeamDAO();
            PlayerDAO playerDAO = new PlayerDAO();

            // 1. Buscar team por ID
            System.out.println("=== 1. BUSCAR TEAM POR ID ===\n");
            TeamsEntity team = teamDAO.buscarPorId(57340);
            if (team != null) {
                System.out.println("Team encontrado: " + team.getName());
                System.out.println("Valor: " + team.getTeamValue());
                System.out.println("Coach: " + team.getCoachName());
            }

            // 2. Listar todos los teams
            System.out.println("\n=== 2. LISTAR TODOS LOS TEAMS ===\n");
            List<TeamsEntity> teams = teamDAO.listarEquipos();
            for (TeamsEntity t : teams) {
                System.out.println("- " + t.getName() + " (Valor: " + t.getTeamValue() + ")");
            }

            // 3. Jugadores de un equipo (relación @ManyToOne)
            System.out.println("\n=== 3. JUGADORES DEL EQUIPO ===\n");
            List<PlayersEntity> players = playerDAO.buscarPorIdEquipo(57340);
            for (PlayersEntity p : players) {
                System.out.println("- #" + p.getNumber() + " " + p.getName() +
                        " (" + p.getPosition() + ") - " +
                        p.getTouchdowns() + " TDs");
            }

            // 4. Top 5 goleadores
            System.out.println("\n=== 4. TOP 5 GOLEADORES ===\n");
            List<PlayersEntity> topScorers = playerDAO.maximosGoleadores(5);
            int pos = 1;
            for (PlayersEntity p : topScorers) {
                System.out.println(pos + ". " + p.getName() + " - " +
                        p.getTouchdowns() + " TDs");
                pos++;
            }

            // 5. Buscar por posición
            System.out.println("\n=== 5. JUGADORES GOBLIN ===\n");
            List<PlayersEntity> goblins = playerDAO.buscarPorPosicion("Goblin");
            System.out.println("Total goblins: " + goblins.size());



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.close();
        }
    }
}
