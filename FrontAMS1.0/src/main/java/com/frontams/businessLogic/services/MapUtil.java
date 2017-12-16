/*
 @Autor: Roberto Rodriguez
 Email: robertoSoftwareEngineer@gmail.com

 @Copyright 2016 
 */
package com.frontams.businessLogic.services;

import java.util.LinkedHashMap;

/**
 *
 * @author rrodriguez
 */
public class MapUtil {

    public static String mapString(LinkedHashMap data, String name, boolean required) {
        if (data.containsKey(name)) {
            String val = (String) data.get(name);

            if (required && (val == null || val.isEmpty())) {
                throw new IllegalArgumentException(name + " can not be empty.");
            } else {
                return val;
            }
        } else {
            if (required) {
                throw new IllegalArgumentException(name + " can not be empty.");
            }
        }
        return "";
    }
    

    public static Double mapDouble(LinkedHashMap data, String name, boolean required) {
        if (data.containsKey(name)) {
            String doubleString = (String) data.get(name);
            return Double.parseDouble(doubleString);
        } else {
            if (required) {
                throw new IllegalArgumentException(name + " can not be empty.");
            }
        }
        return null;
    }

    public static Long mapLong(LinkedHashMap data, String name, boolean required) {
        if (data.containsKey(name)) {
            String doubleString = (String) data.get(name);
            return Long.parseLong(doubleString);
        } else {
            if (required) {
                throw new IllegalArgumentException(name + " can not be empty.");
            }
        }
        return null;
    }
}
