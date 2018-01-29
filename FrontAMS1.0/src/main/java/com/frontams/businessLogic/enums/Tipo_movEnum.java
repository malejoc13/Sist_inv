/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontams.businessLogic.enums;

/**
 *
 * @author Sistemas
 */
public enum Tipo_movEnum {
    
    ENTRADA(1),
    SALIDA(2),
    TRANSFERENCIA(3),
    AJUSTE(4);

    public int code;

    private Tipo_movEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
    
}
