/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import model.dao.RestaurantDAO;
import model.dao.ServerOverloadedException;
import model.entity.Meal;

/**
 *
 * @author Sasha
 */
public class Model {
    
    private final RestaurantDAO restaurant = new RestaurantDAO();
    
    private List<Meal> meals = new ArrayList<>();
    
    public List<Meal> getMeal() throws ServerOverloadedException {
        return meals = restaurant.findAll();
    }
    
    public boolean addMeal(Meal entity) throws ServerOverloadedException {
        return restaurant.create(entity);
    }
    
    public boolean delete(int id) throws ServerOverloadedException {
        return restaurant.delete(id);
    }
}
