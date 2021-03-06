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
import com.frontams.persistence.dao.InventarioReportDAO;

import com.frontams.persistence.dao.ProductoDAO;
import com.frontams.persistence.dao.UnidadDAO;
import com.frontams.persistence.dto.InventarioReportDTO;

import com.frontams.persistence.model.Inventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InventarioReportManager extends AbstractManager<Inventario, InventarioReportDTO>{
    
    @Autowired
    private InventarioReportDAO inventarioReportDAO;
          
    @Override
    public AbstractBaseDAO dao() {
        return inventarioReportDAO;
    }
    
}
