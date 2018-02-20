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
import com.frontams.persistence.dao.Un_medidaDAO;
import com.frontams.persistence.security.dto.Principal;
import com.frontams.persistence.dto.Un_medidaDTO; 
import com.frontams.persistence.model.Un_medida;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Un_medidaManager extends AbstractManager<Un_medida, Un_medidaDTO>{
    
    @Autowired
    private Un_medidaDAO um_DAO;
      
    @Override
    public AbstractBaseDAO dao() {
        return um_DAO;
    }
    
    @Override
    protected Un_medida create(Map<String, Object> data) throws Exception {
        Un_medida um = new Un_medida(); 
        if (um_DAO.exist((String) data.get("clave"))) {
             throw new RuntimeException("Ya existe una Unidad de medida con esta clave");
        } else {
            update(um, data);
        }
        return um;
    }

    @Override
    protected void update(Un_medida entity, Map<String, Object> data) { 
        if (entity.getClave() != null) {
            if (um_DAO.exist((String) data.get("clave")) && !entity.getClave().equals((String) data.get("clave"))) {
                 throw new RuntimeException("Ya existe una Unidad de medida con esta clave");
            }
        }
        entity.setNombre_um((String) data.get("nombre_um"));
        entity.setDescripcion((String) data.get("descripcion"));
        entity.setClave((String) data.get("clave"));
    }
    
    @Override
    protected boolean inUse(Un_medida entity) { 
        if (entity.getProductos().isEmpty()) {
             return false;
        }
        System.out.println("lista llena...");
        return true;
    }
    
    @Override
     protected WebResponseData del(Un_medida entity, Principal principal) throws Exception{ 
        if (!inUse(entity)) {                
            dao().delete(entity);
            return new WebResponseData();
        }       
         return new WebResponseData(450, "La unidad de medida "+entity.getNombre_um()+" no se puede eliminar, existen productos clasificados dentro de esta");
     }
}
