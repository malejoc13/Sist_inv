/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontams.web.security;

/**
 *
 * @author Sistemas
 */
import com.frontams.common.controller.AbstractController;
import com.frontams.common.manager.AbstractManager; 
import com.frontams.persistence.security.manager.RolePage_accessManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/{pageId}/role_page_access")
public class RolePage_accessController extends AbstractController{
    
    @Autowired
    protected RolePage_accessManager rolepageManager;
     

    @Override
    public AbstractManager getAbstractManager() {
       return rolepageManager;
    }
    
    @RequestMapping(value = "/ping")
    public String checkAccess( @PathVariable("pageId") String pageId) { 
        return "PING";
    }
}
