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

public class InventarioReportDTO implements Serializable{
    
     public InventarioReportDTO(){
    
    }
    
    private Double cantidad; 
    
    private String producto;
    private String prodDescr;
    private String productoClave;
    
    private String tipo_prod;
    
    private String umNombre;
    
    private String unidad;

    /**
     * @return the producto
     */
    public String getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * @return the productoClave
     */
    public String getProductoClave() {
        return productoClave;
    }

    /**
     * @param productoClave the productoClave to set
     */
    public void setProductoClave(String productoClave) {
        this.productoClave = productoClave;
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
     * @return the cantidad
     */
    public Double getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the prodDescr
     */
    public String getProdDescr() {
        return prodDescr;
    }

    /**
     * @param prodDescr the prodDescr to set
     */
    public void setProdDescr(String prodDescr) {
        this.prodDescr = prodDescr;
    }

    /**
     * @return the umNombre
     */
    public String getUmNombre() {
        return umNombre;
    }

    /**
     * @param umNombre the umNombre to set
     */
    public void setUmNombre(String umNombre) {
        this.umNombre = umNombre;
    }
    
    
    
}
