/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.math.BigDecimal;
import model.Model;
import model.dao.ServerOverloadedException;
import model.entity.Meal;

/**
 *
 * @author Sasha
 */
public class Controller {
    
    private final Model model = new Model();
    
    /**
     * HARD CODE!!!
     */
    public void run() {
        try {
            for (Meal meal : model.getMeal()) {
                System.out.println(meal.getId() + ", " + meal.getType() + ", " + 
                        meal.getName() + ", " + meal.getDescription() + ", " + meal.getPrice());
            }
            System.out.println("adding meal - " + model.addMeal(new Meal(45, new BigDecimal(10), "Bottled Beer", "Chernihivs'ke", "Very tasty", 10))); // hard code
            System.out.println("After adding");
            for (Meal meal : model.getMeal()) {
                System.out.println(meal.getId() + ", " + meal.getType() + ", " + 
                        meal.getName() + ", " + meal.getDescription() + ", " + meal.getPrice());
            }
            System.out.println("Delete this: ");
            System.out.println("Deleting - " + model.delete(45));
            System.out.println("After deleting: ");
            for (Meal meal : model.getMeal()) {
                System.out.println(meal.getId() + ", " + meal.getType() + ", " + 
                        meal.getName() + ", " + meal.getDescription() + ", " + meal.getPrice());
            }
        } catch (ServerOverloadedException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
