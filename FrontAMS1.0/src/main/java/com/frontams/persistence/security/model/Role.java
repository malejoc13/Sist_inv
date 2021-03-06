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
@Table(name = "role", schema = "security")
@XmlRootElement
public class Role extends BaseEntity{
    
     public Role() {
    }
    @Id
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
    @SequenceGenerator(name = "pk_role", sequenceName = "role_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_role")
    private Long id;
    
    @Column(name="nombre")
    private String name;
    
    private String descripcion;
    
    private Boolean access_all;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private List<User> users;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
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
     * @return the users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(List<User> users) {
        this.users = users;
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

    /**
     * @return the access_all
     */
    public Boolean getAccess_all() {
        return access_all;
    }

    /**
     * @param access_all the access_all to set
     */
    public void setAccess_all(Boolean access_all) {
        this.access_all = access_all;
    }

    
}
