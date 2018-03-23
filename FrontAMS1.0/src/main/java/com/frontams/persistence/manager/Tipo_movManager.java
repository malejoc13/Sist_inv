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
import com.frontams.persistence.dao.Tipo_movDAO;
import com.frontams.persistence.dto.Tipo_movDTO;
import com.frontams.persistence.model.Tipo_mov;

import com.frontams.persistence.security.dto.Principal;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Tipo_movManager extends AbstractManager<Tipo_mov, Tipo_movDTO>{
    
    @Autowired
    private Tipo_movDAO tipo_movDAO;
      
    @Override
    public AbstractBaseDAO dao() {
        return tipo_movDAO;
    }
    
    @Override
    protected Tipo_mov create(Map<String, Object> data, Principal principal) throws Exception {
        Tipo_mov tp = new Tipo_mov(); 
        update(tp, data, principal);

        return tp;
    }

    @Override
    protected void update(Tipo_mov entity, Map<String, Object> data, Principal principal) { 
        entity.setName((String) data.get("name"));
        entity.setDescripcion((String) data.get("descripcion"));
        
    }
    
     @Override
    protected boolean inUse(Tipo_mov entity) { 
        if (entity.getMovimiento().isEmpty()) {
             return false;
        }
        System.out.println("lista llena...");
        return true;
    }
    
     @Override
     protected WebResponseData del(Tipo_mov entity, Principal principal) throws Exception{ 
        if (!inUse(entity)) {                
            dao().delete(entity);
            return new WebResponseData();
        }       
         return new WebResponseData(450, "El tipo de movimiento "+entity.getName()+" no se puede eliminar, existen movimientos asociados a este");
     }
    
}
