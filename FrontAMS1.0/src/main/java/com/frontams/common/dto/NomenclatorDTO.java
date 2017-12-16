/*
 @Autor: Roberto Rodriguez
 Email: robertoSoftwareEngineer@gmail.com

 @Copyright 2016 
 */
package com.frontams.common.dto;

/**
 *
 * @author rrodriguez
 */
public class NomenclatorDTO {
    private Long id;
    private String name;

    public NomenclatorDTO() {
    }

    public NomenclatorDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    
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
}
