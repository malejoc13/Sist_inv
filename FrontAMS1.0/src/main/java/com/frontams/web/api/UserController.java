/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontams.web.api;
 
import com.frontams.common.controller.AbstractController;
import com.frontams.common.manager.AbstractManager; 
import com.frontams.persistence.security.manager.UserManager; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Roberto Rodriguez
 */
@RestController
@RequestMapping(value = "/{pageId}/user")
public class UserController extends AbstractController{
    
    @Autowired
    protected UserManager userManager;
     

    @Override
    public AbstractManager getAbstractManager() {
       return userManager;
    }
    
    @RequestMapping(value = "/ping")
    public String checkAccess( @PathVariable("pageId") String pageId) { 
        return "PING";
    }
  
}
 
   
