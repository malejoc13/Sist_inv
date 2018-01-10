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
import com.frontams.common.manager.AbstractManager; 
import com.frontams.common.util.response.WebResponseData;
import com.frontams.persistence.security.dto.Principal;
import com.frontams.persistence.security.dao.Page_accessDAO;
import com.frontams.persistence.security.dao.RoleDAO;
import com.frontams.persistence.security.dto.Page_accessDTO;
import com.frontams.persistence.security.model.Page_access;
import com.frontams.persistence.security.model.Role;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Page_accessManager extends AbstractManager<Page_access, Page_accessDTO>{
    
    @Autowired
    private Page_accessDAO pageDAO;
          
    @Override
    public AbstractBaseDAO dao() {
        return pageDAO;
    }
    
    @Override
    protected Page_access create(Map<String, Object> data) throws Exception {
        Page_access page = new Page_access(); 
        update(page, data);

        return page;
    }

    @Override
    protected void update(Page_access entity, Map<String, Object> data) {
              
        entity.setName((String) data.get("name"));
        entity.setIdPage((String) data.get("idPage"));         
    }
    
    @Override
    protected boolean inUse(Page_access entity) { 
        if (entity.getRole_pages_access().isEmpty()) {
             return false;
        }
        System.out.println("lista llena...");
        return true;
    }
    
    @Override
     protected WebResponseData del(Page_access entity, Principal principal) throws Exception{ 
        if (!inUse(entity)) {                
            dao().delete(entity);
            return new WebResponseData();
        }       
         return new WebResponseData(450, "La p&aacute;gina "+entity.getName()+" no se puede eliminar, existen accesos a p&aacute;ginas que la referencian");
     }
}
