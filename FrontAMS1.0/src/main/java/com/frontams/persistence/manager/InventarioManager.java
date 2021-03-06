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
import com.frontams.persistence.dao.Inv_historicoDAO;
import com.frontams.persistence.dao.InventarioDAO;
import com.frontams.persistence.dao.ProductoDAO;
import com.frontams.persistence.dao.UnidadDAO;
import com.frontams.persistence.dto.InventarioDTO;
import com.frontams.persistence.model.Inv_historico;
import com.frontams.persistence.security.dto.Principal;
import com.frontams.persistence.model.Inventario;
import com.frontams.persistence.model.Producto;
import com.frontams.persistence.model.Unidad;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
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
    private Inv_historicoDAO inventario_histDAO;
    
    @Autowired
    private ProductoDAO productoDAO;
    
    @Autowired
    private UnidadDAO unidadDAO;
    
    private Double cantidad_old = 0.0;
      
    @Override
    public AbstractBaseDAO dao() {
        return inventarioDAO;
    }
    
    @Override
    protected Inventario create(Map<String, Object> data, Principal principal) throws Exception {
        Inventario entity = new Inventario(); 
       
        if (inventarioDAO.exist((Long) data.get("productoId"), (Long) data.get("unidadId"))) {
            throw new RuntimeException("Ya tiene este producto en inventario");
        } else {
            System.out.println("InventarioManager -> creating...");
            upd(entity, data);
            entity.setRotacion(0);
        }
        return entity;
    }

    @Override
    protected void update(Inventario entity, Map<String, Object> data, Principal principal) { 
        cantidad_old = entity.getCantidad();
        if ((Boolean) data.get("rotate")) {
            System.out.println("Rotating...");
            rotate(entity);            
        }
        
        if (principal.getAccessAll()) {            
            upd(entity, data);
        }else {
            if (entity.getCantidad() <= (Double) data.get("cantidad")) {
                throw new RuntimeException("Est&aacute; intentando rebajar una cantidad mayor o igual a ("+entity.getCantidad()+") que es la existente en el inventario" );
            }
            upd(entity, data);
        }   
    }
    
    private void upd(Inventario entity, Map<String, Object> data){
        entity.setCantidad((Double) data.get("cantidad"));
        entity.setSaldo_ini((Double) data.get("saldo_ini"));
        entity.setFecha_ini((Date) data.get("fecha_ini"));
        entity.setFecha((Date) data.get("fecha"));
                
        Producto prod = productoDAO.findById((Long) data.get("productoId"));
        Unidad unidad = unidadDAO.findById((Long) data.get("unidadId"));
        
        entity.setProducto(prod);      
        entity.setUnidad(unidad);
    }
    
    @Override
    protected void afterCreate(Inventario entity){
        Inv_historico inv_hist = new Inv_historico();
        System.out.println("InventarioHistoricoManager -> creating...");
        inv_hist.setCantidad_new(entity.getCantidad());
        inv_hist.setCantidad_old(cantidad_old);
        inv_hist.setFecha(entity.getFecha());
        inv_hist.setInventario(entity);
        
        inv_hist = inventario_histDAO.saveOrUpdate(inv_hist);
        cantidad_old = 0.0;
    }
    
    private void rotate(Inventario entity){
        entity.setRotacion(entity.getRotacion()+1);    
    }
    
    @Override
    protected boolean inUse(Inventario entity) { 
        if (entity.getInv_historico().isEmpty()) {
             return false;
        }
        //entity.getInv_historico().remove(1);
        System.out.println("lista llena..."+entity.getInv_historico().size());
        return true;  
    }
    
    @Override
     protected WebResponseData del(Inventario entity, Principal principal) throws Exception{ 
        //if (!inUse(entity)) {                
            dao().delete(entity);
            
            return new WebResponseData();
        //}       
        // return new WebResponseData(450, "No se puede eliminar esta entrada del inventario, exiten históricos asociados a él");
     }
}
