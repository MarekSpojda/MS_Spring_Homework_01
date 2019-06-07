package pl.coderslab.model;

import java.sql.*;

public class ConnectionManager {
    public static Connection getConnection(String host, String user, String password, String database) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + host + ":3306/" + database + "?useSSL=false&characterEncoding=utf8&&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
