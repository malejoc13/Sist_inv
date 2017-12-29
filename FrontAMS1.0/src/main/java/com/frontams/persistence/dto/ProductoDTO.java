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
import com.frontams.persistence.model.Un_medida;
import com.frontams.persistence.model.Tipo_prod;
import com.frontams.persistence.model.Proveedor;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ProductoDTO implements Serializable{
    
    private static final DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    
    public ProductoDTO(){
    
    }
    
    private Long id;
    
    private String name;

    private String descripcion;

    private Date fecha_alta;

    private Double precio_max;
    
    private Double precio_min;
    
    private Double precio_costo;
    //atributos de las clases con que se relaciona
    private String un_medida;
    private Long un_medidaId;
    
    private String tipo_prod;
    private Long tipo_prodId;
    
    private String proveedor;
    private Long proveedorId;

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
     * @return the fecha_alta
     */
    public Date getFecha_alta() {
        return fecha_alta;
    }

    /**
     * @param fecha_alta the fecha_alta to set
     */
    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
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

    /**
     * @return the proveedor
     */
    public String getProveedor() {
        return proveedor;
    }

    /**
     * @param proveedor the proveedor to set
     */
    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * @return the un_medidaId
     */
    public Long getUn_medidaId() {
        return un_medidaId;
    }

    /**
     * @param un_medidaId the un_medidaId to set
     */
    public void setUn_medidaId(Long un_medidaId) {
        this.un_medidaId = un_medidaId;
    }

    /**
     * @return the tipo_prodId
     */
    public Long getTipo_prodId() {
        return tipo_prodId;
    }

    /**
     * @param tipo_prodId the tipo_prodId to set
     */
    public void setTipo_prodId(Long tipo_prodId) {
        this.tipo_prodId = tipo_prodId;
    }

    /**
     * @return the proveedorId
     */
    public Long getProveedorId() {
        return proveedorId;
    }

    /**
     * @param proveedorId the proveedorId to set
     */
    public void setProveedorId(Long proveedorId) {
        this.proveedorId = proveedorId;
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
     * @return the precio_costo
     */
    public Double getPrecio_costo() {
        return precio_costo;
    }

    /**
     * @param precio_costo the precio_costo to set
     */
    public void setPrecio_costo(Double precio_costo) {
        this.precio_costo = precio_costo;
    }
    
    
}
