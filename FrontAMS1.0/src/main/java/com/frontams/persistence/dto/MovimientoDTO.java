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
public class MovimientoDTO implements Serializable{
    
    public MovimientoDTO(){}
    
    private Long id;
    
    private Double saldo;
    
    private Date fecha;
    
    private String descripcion;
    
    /*1 Entrada 2 Salida 3 Transferencia 4 Ajustes*/
    private Integer tipo_mov;
    
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
     * @return the saldo
     */
    public Double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
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
     * @return the tipo_mov
     */
    public Integer getTipo_mov() {
        return tipo_mov;
    }

    /**
     * @param tipo_mov the tipo_mov to set
     */
    public void setTipo_mov(Integer tipo_mov) {
        this.tipo_mov = tipo_mov;
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
