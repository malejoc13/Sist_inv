/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontams.web.api;

/**
 *
 * @author Sistemas
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test", method = RequestMethod.GET)
   
public class TestController {
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() { 
        return "SUCCESS";
    }      
}
