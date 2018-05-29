/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontams.persistence.security.model;

/**
 *
 * @author Sistemas
 */

import com.frontams.common.model.BaseEntity;
import com.frontams.persistence.model.Unidad;
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
@Table(name = "pageaccess", schema = "security")
@XmlRootElement
public class Page_access extends BaseEntity{
    
   public Page_access(){}
   
    @Id
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
    @SequenceGenerator(name = "pk_page_access", sequenceName = "pageaccess_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_page_access")
    @Generated(GenerationTime.INSERT)
    private Long id;

    @Column(name="nombre")
    private String name;

    private String idPage;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "page_access")
    private List<RolePage_access> role_pages_access;

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
     * @return the idPage
     */
    public String getIdPage() {
        return idPage;
    }

    /**
     * @param idPage the idPage to set
     */
    public void setIdPage(String idPage) {
        this.idPage = idPage;
    }

    /**
     * @return the role_pages_access
     */
    public List<RolePage_access> getRole_pages_access() {
        return role_pages_access;
    }

    /**
     * @param role_pages_access the role_pages_access to set
     */
    public void setRole_pages_access(List<RolePage_access> role_pages_access) {
        this.role_pages_access = role_pages_access;
    }
  
}
