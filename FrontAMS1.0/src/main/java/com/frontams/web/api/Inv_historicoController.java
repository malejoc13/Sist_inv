/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontams.web.api;

import com.frontams.common.controller.AbstractController;
import com.frontams.common.manager.AbstractManager;
import com.frontams.persistence.manager.Inv_historicoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sistemas
 */
@RestController
@RequestMapping(value = "/{pageId}/inv_historico")
public class Inv_historicoController extends AbstractController{
    
    @Autowired
    protected Inv_historicoManager inventario_histManager;

    
    @Override
    public AbstractManager getAbstractManager() {
        return inventario_histManager;
    }
    
    @Override
    public AbstractManager getReportManager(){
      return inventario_histManager;
  }
}
