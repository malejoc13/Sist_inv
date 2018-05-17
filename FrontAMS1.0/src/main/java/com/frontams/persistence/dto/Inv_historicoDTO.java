/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontams.persistence.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Sistemas
 */
public class Inv_historicoDTO implements Serializable{
    
    public Inv_historicoDTO(){
    
    }
    
    private Long id;
    
    private Date fecha;
    
    private Double cantidad_old;
    
    private Double cantidad_new;
    
    private Long inventarioId;
    
    private String producto;
    private String descripcion;
    private String productoClave;
    
    private String umClave;
    private String umNombre;
    
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
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the cantidad_old
     */
    public Double getCantidad_old() {
        return cantidad_old;
    }

    /**
     * @param cantidad_old the cantidad_old to set
     */
    public void setCantidad_old(Double cantidad_old) {
        this.cantidad_old = cantidad_old;
    }

    /**
     * @return the cantidad_new
     */
    public Double getCantidad_new() {
        return cantidad_new;
    }

    /**
     * @param cantidad_new the cantidad_new to set
     */
    public void setCantidad_new(Double cantidad_new) {
        this.cantidad_new = cantidad_new;
    }

    /**
     * @return the inventarioId
     */
    public Long getInventarioId() {
        return inventarioId;
    }

    /**
     * @param inventarioId the inventarioId to set
     */
    public void setInventarioId(Long inventarioId) {
        this.inventarioId = inventarioId;
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
     * @return the umClave
     */
    public String getUmClave() {
        return umClave;
    }

    /**
     * @param umClave the umClave to set
     */
    public void setUmClave(String umClave) {
        this.umClave = umClave;
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
    
    
}
