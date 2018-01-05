/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontams.common.controller;

import com.frontams.common.dto.ListRequestDTO;
import com.frontams.common.dto.NomenclatorDTO;
import com.frontams.common.manager.AbstractManager;
import com.frontams.common.util.GRUtil;
import com.frontams.common.util.response.WebResponse;
import com.frontams.common.util.response.WebResponseData;
import com.frontams.common.util.response.WebResponseDataList; 
import com.frontams.persistence.dto.Principal;
import com.frontams.persistence.security.service.AccessService;
import java.text.ParseException; 
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Robe
 */
@RestController
public abstract class AbstractController<D> {

    @Autowired
    private AccessService accessService;
    
    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public Map report(
            @PathVariable("pageId") String pageId, 
            @RequestParam(value = "report", defaultValue = "") String report, //Type of report
            @RequestParam(value = "params", defaultValue = "") String params,
            HttpSession session) throws Exception {
   
        System.out.println("FrontAMS / report = " + report);
        System.out.println("FrontAMS / params = " + params);
        List<Criterion> data = GRUtil.parseParamsToExpressions(params); 
       //System.out.println("Params ... "+data.toString());
        return getReportManager().pageList(new ListRequestDTO(0, 0, 0,report, data)); 
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map list(
            @PathVariable("pageId") String pageId,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "start", defaultValue = "0") Integer start,
            @RequestParam(value = "limit", defaultValue = "0") Integer limit,
            @RequestParam(value = "report", defaultValue = "") String report,
            @RequestParam(value = "params", defaultValue = "") String params,
            HttpSession session) throws Exception {
            //System.out.println("Params ... "+params);
        List<Criterion> data = GRUtil.parseParamsToExpressions(params); 
               
        return getAbstractManager().pageList(new ListRequestDTO(page, start, limit,report, data));
     }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
    public WebResponse save(@PathVariable("pageId") String pageId,
            @RequestBody Map<String, Object> map, 
            HttpSession session) throws ParseException, Exception {
        System.out.println("AbstractController -> saving..."+pageId);
        Principal principal = (Principal) session.getAttribute(Principal.PRINCIPAL);
        try { 
            Map<String, Object> data = GRUtil.parseRequestMap(map);           
            return new WebResponseData(getAbstractManager().save(data));
        } catch (Exception e) {
            e.printStackTrace();
            return WebResponse.forException(e);
        }
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = "application/json")
    public WebResponse delete(@PathVariable("pageId") String pageId,
            @RequestBody Map<String, Object> map, 
            HttpSession session) throws ParseException {
        Principal principal = (Principal) session.getAttribute(Principal.PRINCIPAL);
        System.out.println("Eliminando......"+pageId);
        try { 
            Map<String, Object> data = GRUtil.parseRequestMap(map);
                 
        return getAbstractManager().delete(data, principal); 
                          
        } catch (Exception e) {
            e.printStackTrace();   
            return WebResponse.forException(e);
        }       
    }

    @RequestMapping(value = "/nomenclator", method = RequestMethod.GET)
    public WebResponseDataList nomenclator(
            @PathVariable("pageId") String pageId,
            @RequestParam(value = "params", defaultValue = "") String params,
            HttpSession session) throws Exception {
         System.out.println("Params ... "+params);
        List<Criterion> expressions = GRUtil.parseParamsToExpressions( params );
        checkAccess(session, pageId, expressions);
        return new WebResponseDataList<NomenclatorDTO>(getAbstractManager().nomenclatorList(expressions));
    }

    @RequestMapping(value = "/load", method = RequestMethod.GET)
    public D load(@RequestParam(value = "params", defaultValue = "") String params) { 
        return (D) getAbstractManager().load(GRUtil.parseParamsToExpressions( params ) );
    }

    private void checkAccess(HttpSession session, String page, List<Criterion> expressions) throws Exception {
        Principal principal = (Principal) session.getAttribute(Principal.PRINCIPAL);

        if (!(accessService.checkAccess(principal, page) && checkAuth(principal, expressions))){
            throw new Exception("Acceso denegado");
        }
    }

    public boolean checkAuth(Principal principal, List<Criterion> expressions){return true;} //Redefine if need special check access
    
    public abstract AbstractManager getAbstractManager();
    
    public AbstractManager getReportManager(){return null;}
}
