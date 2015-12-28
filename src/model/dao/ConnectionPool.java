/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;
import java.util.ResourceBundle;

/**
 *
 * @author Sasha
 */
public class ConnectionPool {
    
    private Queue<Connection> connections;
    
    private int maxConnections;

    public ConnectionPool() {
        connections = new LinkedList<>();
    }
    
    public int getMaxConnections() {
        return maxConnections;
    }
    
    public void setMaxConnection(int maxConnections) {
        this.maxConnections = maxConnections;
    }
    
    public WrapperConnection getConnection() throws SQLException {
        Connection freeConnection;
        if (connections.size() >0) {
            freeConnection = connections.poll();
        } else {
            Properties prop = new Properties();
            ResourceBundle bundle = ResourceBundle.getBundle("model/dao/restaurantprop");
            String url = bundle.getString("db.url");
            String login = bundle.getString("db.login");
            String pass = bundle.getString("db.password");
            prop.put("user", login);
            prop.put("password", pass);
            prop.put("autoReconnect", "true");
            prop.put("characterEncoding", "UTF-8");
            prop.put("useUnicode", "true");
            freeConnection = DriverManager.getConnection(url, prop);
        }
        return new WrapperConnection(freeConnection, this);
    }
    
    public void putConnection(Connection connection) {
        if (connection != null) {
            if (connections.size() < maxConnections) {
                connections.add(connection);
            } else {
                try {
                    connection.close();
                }catch (SQLException e) {
                    System.out.println("connection was not be closed!!! " + e.getMessage());
                }
            }
        }
    }
}
