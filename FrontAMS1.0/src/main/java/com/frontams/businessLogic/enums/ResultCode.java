/*
 @Autor: Roberto Rodriguez
 Email: robertoSoftwareEngineer@gmail.com

 @Copyright 2016 
 */
package com.frontams.businessLogic.enums;

/**
 *
 * @author rrodriguez
 */
public enum ResultCode {
    SUCCESS(1);
    
    private Integer code;

    private ResultCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
    
    
    
    
}
