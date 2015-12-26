/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.math.BigDecimal;
import model.Model;
import model.entity.Meal;
import model.entity.Meal.MealType;

/**
 *
 * @author Sasha
 */
public class Controller {
    
    private final Model model = new Model();
    
    public void run() {
        for (Meal meal : model.getMeal()) {
            System.out.println(meal.getId() + ", " + meal.getType() + ", " + 
                    meal.getName() + ", " + meal.getDescription() + ", " + meal.getPrice());
        }
        System.out.println("adding meal - " + model.addMeal(new Meal(45, "Bottled Beer", "Chernihivs'ke", "Very tasty", new BigDecimal(10))));
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
    }
}
