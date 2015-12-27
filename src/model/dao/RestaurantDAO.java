/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.entity.Meal;
import model.entity.Meal.MealType;

/**
 *
 * @author Sasha
 */
public class RestaurantDAO extends AbstractDAO {

    /** sql query to get all meal */
    private static final String SQL_GET_ALL = "SELECT * FROM main_menu";
    
    /** sql query to get meal by type */
    private static final String SQL_GET_BY_TYPE = "SELECT * FROM main_menu WHERE meal_type = ?";
    
    /** sql query to get meal by id */
    private static final String SQL_DELETE_BY_ID = "DELETE FROM main_menu WHERE meal_id = ?";
    
    /** sql query to insert meal into data base */
    private static final String SQL_INSERT_MEAL = 
            "INSERT INTO main_menu (meal_id, meal_type, meal_name, meal_description, meal_price) VALUES (?, ?, ?, ?, ?)";
    
    /**
     * Find all meal
     * @return array list with meal list
     */
    @Override
    public List findAllMeal() {
        List<Meal> meals = new ArrayList<>();
        Connection conn = null;
        Statement st;
        try {
            conn = connectionPool.getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL_GET_ALL);
            while (rs.next()) {
                meals.add(getMeal(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally { 
            if (conn != null) {
                connectionPool.putConnection(conn);
            }
        }
        return meals;
    }
    
    /**
     * find meal by type
     * @param type meal type
     * @return list of meal entities
     */
    public  List findByType(MealType type) {
        List<Meal> allMeal = new ArrayList<>();
        String typeString;
        switch (type) {
            case EXPRESS_LUNCH:
                typeString = "Express Lunch";
                break;
            case DESSERT:
                typeString = "Dessert";
                break;
            case BEVERAGE:
                typeString = "Beverage";
                break;
            case BOTTLE_BEER:
                typeString = "Bottled Beer";
                break;
            default:
                return null;
        }
        Connection conn = null;
        PreparedStatement ps;
        try {  
            conn = connectionPool.getConnection();
            ps = conn.prepareStatement(SQL_GET_BY_TYPE);
            ps.setString(1, typeString);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                allMeal.add(getMeal(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (conn != null) {
                connectionPool.putConnection(conn);
            }
        }
        return allMeal;
    }
    
    /**
     * Get meal
     * @param rs result set with meal
     * @return meal entity
     * @throws SQLException 
     */
    private Meal getMeal(ResultSet rs) throws SQLException {
        int id = rs.getInt("meal_id");
        String type = rs.getString("meal_type");
        String name = rs.getString("meal_name");
        String description = rs.getString("meal_description");
        BigDecimal price = rs.getBigDecimal("meal_price");
        return new Meal(id, type, name, description, price);
    }
    
    /**
     * Creat new meal and add to the data base
     * @param entity entity might be added
     * @return true if adding will be successful and false otherwise
     */
    @Override
    public boolean createMeal(Meal entity) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement ps;
        try {
            conn = connectionPool.getConnection();
            ps = conn.prepareStatement(SQL_INSERT_MEAL);
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getTypeString());
            ps.setString(3, entity.getName());
            ps.setString(4, entity.getDescription());
            ps.setBigDecimal(5, entity.getPrice());
            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (conn != null) {
                connectionPool.putConnection(conn);
            }
        }
        return flag;
    }

    /**
     * Delete meal by entity
     * @param entity meal entity might be deleted
     * @return true if deleting will be successful and false otherwise
     */
    @Override
    public boolean deleteMeal(Meal entity) {
        return deleteMeal(entity.getId());
    }

    /**
     * Delete meal by id
     * @param id meal id
     * @return true if deleting will be successful and false otherwise
     */
    @Override
    public boolean deleteMeal(int id) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement ps;
        try {
            conn = connectionPool.getConnection();
            ps = conn.prepareStatement(SQL_DELETE_BY_ID);
            ps.setInt(1, id);
            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (conn != null) {
                connectionPool.putConnection(conn);
            }
        }
        return flag;
    }
    
    @Override
    public boolean updateMeal(Meal entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
