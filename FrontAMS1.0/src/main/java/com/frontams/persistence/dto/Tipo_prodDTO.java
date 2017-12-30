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
public class Tipo_prodDTO implements Serializable{
    
    public Tipo_prodDTO() {}
        
    private Long id;
    
    private String name;
    
    private String descripcion;

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
     * @return the descrip€cion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descrip€cion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   
    
}
