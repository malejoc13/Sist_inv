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
import com.frontams.persistence.dao.UnidadDAO;
import com.frontams.persistence.dto.UnidadDTO;
import com.frontams.persistence.model.Unidad;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UnidadManager extends AbstractManager<Unidad, UnidadDTO>{
    
    @Autowired
    private UnidadDAO unidad;
      
    @Override
    public AbstractBaseDAO dao() {
        return unidad;
    }
    
    @Override
    protected Unidad create(Map<String, Object> data) throws Exception {
        Unidad tp = new Unidad(); 
        update(tp, data);

        return tp;
    }

    @Override
    protected void update(Unidad entity, Map<String, Object> data) { 
        entity.setName((String) data.get("name"));
        entity.setDireccion((String) data.get("direccion"));
        entity.setTelefono((String) data.get("telefono"));  
    }
    
   @Override
    protected boolean inUse(Unidad entity) { 
        if (entity.getUsers().isEmpty()) {
             return false;
        }
        System.out.println("lista llena...");
        return true;
    }
    
}
