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
import com.frontams.persistence.dto.Principal;
import com.frontams.persistence.security.dao.Page_accessDAO;
import com.frontams.persistence.security.dao.RoleDAO;
import com.frontams.persistence.security.dao.RolePage_accessDAO;
import com.frontams.persistence.security.dto.RolePage_accessDTO;
import com.frontams.persistence.security.model.Page_access;
import com.frontams.persistence.security.model.Role;
import com.frontams.persistence.security.model.RolePage_access;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RolePage_accessManager extends AbstractManager<RolePage_access, RolePage_accessDTO>{
    
    @Autowired
    private RolePage_accessDAO rolepageDAO;
    
    @Autowired
    private RoleDAO roleDAO;
    
    @Autowired
    private Page_accessDAO pageDAO;
      
    @Override
    public AbstractBaseDAO dao() {
        return rolepageDAO;
    }
    
    @Override
    protected RolePage_access create(Map<String, Object> data) throws Exception {
             
        RolePage_access rolepage = new RolePage_access(); 
        update(rolepage, data);

        return rolepage;
    }

    @Override
    protected void update(RolePage_access entity, Map<String, Object> data) {
        Long roleId = (Long) data.get("roleId");
        Long pageAccessId = (Long) data.get("page_accessId");
       
            System.out.println("verifico en caso de estar actualizando..");
            Long rolePageAccessId = rolepageDAO.exist(roleId, pageAccessId);
            System.out.println("id encontrado.."+rolePageAccessId);
            if (rolePageAccessId != null) {
                throw new RuntimeException("Esta asociaci&oacute;n ya existe.");
            }
      
        Role role = roleDAO.findById((Long) data.get("roleId"));
        entity.setRole(role);     
        
        Page_access page = pageDAO.findById((Long) data.get("page_accessId"));
        entity.setPage_access(page); 
    }
    
    @Override
     protected WebResponseData del(RolePage_access entity, Principal principal) throws Exception{ 
                     
            dao().delete(entity);
            return new WebResponseData();
     }
      
    
}
