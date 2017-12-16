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
@Table(name = "role_page_access", schema = "security")
@XmlRootElement
public class RolePage_access extends BaseEntity{
    
    public RolePage_access(){}
    
    @Id
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "role_page_access_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @Generated(GenerationTime.INSERT)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "page_access")
    private Page_access page_access;

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
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * @return the page_access
     */
    public Page_access getPage_access() {
        return page_access;
    }

    /**
     * @param page_access the page_access to set
     */
    public void setPage_access(Page_access page_access) {
        this.page_access = page_access;
    }
    
    
    
}
