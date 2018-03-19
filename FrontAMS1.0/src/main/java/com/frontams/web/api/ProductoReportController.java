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

import com.frontams.persistence.manager.ProductoReportManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/{pageId}/producto_r")
public class ProductoReportController extends AbstractController{
    
    @Autowired
    protected ProductoReportManager productoReportManager;
    
    
    @Override
    public AbstractManager getAbstractManager() {
        return productoReportManager;
    }
    
    @Override
    public AbstractManager getReportManager(){
      return productoReportManager;
  }
    
}
