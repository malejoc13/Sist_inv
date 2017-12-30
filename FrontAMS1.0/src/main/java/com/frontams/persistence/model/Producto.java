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
@Table(name = "producto", schema = "persistence")
@XmlRootElement

public class Producto extends BaseEntity {

   public Producto() {
    }
    @Id
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "producto_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @Generated(GenerationTime.INSERT)
    private Long id;
    
    private String name;
    
    private String clave;

    private String descripcion;

    private Date fecha_alta;

    private Double precio_max;
    
    private Double precio_min;
    
    private Double precio_costo;
    
    @ManyToOne
    @JoinColumn(name = "un_medida")
    private Un_medida un_medida;
    
    @ManyToOne
    @JoinColumn(name = "tipo_prod")
    private Tipo_prod tipo_prod;
    
    @ManyToOne
    @JoinColumn(name = "proveedor")
    private Proveedor proveedor;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "producto")
    private List<Inventario> inventario;
    
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
     * @return the fecha_ata
     */
    public Date getFecha_alta() {
        return fecha_alta;
    }

    /**
     * @param fecha_ata the fecha_ata to set
     */
    public void setFecha_alta(Date fecha_ata) {
        this.fecha_alta = fecha_ata;
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
    public Un_medida getUn_medida() {
        return un_medida;
    }

    /**
     * @param un_medida the un_medida to set
     */
    public void setUn_medida(Un_medida un_medida) {
        this.un_medida = un_medida;
    }

    /**
     * @return the tipo_prod
     */
    public Tipo_prod getTipo_prod() {
        return tipo_prod;
    }

    /**
     * @param tipo_prod the tipo_prod to set
     */
    public void setTipo_prod(Tipo_prod tipo_prod) {
        this.tipo_prod = tipo_prod;
    }

    /**
     * @return the proveedor
     */
    public Proveedor getProveedor() {
        return proveedor;
    }

    /**
     * @param proveedor the proveedor to set
     */
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
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
     * @return the inventario
     */
    public List<Inventario> getInventario() {
        return inventario;
    }

    /**
     * @param inventario the inventario to set
     */
    public void setInventario(List<Inventario> inventario) {
        this.inventario = inventario;
    }
    
    
    
}
