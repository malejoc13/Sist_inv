/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 *
 * This is an automatic generated file. It will be regenerated every time you
 * generate persistence class.
 *
 * Modifying its content may cause the program not work, or your work may lost.
 */
/**
 * Licensee: License Type: Evaluation
 */
package com.frontams.persistence.model;

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
@Table(name = "un_medida", schema = "persistence")
@XmlRootElement
public class Un_medida extends BaseEntity {

    public Un_medida() {
    }
    @Id
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "un_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @Generated(GenerationTime.INSERT)
    private Long id;
    
    private String nombre_um;

    private String descipcion_um;

   @OneToMany(fetch = FetchType.LAZY, mappedBy = "un_medida")
    private List<Producto> productos;

   public Long getId() {
        return id;
    }
    /**
     * @return the nombre_um
     */
    public String getNombre_um() {
        return nombre_um;
    }

    /**
     * @param nombre_um the nombre_um to set
     */
    public void setNombre_um(String nombre_um) {
        this.nombre_um = nombre_um;
    }

    /**
     * @return the descipcion_um
     */
    public String getDescipcion_um() {
        return descipcion_um;
    }

    /**
     * @param descipcion_um the descipcion_um to set
     */
    public void setDescipcion_um(String descipcion_um) {
        this.descipcion_um = descipcion_um;
    }

    /**
     * @return the productos
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

}
