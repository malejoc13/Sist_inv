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
@Table(name = "movimiento", schema = "persistence")
@XmlRootElement
public class Movimiento extends BaseEntity{
    
    public Movimiento(){}
    
    @Id
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "movimiento_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @Generated(GenerationTime.INSERT)
    private Long id;
    
    private Double saldo;
    
    private Date fecha;
    
    private String descripcion;
    /*tipo_mov:
    1 Entradas
    2 Salidas
    3 Transferencias
    4 Ajustes*/
    private Integer tipo_mov;
    
//    @ManyToOne
//    @JoinColumn(name = "tipo_mov")
//    private Tipo_mov tipo_mov;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movimiento")
    private List<Mov_prod> mov_prod;

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
     * @return the mov_prod
     */
    public List<Mov_prod> getMov_prod() {
        return mov_prod;
    }

    /**
     * @param mov_prod the mov_prod to set
     */
    public void setMov_prod(List<Mov_prod> mov_prod) {
        this.mov_prod = mov_prod;
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
    
    
    
}
