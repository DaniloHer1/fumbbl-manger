package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/FUMBBL";
    private static final String USER = "admin";
    private static final String PASSWORD = "";
    private static Connection con;

    public static Connection getConnection() throws SQLException {
        if (con == null) {

            con = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return con;
    }
    public static void closeConnection(){
        if (con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
