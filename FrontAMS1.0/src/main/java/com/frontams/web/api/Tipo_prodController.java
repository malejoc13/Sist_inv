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
import com.frontams.common.controller.AbstractController;
import com.frontams.common.manager.AbstractManager; 
import com.frontams.persistence.manager.Tipo_prodManager;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/{pageId}/tipo_prod")
public class Tipo_prodController  extends AbstractController{
    
    @Autowired
    protected Tipo_prodManager tipo_prodManager;
 

    @Override
    public AbstractManager getAbstractManager() {
        return tipo_prodManager;
    }
    
    @Override
    public AbstractManager getReportManager(){
      return tipo_prodManager;
  }
            
}
