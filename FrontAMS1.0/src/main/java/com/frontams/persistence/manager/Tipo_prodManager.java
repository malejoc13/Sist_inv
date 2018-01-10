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
import com.frontams.persistence.dao.Tipo_prodDAO;
import com.frontams.persistence.security.dto.Principal;
import com.frontams.persistence.dto.Tipo_prodDTO; 
import com.frontams.persistence.model.Tipo_prod;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Tipo_prodManager extends AbstractManager<Tipo_prod, Tipo_prodDTO>{
    
    @Autowired
    private Tipo_prodDAO tipo_prodDAO;
      
    @Override
    public AbstractBaseDAO dao() {
        return tipo_prodDAO;
    }
    
    @Override
    protected Tipo_prod create(Map<String, Object> data) throws Exception {
        Tipo_prod tp = new Tipo_prod(); 
        update(tp, data);

        return tp;
    }

    @Override
    protected void update(Tipo_prod entity, Map<String, Object> data) { 
        entity.setName((String) data.get("name"));
        entity.setDescripcion((String) data.get("descripcion"));
        
    }
    
    @Override
    protected boolean inUse(Tipo_prod entity) { 
        if (entity.getProductos().isEmpty()) {
             return false;
        }
        System.out.println("lista llena...");
        return true;
    }
    
     @Override
     protected WebResponseData del(Tipo_prod entity, Principal principal) throws Exception{ 
        if (!inUse(entity)) {                
            dao().delete(entity);
            return new WebResponseData();
        }       
         return new WebResponseData(450, "El tipo de producto "+entity.getName()+" no se puede eliminar, existen productos clasificados dentro de dicho tipo");
     }
}
