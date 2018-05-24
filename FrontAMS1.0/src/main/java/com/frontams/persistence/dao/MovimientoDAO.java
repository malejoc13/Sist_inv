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
import com.frontams.persistence.dto.MovimientoDTO;
import com.frontams.persistence.model.Movimiento;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

@Repository
public class MovimientoDAO extends AbstractBaseDAO<Movimiento, MovimientoDTO>{
    
//    public Criteria buildCriteria() {
//        return getCriteria()  //entidad   //alias
//                .createAlias("tipo_mov", "tipo_mov");
//    }
    
    public void addOrder(Criteria criteria) {
        criteria.addOrder(Order.asc("fecha"));
    }
    
    @Override
    public void applyListProjection(Criteria criteria) {
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id"))
                .add(Projections.property("fecha").as("fecha"))   
                .add(Projections.property("saldo").as("saldo"))
                .add(Projections.property("descripcion").as("descripcion"))
                .add(Projections.property("tipo_mov").as("tipo_mov"));
        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(MovimientoDTO.class));
    }
    
}
