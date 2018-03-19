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
import com.frontams.persistence.dto.ProductoReportDTO;
import com.frontams.persistence.model.Producto;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoReportDAO extends AbstractBaseDAO<Producto, ProductoReportDTO>{
    
    public Criteria buildCriteria() {
        return getCriteria()  //entidad   //alias                
                .createAlias("un_medida", "un_medida")
                .createAlias("tipo_prod", "tipo_prod");
    }
    
    public void addOrder(Criteria criteria) {
        criteria.addOrder(Order.asc("tipo_prod.name"));
    }
    
    @Override
    public void applyListProjection(Criteria criteria) {
        ProjectionList projectionList = Projections.projectionList()
                                                                
                .add(Projections.property("name").as("name"))
                .add(Projections.property("clave").as("clave"))
                .add(Projections.property("descripcion").as("descripcion"))
                .add(Projections.property("un_medida.nombre_um").as("un_medida"))
                .add(Projections.property("tipo_prod.name").as("tipo_prod"));
        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(ProductoReportDTO.class));
    }
    
}
