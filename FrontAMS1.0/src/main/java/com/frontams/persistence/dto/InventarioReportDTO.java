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
    
    private Long id;
    
    private Double cantidad; 
    
    private String producto;
    private String productoClave;
    private Long productoId;
    
    private String tipo_prod;
    
    private String unidad;
    private Long unidadId;

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
     * @return the productoId
     */
    public Long getProductoId() {
        return productoId;
    }

    /**
     * @param productoId the productoId to set
     */
    public void setProductoId(Long productoId) {
        this.productoId = productoId;
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
     * @return the unidadId
     */
    public Long getUnidadId() {
        return unidadId;
    }

    /**
     * @param unidadId the unidadId to set
     */
    public void setUnidadId(Long unidadId) {
        this.unidadId = unidadId;
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
    
    
    
}
