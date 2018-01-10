/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontams.web.security;

import com.frontams.common.util.response.WebResponseData;
import com.frontams.persistence.security.dto.Principal;
import com.frontams.persistence.security.service.AccessService;
import com.frontams.persistence.security.service.LoginService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Roberto Rodriguez
 */
@RestController
@RequestMapping(value = "/{pageId}/security", method = RequestMethod.GET)
public class SecurityController {

    @Autowired
    protected LoginService loginService;
    @Autowired
    protected AccessService accessService;

    @RequestMapping(value = "/ping")
    public String checkAccess(@PathVariable("pageId") String pageId) {
        return "PING";
    }
//mapeo para lo que venga con la ruta login entonces ejecue esta funcion 
//funcion para autenticar al usuario
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
    public WebResponseData login(@PathVariable("pageId") String pageId, @RequestBody LoginRequest data, HttpSession session) {

        String username = data.getUser();
        String password = data.getPassword();

        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("sesion = " + session.getId());

        Principal principal = null;

        try {
            principal = loginService.login(username, password);

            if (principal != null) {
                session.putValue(Principal.PRINCIPAL, principal);
                session.putValue(Principal.TOKEN, principal.getToken());
                return new WebResponseData(principal);
            }
                return WebResponseData.toLoginFail();
        } catch (Exception e) {
            e.printStackTrace();
             return WebResponseData.forException(e);
        }       
    }

    @RequestMapping(value = "/checkAccess")//verifica que se tenga acceso a la pagina que indexa
    public WebResponseData checkAccess( @PathVariable("pageId") String pageId, HttpSession session) {

        Principal principal = (Principal) session.getAttribute(Principal.PRINCIPAL);

        return new WebResponseData(accessService.checkAccess(principal, pageId));
    }

}
//clase auxiliar para tomar datos provenientes de la interfaz en formato json
class LoginRequest {

    private String user;
    private String password;

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
