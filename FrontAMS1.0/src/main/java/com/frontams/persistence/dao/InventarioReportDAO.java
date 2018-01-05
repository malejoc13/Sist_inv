/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontams.persistence.dao;

/**
 *
 * @author Sistemas
 */
import com.frontams.common.dao.AbstractBaseDAO;
import com.frontams.persistence.dto.InventarioReportDTO;
import com.frontams.persistence.model.Inventario;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

@Repository
public class InventarioReportDAO extends AbstractBaseDAO<Inventario, InventarioReportDTO>{
    
    public Criteria buildCriteria() {
        return getCriteria()  //entidad   //alias
                .createAlias("producto", "producto")
                .createAlias("producto.tipo_prod", "tipo_prod")
                .createAlias("unidad", "unidad");
    }
    
    public void addOrder(Criteria criteria) {
        criteria.addOrder(Order.asc("tipo_prod.name"));
    }
    
    @Override
    public void applyListProjection(Criteria criteria) {
        ProjectionList projectionList = Projections.projectionList()
                //.add(Projections.property("id").as("id"))                                                
                .add(Projections.property("cantidad").as("cantidad"))
                //.add(Projections.property("saldo_ini").as("saldo_ini"))
                //.add(Projections.property("fecha_ini").as("fecha_ini"))
                //.add(Projections.property("fecha").as("fecha"))
                .add(Projections.property("producto.name").as("producto"))                
                //.add(Projections.property("producto.id").as("productoId"))
                .add(Projections.property("producto.clave").as("productoClave"))
                .add(Projections.property("tipo_prod.name").as("tipo_prod"))
                .add(Projections.property("unidad.name").as("unidad"));
               // .add(Projections.property("unidad.id").as("unidadId"));
                                           //alias[.atrib]   //atributo en el DTO
        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(InventarioReportDTO.class));
    }
    
}
