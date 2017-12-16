/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontams.persistence.security.dto;

/**
 *
 * @author Sistemas
 */
import java.io.Serializable;

public class Page_accessDTO implements Serializable{
    
    private Long id;

    private String name;
    
    private String idPage;
  
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
   
}
