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

public class Un_medidaDTO implements Serializable{
    
    public Un_medidaDTO() {
    }
    
    private Long id;
    
    private String nombre_um;

    private String descipcion_um;

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
     * @return the nombre_um
     */
    public String getNombre_um() {
        return nombre_um;
    }

    /**
     * @param nombre_um the nombre_um to set
     */
    public void setNombre_um(String nombre_um) {
        this.nombre_um = nombre_um;
    }

    /**
     * @return the descipcion_um
     */
    public String getDescipcion_um() {
        return descipcion_um;
    }

    /**
     * @param descipcion_um the descipcion_um to set
     */
    public void setDescipcion_um(String descipcion_um) {
        this.descipcion_um = descipcion_um;
    }
    
    
}
