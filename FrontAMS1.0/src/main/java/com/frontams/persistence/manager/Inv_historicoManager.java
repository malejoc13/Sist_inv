/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontams.persistence.manager;

import com.frontams.common.dao.AbstractBaseDAO;
import com.frontams.common.manager.AbstractManager;
import com.frontams.persistence.dao.Inv_historicoDAO;
import com.frontams.persistence.dao.InventarioDAO;
import com.frontams.persistence.dto.Inv_historicoDTO;
import com.frontams.persistence.model.Inv_historico;
import com.frontams.persistence.model.Inventario;
import com.frontams.persistence.security.dto.Principal;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sistemas
 */
@Service
@Transactional
public class Inv_historicoManager extends AbstractManager<Inv_historico, Inv_historicoDTO>{
    
    @Autowired
    private Inv_historicoDAO inventario_histDAO;
    
    @Autowired
    private InventarioDAO inventarioDAO;
    
    @Override
    public AbstractBaseDAO dao() {
        return inventario_histDAO;
    }
    
    @Override
    protected Inv_historico create(Map<String, Object> data, Principal principal) throws Exception {
        Inv_historico in = new Inv_historico();
            update(in, data, principal);
        
        return in;
    }

    @Override
    protected void update(Inv_historico entity, Map<String, Object> data, Principal principal) { 
       
        entity.setCantidad_new((Double) data.get("cantidad_new"));
        entity.setCantidad_old((Double) data.get("cantidad_old"));
        entity.setFecha((Date) data.get("fecha"));
                
        Inventario inv = inventarioDAO.findById((Long) data.get("inventarioId"));
        entity.setInventario(inv);
    }
    
}
