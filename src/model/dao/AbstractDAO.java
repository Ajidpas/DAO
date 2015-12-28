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
    
    protected static final ConnectionPool CONNECTION_POOL = new ConnectionPool();
    
    public abstract List<T> findAllMeal() throws ServerOverloadedException;
    
    public abstract boolean createMeal(T entity) throws ServerOverloadedException;
    
    public abstract boolean deleteMeal(T entity) throws ServerOverloadedException;
    
    public abstract boolean deleteMeal(int id) throws ServerOverloadedException;
    
    public abstract boolean updateMeal(T entity) throws ServerOverloadedException;
}
