/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontams.persistence.model;

/**
 *
 * @author Sistemas
 */

import com.frontams.common.model.BaseEntity;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "inventario", schema = "persistence")
@XmlRootElement
public class Inventario extends BaseEntity{
    
    public Inventario(){}
    
    @Id
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "invenario_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @Generated(GenerationTime.INSERT)
    private Long id;
    
    private Integer cantidad;
    
    private Integer saldo_ini;
    
    private Date fecha_ini;
    
    private Date fecha;
    
    @ManyToOne
    @JoinColumn(name = "producto")
    private Producto producto;
    
    @ManyToOne
    @JoinColumn(name = "unidad")
    private Unidad unidad;

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
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the saldo_ini
     */
    public Integer getSaldo_ini() {
        return saldo_ini;
    }

    /**
     * @param saldo_ini the saldo_ini to set
     */
    public void setSaldo_ini(Integer saldo_ini) {
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
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * @return the unidad
     */
    public Unidad getUnidad() {
        return unidad;
    }

    /**
     * @param unidad the unidad to set
     */
    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }
    
    
}
