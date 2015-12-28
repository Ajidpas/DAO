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
    
    public abstract List<T> findAll() throws ServerOverloadedException;
    
    public abstract boolean create(T entity) throws ServerOverloadedException;
    
    public abstract boolean delete(T entity) throws ServerOverloadedException;
    
    public abstract boolean delete(int id) throws ServerOverloadedException;
    
    public abstract boolean update(T entity) throws ServerOverloadedException;
}
