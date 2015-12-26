/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Create and returns required connection
 * @author Sasha
 */
public class Connector {
    
    /**
     * Create and return connection
     * @return connection
     * @throws SQLException 
     */
    public static Connection getConnection() throws SQLException {
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
        return DriverManager.getConnection(url, prop);
    }
}
