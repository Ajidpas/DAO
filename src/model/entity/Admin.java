/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

/**
 *
 * @author Sasha
 */
public class Admin extends Person {

    /**
     * Constructor
     * @param id admin id
     * @param firstName admin first name
     * @param lastName admin last name
     * @param email admin email
     */
    public Admin(int id, String firstName, String lastName, String email) {
        super(id, firstName, lastName, email);
    }
    
}
