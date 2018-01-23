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
import com.frontams.persistence.dto.Mov_prodDTO;
import com.frontams.persistence.model.Mov_prod;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

@Repository
public class Mov_prodDAO extends AbstractBaseDAO<Mov_prod, Mov_prodDTO>{
    
    public Criteria buildCriteria() {
        return getCriteria()  //entidad   //alias
                .createAlias("movimiento", "movimiento")
                .createAlias("producto", "producto");
    }
    
    public void addOrder(Criteria criteria) {
        criteria.addOrder(Order.asc("cantidad"));
    }
    
    @Override
    public void applyListProjection(Criteria criteria) {
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id"))
                .add(Projections.property("cantidad").as("cantidad"))   
                .add(Projections.property("saldo_prod").as("saldo_prod"))
                .add(Projections.property("movimiento.name").as("movimiento"))
                .add(Projections.property("movimiento.id").as("movimientoId"))
                .add(Projections.property("producto.name").as("producto"))
                .add(Projections.property("producto.precio_max").as("productoPrecio"))
                .add(Projections.property("producto.id").as("productoId"));
        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(Mov_prodDTO.class));
    }
    
}
