/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ams.web.mvc.controller;

import com.ams.manager.ReportManager;  
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Roberto
 */
@Controller
@RequestMapping(value = "/report", method = RequestMethod.GET)
public class ReportController {

    @Autowired
    private ReportManager reportManager;

    @RequestMapping(value = "/{entity}", method = RequestMethod.GET)
    public ModelAndView viewReport(HttpServletRequest request, @PathVariable("entity") String entity,
            @RequestParam(value = "report", defaultValue = "") String report,
            @RequestParam(value = "params", defaultValue = "") String params) {
        System.out.println("viewReport... entity = " + entity);

        String url = request.getRequestURL().toString(); 

        System.out.println("%url = " + url);
        //System.out.println("%params = " + params);
       // System.out.println("%report = " + report);
        if (url.contains("/AMS/")) {
            url = url.split("/AMS/")[0]; 
        }
         System.out.println("%url = " + url);
        List list = reportManager.getReport(url,entity,report, params);

        if(report != null && report.equalsIgnoreCase("excel")){//si selecciono en excel
            System.out.println("ReportController -> return ExcelView");
            return new ModelAndView(entity + "ExcelView", "list", list);
        }else{//por defecto da el report en pdf
            Map<String, Object> parameterMap = new HashMap<>();
            parameterMap.put("datasource", new JRBeanCollectionDataSource(list));
             
            return new ModelAndView(entity + "PDFView", parameterMap);
        }
      
    }
 
}
