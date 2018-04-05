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
public class InventarioDTO implements Serializable{
    
    public InventarioDTO(){
    
    }
    
    private Long id;
    
    private Double cantidad;
    
    private Double saldo_ini;
    
    private Date fecha_ini;
    
    private Date fecha;
    
    private String producto;
    private String descripcion;
    private String productoClave;
    private String productoClaveSat;
    private Long productoId;
    private Double precio_max;    
    private Double precio_min;
    
    private String umClave;
    private String umNombre;
    
    private String unidad;
    private Long unidadId;
    
    private Integer rotacion;

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
     * @return the saldo_ini
     */
    public Double getSaldo_ini() {
        return saldo_ini;
    }

    /**
     * @param saldo_ini the saldo_ini to set
     */
    public void setSaldo_ini(Double saldo_ini) {
        this.saldo_ini = saldo_ini;
    }

    /**
     * @return the fecha_ini
     */
    public Date getFecha_ini() {
        return fecha_ini;
    }

    /**
     * @param fecha_ini the fecha_ini to set
     */
    public void setFecha_ini(Date fecha_ini) {
        this.fecha_ini = fecha_ini;
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
     * @return the productoClaveSat
     */
    public String getProductoClaveSat() {
        return productoClaveSat;
    }

    /**
     * @param productoClaveSat the productoClaveSat to set
     */
    public void setProductoClaveSat(String productoClaveSat) {
        this.productoClaveSat = productoClaveSat;
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
     * @return the rotacion
     */
    public Integer getRotacion() {
        return rotacion;
    }

    /**
     * @param rotacion the rotacion to set
     */
    public void setRotacion(Integer rotacion) {
        this.rotacion = rotacion;
    }

    /**
     * @return the precio_max
     */
    public Double getPrecio_max() {
        return precio_max;
    }

    /**
     * @param precio_max the precio_max to set
     */
    public void setPrecio_max(Double precio_max) {
        this.precio_max = precio_max;
    }

    /**
     * @return the precio_min
     */
    public Double getPrecio_min() {
        return precio_min;
    }

    /**
     * @param precio_min the precio_min to set
     */
    public void setPrecio_min(Double precio_min) {
        this.precio_min = precio_min;
    }
    
    
    
}
