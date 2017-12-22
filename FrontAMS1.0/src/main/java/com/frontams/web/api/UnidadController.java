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
import com.frontams.persistence.manager.UnidadManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/{pageId}/unidad")
public class UnidadController extends AbstractController{
    
    @Autowired
    protected UnidadManager unidadManager;
 

    @Override
    public AbstractManager getAbstractManager() {
        return unidadManager;
    }
    
    @Override
    public AbstractManager getReportManager(){
      return unidadManager;
  }
    
}
