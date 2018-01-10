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
    private Boolean creat;    
    private Boolean upd;    
    private Boolean delt;
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

    /**
     * @return the creat
     */
    public Boolean getCreat() {
        return creat;
    }

    /**
     * @param creat the creat to set
     */
    public void setCreat(Boolean creat) {
        this.creat = creat;
    }

    /**
     * @return the upd
     */
    public Boolean getUpd() {
        return upd;
    }

    /**
     * @param upd the upd to set
     */
    public void setUpd(Boolean upd) {
        this.upd = upd;
    }

    /**
     * @return the delt
     */
    public Boolean getDelt() {
        return delt;
    }

    /**
     * @param delt the delt to set
     */
    public void setDelt(Boolean delt) {
        this.delt = delt;
    }

   
}
