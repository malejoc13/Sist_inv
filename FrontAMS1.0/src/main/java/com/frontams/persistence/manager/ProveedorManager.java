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
import com.frontams.persistence.dao.ProveedorDAO;
import com.frontams.persistence.dto.ProveedorDTO; 
import com.frontams.persistence.model.Proveedor;
import java.util.Map;
import org.mockito.cglib.beans.BulkBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProveedorManager extends AbstractManager<Proveedor, ProveedorDTO>{
    
    @Autowired
    private ProveedorDAO proveedor;
      
    @Override
    public AbstractBaseDAO dao() {
        return proveedor;
    }
    
    @Override
    protected Proveedor create(Map<String, Object> data) throws Exception {
        Proveedor tp = new Proveedor(); 
        update(tp, data);

        return tp;
    }

    @Override
    protected void update(Proveedor entity, Map<String, Object> data) { 
        entity.setName((String) data.get("name"));
        entity.setDireccion((String) data.get("direccion"));
        entity.setTelefono((String) data.get("telefono"));
        entity.setEmail((String) data.get("email"));
        
    }
    
    @Override
    protected boolean inUse(Proveedor entity) { 
        if (entity.getProductos().isEmpty()) {
             return false;
        }
        System.out.println("lista llena...");
        return true;
    }
    
}
