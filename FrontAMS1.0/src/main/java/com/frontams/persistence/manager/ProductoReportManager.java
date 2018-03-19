/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontams.persistence.manager;

/**
 *
 * @author Sistemas
 */
import com.frontams.common.dao.AbstractBaseDAO;
import com.frontams.common.manager.AbstractManager; 
import com.frontams.persistence.dao.ProductoReportDAO;
import com.frontams.persistence.dto.ProductoReportDTO;

import com.frontams.persistence.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductoReportManager extends AbstractManager<Producto, ProductoReportDTO>{
    
    @Autowired
    private ProductoReportDAO productoReportDAO;    
   
      
    @Override
    public AbstractBaseDAO dao() {
        return productoReportDAO;
    }
    
}
