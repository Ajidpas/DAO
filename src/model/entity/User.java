/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sasha
 */
public class User extends Person {
    
    /** user account */
    private BigDecimal account;
    
    /** zone id */
    private Zone zone;
    
    /** list of user's orders */
    private List<Order> orders;

    /**
     * Constructor
     * @param id user id
     * @param firstName user first name
     * @param lastName user last name
     * @param email user email
     * @param account user account
     * @param zone user zone id
     */
    public User(int id, String firstName, String lastName, String email, 
            BigDecimal account, Zone zone) {
        super(id, firstName, lastName, email);
        this.account = account;
        this.zone = zone;
    }

    /**
     * Get user account
     * @return 
     */
    public BigDecimal getAccount() {
        return account;
    }

    /**
     * Get user zone 
     * @return user zone 
     */
    public Zone getZone() {
        return zone;
    }

    /**
     * Set user account
     * @param account user account
     */
    public void setAccount(BigDecimal account) {
        this.account = account;
    }

    /**
     * Set user zone 
     * @param zone 
     */
    public void setZone(Zone zone) {
        this.zone = zone;
    }
    
    /**
     * Set all user's orders
     * @param orders 
     */
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    
    /**
     * Get orders
     * @return list of orders
     */
    public List<Order> getOrders() {
        return orders;
    }
    
    /**
     * Add order to the user's order list
     * @param order 
     */
    public void addOrder(Order order) {
        if (orders == null) {
            orders = new ArrayList<>();
        }
        orders.add(order);
    }
    
    /**
     * Remove order from user's order list by id
     * @param orderId id of order might be removed
     */
    public void removeOrderById(int orderId) {
        if (orders != null) {
            for (Order order : orders) {
                if (order.id == orderId) {
                    orders.remove(order);
                    break;
                }
            }
        }
    }
    
}
