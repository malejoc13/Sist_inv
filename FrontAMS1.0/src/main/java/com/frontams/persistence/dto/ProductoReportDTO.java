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
public class ProductoReportDTO implements Serializable{
    
    public ProductoReportDTO(){
    
    }
        
    private String clave;
    
    private String name;
    
    private String descripcion;
    
    private String un_medida;
    
    private String tipo_prod;

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
     * @return the un_medida
     */
    public String getUn_medida() {
        return un_medida;
    }

    /**
     * @param un_medida the un_medida to set
     */
    public void setUn_medida(String un_medida) {
        this.un_medida = un_medida;
    }

    /**
     * @return the tipo_prod
     */
    public String getTipo_prod() {
        return tipo_prod;
    }

    /**
     * @param tipo_prod the tipo_prod to set
     */
    public void setTipo_prod(String tipo_prod) {
        this.tipo_prod = tipo_prod;
    }

}
