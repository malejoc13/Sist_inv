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
import com.frontams.persistence.security.dto.Principal;
import com.frontams.persistence.model.Inventario;
import com.frontams.persistence.model.Producto;
import com.frontams.persistence.model.Unidad;
import java.util.Date;
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
    private UnidadDAO unidadDAO;
      
    @Override
    public AbstractBaseDAO dao() {
        return inventarioDAO;
    }
    
    @Override
    protected Inventario create(Map<String, Object> data) throws Exception {
        Inventario tp = new Inventario(); 
        if (inventarioDAO.exist((Long) data.get("productoId"), (Long) data.get("unidadId"))) {
            throw new RuntimeException("Ya tiene este producto en inventario");
        } else {
            System.out.println("InventarioManager -> creating...");
            update(tp, data);
        }
        return tp;
    }

    @Override
    protected void update(Inventario entity, Map<String, Object> data) { 
       
        if (entity.getCantidad() != null && entity.getCantidad() < (Double) data.get("cantidad")) {
            throw new RuntimeException("Est&aacute; intentando rebajar una cantidad mayor a ("+entity.getCantidad()+") que es la existente en el inventario" );
        }
        entity.setCantidad((Double) data.get("cantidad"));
        entity.setSaldo_ini((Double) data.get("saldo_ini"));
        entity.setFecha_ini((Date) data.get("fecha_ini"));
        entity.setFecha((Date) data.get("fecha"));
                
        Producto prod = productoDAO.findById((Long) data.get("productoId"));
        Unidad unidad = unidadDAO.findById((Long) data.get("unidadId"));
        
        entity.setProducto(prod);      
        entity.setUnidad(unidad);
    }
    
    
    
}
