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

public class RoleDTO implements Serializable{
    
    private Long id;

    private String name;

    private String descripcion;
    
    private Boolean access_all;

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the access_all
     */
    public Boolean getAccess_all() {
        return access_all;
    }

    /**
     * @param access_all the access_all to set
     */
    public void setAccess_all(Boolean access_all) {
        this.access_all = access_all;
    }

    
}
