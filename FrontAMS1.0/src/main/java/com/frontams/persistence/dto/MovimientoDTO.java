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
    
    private String tipo_mov;
    private Long tipo_movId;

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
    public String getTipo_mov() {
        return tipo_mov;
    }

    /**
     * @param tipo_mov the tipo_mov to set
     */
    public void setTipo_mov(String tipo_mov) {
        this.tipo_mov = tipo_mov;
    }

    /**
     * @return the tipo_movId
     */
    public Long getTipo_movId() {
        return tipo_movId;
    }

    /**
     * @param tipo_movId the tipo_movId to set
     */
    public void setTipo_movId(Long tipo_movId) {
        this.tipo_movId = tipo_movId;
    }
    
    
    
}
