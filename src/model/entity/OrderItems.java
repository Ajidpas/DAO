/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.math.BigDecimal;

/**
 *
 * @author Sasha
 */
public class OrderItems {
    
    /** this item meal id */
    private int mealId;
    
    /** this item order id */
    private int orderId;
    
    /** price of this item */
    private BigDecimal price;
    
    /** number of meals in this item */
    private int number;

    /**
     * COnstructor
     * @param mealId meal id
     * @param orderId order id
     * @param price item price
     * @param number meal number
     */
    public OrderItems(int mealId, int orderId, BigDecimal price, int number) {
        this.mealId = mealId;
        this.orderId = orderId;
        this.price = price;
        this.number = number;
    }

    /**
     * Get meal id
     * @return int meal id
     */
    public int getMealId() {
        return mealId;
    }

    /**
     * Get order id
     * @return int order id
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Get item price
     * @return int item price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Get number of meals of this item
     * @return int number of this item
     */
    public int getNumber() {
        return number;
    }

    /**
     * Set meal in this item
     * @param mealId meal in this item
     */
    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    /**
     * Set order id
     * @param orderId int order id
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Set item price
     * @param price bigdecimal iten price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Set number of meal of this item
     * @param number int number of this item
     */
    public void setNumber(int number) {
        this.number = number;
    }
    
}
