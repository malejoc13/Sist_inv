/*
 @Autor: Roberto Rodriguez
 Email: robertoSoftwareEngineer@gmail.com

 @Copyright 2016 
 */
package com.frontams.persistence.security.service;
 
import com.frontams.persistence.dto.Principal;
import org.springframework.stereotype.Service;

/**
 *
 * @author rrodriguez
 */
@Service
public class AccessService {

    public Boolean checkAccess(Principal principal, String pageId) {
        return principal != null && pageAccess(principal, pageId);
    }

    private boolean pageAccess(Principal principal, String pageId) {
//        if (principal.getAccessAll()) {
//            return !principal.getPageAccess().contains(pageId);
//        } else {
//            return principal.getPageAccess().contains(pageId);
//        }
        return true;
    }
}
