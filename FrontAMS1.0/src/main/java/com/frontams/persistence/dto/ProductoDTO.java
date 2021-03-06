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
public class ProductoDTO implements Serializable{
    
    
    public ProductoDTO(){
    
    }
    
    private Long id;
    
    private String name;
    
    private String clave;
     
    private String clave_sat;

    private String descripcion;

    private Date fecha_alta;

    private Double precio_max;
    
    private Double precio_min;
    
    private Double precio_costo;
    //atributos de las clases con que se relaciona
    private String un_medida;
    private Long un_medidaId;
    private String un_medidaClave;
    
    private String tipo_prod;
    private Long tipo_prodId;
    
    private String proveedor;
    private Long proveedorId;
    private String tipo_prodClave;

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
     * @return the un_medidaClave
     */
    public String getUn_medidaClave() {
        return un_medidaClave;
    }

    /**
     * @param un_medidaClave the un_medidaClave to set
     */
    public void setUn_medidaClave(String un_medidaClave) {
        this.un_medidaClave = un_medidaClave;
    }

    /**
     * @return the tipo_prodClave
     */
    public String getTipo_prodClave() {
        return tipo_prodClave;
    }

    /**
     * @param tipo_prodClave the tipo_prodClave to set
     */
    public void setTipo_prodClave(String tipo_prodClave) {
        this.tipo_prodClave = tipo_prodClave;
    }

    /**
     * @return the clave_sat
     */
    public String getClave_sat() {
        return clave_sat;
    }

    /**
     * @param clave_sat the clave_sat to set
     */
    public void setClave_sat(String clave_sat) {
        this.clave_sat = clave_sat;
    }
    
    
}
