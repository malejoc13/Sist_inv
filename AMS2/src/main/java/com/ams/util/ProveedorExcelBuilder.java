/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ams.util;

/**
 *
 * @author Sistemas
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ProveedorExcelBuilder extends AbstractExcelView{
    
     @Override
    protected void buildExcelDocument(Map<String, Object> model,
            HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // get data model which is passed by the Spring container
        List<HashMap> list = (List<HashMap>) model.get("list");

        // create a new Excel sheet
        HSSFSheet sheet = workbook.createSheet("Proveedores");
        sheet.setDefaultColumnWidth(30);
        //sheet.setColumnWidth(1,50);

        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);

        // create header row
        HSSFRow header = sheet.createRow(0);

        header.createCell(0).setCellValue("Nombre");
        header.getCell(0).setCellStyle(style);

        header.createCell(1).setCellValue("Dirección");
        header.getCell(1).setCellStyle(style);

        header.createCell(2).setCellValue("Teléfono");
        header.getCell(2).setCellStyle(style);
        
        header.createCell(3).setCellValue("Teléfono movil");
        header.getCell(3).setCellStyle(style);
        
        header.createCell(4).setCellValue("Email");
        header.getCell(4).setCellStyle(style);

       // create data rows
        int rowCount = 1;

        for (HashMap element : list) {
            HSSFRow aRow = sheet.createRow(rowCount++);            
            aRow.createCell(0).setCellValue(element.get("name") + "");
            aRow.createCell(1).setCellValue(element.get("direccion") + "");
            aRow.createCell(2).setCellValue(element.get("telefono") + ""); 
            aRow.createCell(3).setCellValue(element.get("telefono_m") + ""); 
            aRow.createCell(4).setCellValue(element.get("email") + ""); 
        }
    }
    
}
