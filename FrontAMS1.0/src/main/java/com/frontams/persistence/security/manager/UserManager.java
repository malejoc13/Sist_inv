/*
 @Autor: Roberto Rodriguez
 Email: robertoSoftwareEngineer@gmail.com

 @Copyright 2016 
 */
package com.frontams.persistence.security.manager;

import com.frontams.common.dao.AbstractBaseDAO;
import com.frontams.persistence.security.dao.UserDAO; 
import com.frontams.common.manager.AbstractManager; 
import com.frontams.common.util.response.WebResponseData;
import com.frontams.persistence.dao.UnidadDAO;
import com.frontams.persistence.dto.Principal;
import com.frontams.persistence.model.Unidad;
import com.frontams.persistence.security.dao.RoleDAO;
import com.frontams.persistence.security.dto.UserDTO; 
import com.frontams.persistence.security.model.Role;
import com.frontams.persistence.security.model.User;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rrodriguez
 */
@Service
@Transactional
public class UserManager extends AbstractManager<User, UserDTO> {

    @Autowired
    private UserDAO userDAO;
    
    @Autowired
    private UnidadDAO unidadDAO;
    
    @Autowired
    private RoleDAO roleDAO;
      
    @Override
    public AbstractBaseDAO dao() {
        return userDAO;
    }

    @Override
    protected User create(Map<String, Object> data) throws Exception {
        User user = new User(); 
        update(user, data);

        return user;
    }

    @Override
    protected void update(User entity, Map<String, Object> data) {
                 
        entity.setFirstName((String) data.get("firstName"));
        entity.setLastName((String) data.get("lastName"));
        entity.setUsername((String) data.get("username"));
        entity.setPassword((String) data.get("password"));
        entity.setEmail((String) data.get("email"));
        entity.setActive((Boolean) data.get("active"));
        
        Unidad unidad = unidadDAO.findById((Long) data.get("unidadId"));
        entity.setUnidad(unidad);
        
        Role role = roleDAO.findById((Long) data.get("roleId"));
        entity.setRole(role);        
    }
    
    @Override
    protected boolean inUse(User entity) { 
       /* if (entity.getCompras().isEmpty()) {
             return false;
        }*/
        System.out.println("lista llena...");
        return true;
    }
    
   @Override
     protected WebResponseData del(User entity, Principal principal) throws Exception{ 
        if ( principal.getId().equals(entity.getId())) {
               return new WebResponseData(550, "No puede eliminiar su usuario mientras est&aacute; autenticado");
            }   
        if ( inUse(entity)) {
               return new WebResponseData(450, "El usuario "+entity.getFirstName()+" no se puede eliminar, existen compras asociadas a &eacute;l");
            }
        dao().delete(entity);
        return new WebResponseData();         
     }   

}
