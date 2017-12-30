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
import com.frontams.common.util.response.WebResponseData;
import com.frontams.persistence.dao.InventarioDAO;
import com.frontams.persistence.dao.ProductoDAO;
import com.frontams.persistence.dao.UnidadDAO;
import com.frontams.persistence.dto.InventarioDTO;
import com.frontams.persistence.dto.Principal;
import com.frontams.persistence.model.Inventario;
import java.util.Map;
import org.mockito.cglib.beans.BulkBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InventarioManager extends AbstractManager<Inventario, InventarioDTO>{
    
    @Autowired
    private InventarioDAO inventarioDAO;
    
    @Autowired
    private ProductoDAO productoDAO;
    
    @Autowired
    private UnidadDAO unidad;
      
    @Override
    public AbstractBaseDAO dao() {
        return inventarioDAO;
    }
    
    
}
