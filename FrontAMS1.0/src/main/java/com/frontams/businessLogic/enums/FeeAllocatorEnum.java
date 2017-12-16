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
public enum FeeAllocatorEnum {

    PLATFORM(1),
    PROGRAM(2),
    MERCHANT(3),
    DISTRIBUTOR(4);

    public int code;

    private FeeAllocatorEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
