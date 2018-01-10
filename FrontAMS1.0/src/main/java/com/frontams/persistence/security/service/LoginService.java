/*

 */
package com.frontams.persistence.security.service;
  
import com.frontams.persistence.security.dto.Principal;
import com.frontams.persistence.security.dao.RolePage_accessDAO;
import com.frontams.persistence.security.dao.UserDAO; 
import com.frontams.persistence.security.dto.UserDTO;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alejo
 */
@Service
@Transactional
public class LoginService {

    @Autowired
    private UserDAO userDAO; 
    
    @Autowired
    private RolePage_accessDAO rolePageAccessDAO;

    public Principal login(String username, String password) throws Exception { 
        Principal principal = userDAO.getPrincipal(username,password);
 
        if (principal != null) { 
            UserDTO udto = userDAO.getActive(username, password);
            if (!udto.getActive()) {
                 throw new RuntimeException("Su usuario se encuentra desabilitado, consulte al Administrador");
            }
            List<String> pageAccess = rolePageAccessDAO.getPageAccessByRole(principal.getRoleId());
            System.out.println("RolePageAccessDAO -> getPageAccessByAppRole::" + pageAccess.toString());
            principal.setPageAccess(pageAccess);//            
            principal.setToken(UUID.randomUUID().toString());
        }

        return principal;
    }

}
