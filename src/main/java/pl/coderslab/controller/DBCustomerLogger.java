package pl.coderslab.controller;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
//@Primary
public class DBCustomerLogger implements CustomerLogger {
    private String host;
    private String user;
    private String password;
    private String database;

    @SuppressWarnings({"SqlResolve", "SqlNoDataSourceInspection"})
    @Override
    public void log(String message) {
        PreparedStatement prepStatement = null;
        try (Connection connection = ConnectionManager.getConnection(this.host, this.user, this.password, this.database)) {
            prepStatement = connection.prepareStatement("insert into springlogin(logvalue) values (?)");
            prepStatement.setString(1, message);
            prepStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}
