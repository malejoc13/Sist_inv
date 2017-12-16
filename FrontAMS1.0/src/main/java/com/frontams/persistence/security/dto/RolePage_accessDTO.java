/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontams.persistence.security.dto;

/**
 *
 * @author Sistemas
 */
import java.io.Serializable;

public class RolePage_accessDTO implements Serializable{
    
    private Long id;
    private String role;
    private Long roleId;
    private String page_access;
    private Long page_accessId;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the roleId
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * @param roleId the roleId to set
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * @return the page_access
     */
    public String getPage_access() {
        return page_access;
    }

    /**
     * @param page_access the page_access to set
     */
    public void setPage_access(String page_access) {
        this.page_access = page_access;
    }

    /**
     * @return the page_accessId
     */
    public Long getPage_accessId() {
        return page_accessId;
    }

    /**
     * @param page_accessId the page_accessId to set
     */
    public void setPage_accessId(Long page_accessId) {
        this.page_accessId = page_accessId;
    }
    
    
}
