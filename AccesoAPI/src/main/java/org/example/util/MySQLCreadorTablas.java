package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLCreadorTablas {
    public void crearBD() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/";
        Connection con = DriverManager.getConnection(url, "admin", "");

        Statement stm = con.createStatement();
        stm.execute("CREATE DATABASE IF NOT EXISTS FUMBBL");
        System.out.println("BASE DE DATOS CREADA");

        stm.close();
        con.close();
    }

    public void crearTablas() throws SQLException {
        Connection conn = MySQLConnection.getConnection();
        Statement stmt = conn.createStatement();

        String crearEquipo = """
                    CREATE  TABLE IF NOT EXISTS teams( 
                    id INT PRIMARY KEY,
                    name VARCHAR(200) NOT NULL,
                    coach_id INT,
                    coach_name VARCHAR(100),
                    roster_id INT,
                    roster_name VARCHAR(100),
                    team_value INT,
                    current_team_value INT,
                    treasury INT,
                    fan_factor INT,
                    rerolls INT,
                    apothecary VARCHAR(10),
                    games INT,
                    wins INT,
                    ties INT,
                    losses INT                    
                    )
                """;

        stmt.execute(crearEquipo);
        System.out.println("TABLA EQUIPOS CREADA");

        String crearJugador = """
                    CREATE  TABLE IF NOT EXISTS players( 
                    id INT PRIMARY KEY,
                    team_id INT NOT NULL,
                    number INT,
                    name VARCHAR(100) NOT NULL,
                    position VARCHAR(50),
                    position_id INT,
                    injuries VARCHAR(50),
                    skills TEXT,
                    games INT,
                    completions INT,
                    touchdowns INT,
                    casualties VARCHAR(10),
                    mvps INT,
                    spp INT,
                    FOREIGN KEY (team_id) REFERENCES teams(id) ON DELETE CASCADE                  
                    )
                """;

        stmt.execute(crearJugador);
        System.out.println("TABLA JUGADORES CREADA");


        stmt.close();

    }

    public void inicializar() {
        try {
            crearBD();
            crearTablas();
            System.out.println("ESQUEMA LISTO");
        } catch (Exception ex) {
            System.out.println("ERROR");
            ex.printStackTrace();
        }
    }
}
