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
import com.frontams.persistence.manager.ProveedorManager;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/{pageId}/proveedor")
public class ProveedorController  extends AbstractController{
    
    @Autowired
    protected ProveedorManager proveedorManager;
 

    @Override
    public AbstractManager getAbstractManager() {
        return proveedorManager;
    }
    
    @Override
    public AbstractManager getReportManager(){
      return proveedorManager;
  }
            
}
