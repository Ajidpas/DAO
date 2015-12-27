/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.entity.Meal;

/**
 *
 * @author Sasha
 * @param <K> table key
 * @param <T extends Meal> meal entity
 */
public abstract class AbstractDAO<K, T extends Meal> {
    
    protected ConnectionPool connectionPool = new ConnectionPool();
    
    public abstract List<T> findAllMeal();
    
    public abstract boolean createMeal(T entity);
    
    public abstract boolean deleteMeal(T entity);
    
    public abstract boolean deleteMeal(int id);
    
    public abstract boolean updateMeal(T entity);
}
