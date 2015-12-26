/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import model.dao.RestaurantDAO;
import model.entity.Meal;

/**
 *
 * @author Sasha
 */
public class Model {
    
    private final RestaurantDAO restaurant = new RestaurantDAO();
    
    private List<Meal> meals = new ArrayList<>();
    
    public List<Meal> getMeal() {
        return meals = restaurant.findAllMeal();
    }
    
    public boolean addMeal(Meal entity) {
        return restaurant.createMeal(entity);
    }
    
    public boolean delete(int id) {
        return restaurant.deleteMeal(id);
    }
}
