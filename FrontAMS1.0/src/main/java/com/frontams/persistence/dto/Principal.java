/*
 @Autor: Roberto Rodriguez
 Email: robertoSoftwareEngineer@gmail.com

 @Copyright 2016 
 */
package com.frontams.persistence.dto;

import java.io.Serializable;

/**
 *
 * @author rrodriguez
 * clase para guardar los atributos de la sesion de manera gloval
 */
public class Principal implements Serializable{

    public static final String PRINCIPAL = "PRINCIPAL";
    public static final String TOKEN = "TOKEN";

    private Long id;
    private Long entityId;
    private String unidad;
    
    private String name;
    private String lastName;
    private Long roleId;
    private Boolean accessAll;
    private String token;
 
 

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
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the accessAll
     */
    public Boolean getAccessAll() {
        return accessAll;
    }

    /**
     * @param accessAll the accessAll to set
     */
    public void setAccessAll(Boolean accessAll) {
        this.accessAll = accessAll;
    }
 

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the unidadId
     */
    public Long getEntityId() {
        return entityId;
    }

    /**
     * @param entityId the unidadId to set
     */
    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    /**
     * @return the unidad
     */
    public String getUnidad() {
        return unidad;
    }

    /**
     * @param unidad the unidad to set
     */
    public void setUnidad(String unidad) {
        this.unidad = unidad;
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

  
}
