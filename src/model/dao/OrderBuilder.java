/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.entity.DBEntity;
import model.entity.Order;
import model.entity.Order.OrderStatus;

/**
 *
 * @author Sasha
 */
public class OrderBuilder extends EntityBuilder {
    
     /** sql query for all orders */
    private static final String SQL_FOR_ALL_ORDERS = "SELECT * FROM order";
    
//    /** sql query to get entity by id */
//    private static final String SQL_FOR_ENTITY_BY_ID = "SELECT * FROM main_menu WHERE meal_id = ?";
//
//    /** sql query for inserting meal into the main menu table in the data base */
//    private static final String SQL_FOR_INSERTING_ENTITY = "INSERT INTO main_menu (meal_type, meal_name, meal_description, meal_price) VALUES (?, ?, ?, ?)";
//    
//    /** sql query for deleting entity from the data base table */
//    private static final String SQL_FOR_DELETING_BY_ID = "DELETE FROM main_menu WHERE meal_id = ?";

    
    private DBEntity getEntity(ResultSet rs) throws SQLException {
        int id = rs.getInt("order_id");
        OrderStatus status = OrderStatus.valueOf(rs.getString("status"));
        int userId = rs.getInt("user_id");
        BigDecimal price = rs.getBigDecimal("total_price");
        return new Order(id, status, price);
    }

    @Override
    protected List<DBEntity> getAllEntities(WrapperConnectionProxy wrapperConnection) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected DBEntity getEntityById(WrapperConnectionProxy wrapperConnection, int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void insertEntity(WrapperConnectionProxy wrapperConnection, DBEntity entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void deleteById(WrapperConnectionProxy wrapperConnection, int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
