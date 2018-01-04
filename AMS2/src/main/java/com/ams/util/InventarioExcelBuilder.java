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

import java.text.SimpleDateFormat;
import java.util.Date;
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

public class InventarioExcelBuilder  extends AbstractExcelView{
     SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
     @Override
    protected void buildExcelDocument(Map<String, Object> model,
            HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // get data model which is passed by the Spring container
        List<HashMap> list = (List<HashMap>) model.get("list");

        // create a new Excel sheet
        HSSFSheet sheet = workbook.createSheet("Inventarios");
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

        header.createCell(0).setCellValue("Clave");
        header.getCell(0).setCellStyle(style);

        header.createCell(1).setCellValue("Producto");
        header.getCell(1).setCellStyle(style);

        header.createCell(2).setCellValue("Saldo inicial");
        header.getCell(2).setCellStyle(style);
        
        header.createCell(3).setCellValue("Cantidad");
        header.getCell(3).setCellStyle(style);
        
        header.createCell(4).setCellValue("Fecha alta");
        header.getCell(4).setCellStyle(style);
        
        header.createCell(5).setCellValue("Fecha");
        header.getCell(5).setCellStyle(style);
        
        header.createCell(6).setCellValue("Unidad");
        header.getCell(6).setCellStyle(style);

       // create data rows
        int rowCount = 1;

        for (HashMap element : list) {
            HSSFRow aRow = sheet.createRow(rowCount++);            
            aRow.createCell(0).setCellValue(element.get("productoClave") + "");
            aRow.createCell(1).setCellValue(element.get("producto") + "");
            aRow.createCell(2).setCellValue(element.get("saldo_ini") + ""); 
            aRow.createCell(3).setCellValue(element.get("cantidad") + ""); 
            aRow.createCell(4).setCellValue(sdf.format(new Date(Long.parseLong(element.get("fecha_ini").toString() )) )+ ""); 
            aRow.createCell(5).setCellValue(sdf.format(new Date(Long.parseLong(element.get("fecha").toString() )) ) + ""); 
            aRow.createCell(6).setCellValue(element.get("unidad") + "");       
            
        }
    }
    
}
