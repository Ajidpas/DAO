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
public class User extends Person {
    
    /** user account */
    private BigDecimal account;
    
    /** zone id */
    private int zoneId;

    /**
     * Constructor
     * @param id user id
     * @param firstName user first name
     * @param lastName user last name
     * @param email user email
     * @param account user account
     * @param zoneId user zone id
     */
    public User(int id, String firstName, String lastName, String email, 
            BigDecimal account, int zoneId) {
        super(id, firstName, lastName, email);
        this.account = account;
        this.zoneId = zoneId;
    }

    /**
     * Get user account
     * @return 
     */
    public BigDecimal getAccount() {
        return account;
    }

    /**
     * Get user zone id
     * @return int user zone id
     */
    public int getZoneId() {
        return zoneId;
    }

    /**
     * Set user account
     * @param account user account
     */
    public void setAccount(BigDecimal account) {
        this.account = account;
    }

    /**
     * Set user zone id
     * @param zoneId 
     */
    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }
    
}
