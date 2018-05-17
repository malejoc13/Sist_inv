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
@Table(name = "inv_historico", schema = "persistence")
@XmlRootElement
public class Inv_historico extends BaseEntity {
    
    public Inv_historico(){}
    
    @Id
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "inv_historico_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @Generated(GenerationTime.INSERT)
    private Long id;
    
    private Date fecha;
    
    private Double cantidad_old;
    
    private Double cantidad_new;

    /**
     * @return the id
     */
    @Override
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
    
}
