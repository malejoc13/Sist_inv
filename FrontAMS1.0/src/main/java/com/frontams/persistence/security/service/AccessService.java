/*
 
 */
package com.frontams.persistence.security.service;
 
import com.frontams.persistence.security.dto.Principal;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sistemas
 */
@Service
public class AccessService {

    public Boolean checkAccess(Principal principal, String pageId) {
        return principal != null && pageAccess(principal, pageId);
    }

    private boolean pageAccess(Principal principal, String pageId) {
        if (principal.getAccessAll()) {//implementar permisos  determinadas funcionalidades
            return true;
        } else {
            return principal.getPageAccess().contains(pageId);
        }
    }
}
