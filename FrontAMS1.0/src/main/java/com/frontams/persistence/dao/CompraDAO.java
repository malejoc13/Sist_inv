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
import com.frontams.persistence.dto.CompraDTO;
import com.frontams.persistence.model.Compra;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

@Repository
public class CompraDAO extends AbstractBaseDAO<Compra, CompraDTO>{
    
    @Override
    public Criteria buildCriteria() {
        return getCriteria()  //entidad   //alias
                .createAlias("user", "user");
    }
    
    @Override
    public void addOrder(Criteria criteria) {
        criteria.addOrder(Order.asc("fecha_compra"));
    } 
    
     @Override
    public void applyListProjection(Criteria criteria) {
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id")) 
                .add(Projections.property("descripcion").as("descripcion"))
                .add(Projections.property("fecha_compra").as("fecha_compra"))
                .add(Projections.property("user.firstName").as("user"))
                .add(Projections.property("user.id").as("userId"));
                                           //alias[.atrib]   //atributo en el DTO
        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(CompraDTO.class));
    }
}
