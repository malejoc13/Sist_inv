/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontams.persistence.dto;

/**
 *
 * @author Sistemas
 */

import java.io.Serializable;
import java.util.Date;
public class CompraDTO implements Serializable{
    
    public CompraDTO(){
    
    }
    
    private Long id;
    
    private String descripcion;
    
    private Date fecha_compra;
    
    private String user;
    private Long userId;

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
     * @return the fecha_compra
     */
    public Date getFecha_compra() {
        return fecha_compra;
    }

    /**
     * @param fecha_compra the fecha_compra to set
     */
    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    
    
}
