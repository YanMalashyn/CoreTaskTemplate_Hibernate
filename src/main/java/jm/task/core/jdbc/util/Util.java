package jm.task.core.jdbc.util;


import java.sql.*;

public class Util {
    private final static String URL = "jdbc:mysql://localhost:3306/usershema?autoReconnect=true&useSSL=false";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "85ds96m";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
