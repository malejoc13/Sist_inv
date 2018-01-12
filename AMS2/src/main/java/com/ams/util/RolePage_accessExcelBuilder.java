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

public class RolePage_accessExcelBuilder extends AbstractExcelView{
    
     @Override
    protected void buildExcelDocument(Map<String, Object> model,
            HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // get data model which is passed by the Spring container
        List<HashMap> list = (List<HashMap>) model.get("list");

        // create a new Excel sheet
        HSSFSheet sheet = workbook.createSheet("Roles Accesos");
        sheet.setDefaultColumnWidth(30);

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

        header.createCell(0).setCellValue("Rol : "+(String)list.get(0).get("role"));
        header.getCell(0).setCellStyle(style);
        
        HSSFRow header1 = sheet.createRow(1);
        header1.createCell(0).setCellValue("Acceso a página");
        header1.getCell(0).setCellStyle(style);
        
        header1.createCell(1).setCellValue("Crear");
        header1.getCell(0).setCellStyle(style);
        
        header1.createCell(2).setCellValue("Actualizar");
        header1.getCell(0).setCellStyle(style);
        
        header1.createCell(3).setCellValue("Eliminar");
        header1.getCell(0).setCellStyle(style);

       // create data rows
        int rowCount = 2;

        for (HashMap element : list) {
            HSSFRow aRow = sheet.createRow(rowCount++);
            aRow.createCell(0).setCellValue(element.get("page_access") + "");
            aRow.createCell(1).setCellValue(((Boolean)element.get("creat"))==true? "Si":"No");
            aRow.createCell(2).setCellValue(((Boolean)element.get("upd"))==true? "Si":"No");
            aRow.createCell(3).setCellValue(((Boolean)element.get("delt"))==true? "Si":"No");
        }
    }
}
