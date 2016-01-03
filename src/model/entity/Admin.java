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
    
    /** admin type */
    private AdminType adminType;
    
    /**
     * Constructor
     * @param id admin id
     * @param firstName admin first name
     * @param lastName admin last name
     * @param email admin email
     * @param adminType ordinary admin or super admin
     */
    public Admin(int id, String firstName, String lastName, String email, AdminType adminType) {
        super(id, firstName, lastName, email);
        this.adminType = adminType;
    }
    
    /**
     * Set admin type
     * @param adminType admin type
     */
    public void setAdminType(AdminType adminType) {
        this.adminType = adminType;
    }
    
    /**
     * Get admin type
     * @return admin type
     */
    public AdminType getAdminType() {
        return adminType;
    }
    
    /**
     * Class admin type
     */
    enum AdminType {
        ORDINARY_ADMIN,
        SUPER_ADMIN
    }
}
