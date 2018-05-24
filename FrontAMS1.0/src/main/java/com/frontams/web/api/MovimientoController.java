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
import com.frontams.persistence.manager.MovimientoManager;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alejo
 */
@RestController
@RequestMapping(value = "/{pageId}/movimiento")
public class MovimientoController extends AbstractController{
    
    @Autowired
    protected MovimientoManager movimientoManager;
    
   @Override
    public AbstractManager getAbstractManager() {
        return movimientoManager;
    }
    
    @Override
    public AbstractManager getReportManager(){
      return movimientoManager;
  }
    
}
