/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontams.persistence.security.manager;

/**
 *
 * @author Sistemas
 */

import com.frontams.common.dao.AbstractBaseDAO;
import com.frontams.persistence.security.dao.UserDAO; 
import com.frontams.common.manager.AbstractManager; 
import com.frontams.common.util.response.WebResponseData;
import com.frontams.persistence.dto.Principal;
import com.frontams.persistence.security.dao.RoleDAO;
import com.frontams.persistence.security.dto.RoleDTO;
import com.frontams.persistence.security.model.Role;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleManager extends AbstractManager<Role, RoleDTO>{
    
    @Autowired
    private RoleDAO role;
      
    @Override
    public AbstractBaseDAO dao() {
        return role;
    }
    
    @Override
    protected Role create(Map<String, Object> data) throws Exception {
        Role tp = new Role(); 
        update(tp, data);

        return tp;
    }

    @Override
    protected void update(Role entity, Map<String, Object> data) { 
        entity.setName((String) data.get("name"));
        entity.setDescripcion((String) data.get("descripcion"));        
    }
    
   @Override
    protected boolean inUse(Role entity) { 
        if (entity.getUsers().isEmpty() && entity.getRole_pages_access().isEmpty()) {
             return false;
        }
        System.out.println("lista llena...");
        return true;
    }
    
    @Override
     protected WebResponseData del(Role entity, Principal principal) throws Exception{ 
        if (!inUse(entity)) {                
            dao().delete(entity);
            return new WebResponseData();
        }       
         return new WebResponseData(450, "El rol "+entity.getName()+" no se puede eliminar, existen usuarios y (o) accesos a p&aacute;ginas que lo referencian");
     }
}
