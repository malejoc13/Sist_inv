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
public class Mov_prodDTO implements Serializable{
    
    public Mov_prodDTO(){}
    
    private Long id;
    
    private Double cantidad;
    
    private Double saldo_prod;
    
    private String movimiento;
    private Long movimientoId;
    
    private String producto;
    private String descripcion;
    private String productoClave;
    private Long productoId;

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
     * @return the saldo_prod
     */
    public Double getSaldo_prod() {
        return saldo_prod;
    }

    /**
     * @param saldo_prod the saldo_prod to set
     */
    public void setSaldo_prod(Double saldo_prod) {
        this.saldo_prod = saldo_prod;
    }

    /**
     * @return the movimiento
     */
    public String getMovimiento() {
        return movimiento;
    }

    /**
     * @param movimiento the movimiento to set
     */
    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    /**
     * @return the movimientoId
     */
    public Long getMovimientoId() {
        return movimientoId;
    }

    /**
     * @param movimientoId the movimientoId to set
     */
    public void setMovimientoId(Long movimientoId) {
        this.movimientoId = movimientoId;
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
    
}
