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
public class Order extends DBEntity {
    
    /** order status */
    private OrderStatus orderStatus;
    /** user id */
    private int userId;
    
    /** total price */
    private BigDecimal totalPrice;

    /**
     * Constructor
     * @param orderStatus order status
     * @param id user id
     * @param userId user id
     * @param totalPrice total price
     */
    public Order(int id, OrderStatus orderStatus, int userId, BigDecimal totalPrice) {
        super(id);
        this.orderStatus = orderStatus;
        this.userId = userId;
        this.totalPrice = totalPrice;
    }

    /**
     * Get order status
     * @return order status
     */
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    /**
     * Get user id
     * @return int user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Get total price
     * @return total price
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * Set order status
     * @param orderStatus order status 
     */
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * Set user id
     * @param userId user id 
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Set total price
     * @param totalPrice total price
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    /**
     * Order status
     */
    enum OrderStatus {
        VAITING, PREPARING, READY, PAYED
    }
    
}
