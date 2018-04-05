/*
 
 */
package com.frontams.persistence.security.service;
 
import com.frontams.persistence.security.dao.Page_accessDAO;
import com.frontams.persistence.security.dao.RolePage_accessDAO;
import com.frontams.persistence.security.dao.UserDAO;
import com.frontams.persistence.security.dto.Principal;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sistemas
 */
@Service
@Transactional
public class AccessService {
        
    @Autowired
    private RolePage_accessDAO rolePageAccessDAO;
    @Autowired
    private Page_accessDAO pageAccessDAO;

    public Boolean checkAccess(Principal principal, String pageId) {
        return principal != null && pageAccess(principal, pageId);
    }

    private boolean pageAccess(Principal principal, String pageId) {
        if (principal.getAccessAll()) {
            return true;
        } else {
            return principal.getPageAccess().contains(pageId);
        }
    }
    
    public Boolean checkAuth(Principal principal, String pageId, String operation) {
        Long idPageAccess = pageAccessDAO.getIdByPageId(pageId);        
        Long idRole = principal.getRoleId();
       
//        if (principal.getAccessAll()) {//implementar permisos  determinadas funcionalidades
//            return true;
//        } else {            
            return rolePageAccessDAO.getPermission(idRole, idPageAccess, operation);
//        }
    }
}
