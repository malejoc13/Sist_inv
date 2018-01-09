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
import com.frontams.persistence.dto.ProveedorDTO; 
import com.frontams.persistence.model.Proveedor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

@Repository
public class ProveedorDAO extends AbstractBaseDAO<Proveedor, ProveedorDTO>{
    
    //criterio para ordenar
    public void addOrder(Criteria criteria) {
        criteria.addOrder(Order.asc("name"));
    } 
     
    //campos a devolver en la consulta
    @Override
    public void applyListProjection(Criteria criteria) {
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id"))
                .add(Projections.property("name").as("name"))
                .add(Projections.property("direccion").as("direccion"))
                .add(Projections.property("telefono").as("telefono"))
                .add(Projections.property("telefono_m").as("telefono_m"))
                .add(Projections.property("email").as("email"));
         
        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(ProveedorDTO.class));
    }
    
}
