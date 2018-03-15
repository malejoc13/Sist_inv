/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontams.common.dto;

/**
 *
 * @author Sistemas
 */
public class NomenclatorClaveDTO{
    
    private Long id;
    private String name;
    private String clave;
    private String descripcion;
    
    public NomenclatorClaveDTO(){}
    
    public NomenclatorClaveDTO(Long id, String name, String clave){
        this.id = id;
        this.name = name;
        this.clave = clave;
    }
    
    public NomenclatorClaveDTO(Long id, String name, String clave, String descrp){
        this.id = id;
        this.name = name;
        this.clave = clave;
        this.descripcion = descrp;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

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
    
}
