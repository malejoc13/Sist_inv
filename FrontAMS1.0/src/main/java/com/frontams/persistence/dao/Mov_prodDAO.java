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
    
    @Override
    public void addOrder(Criteria criteria) {
        criteria.addOrder(Order.asc("producto.clave"));
    }
    
    @Override
    public void applyListProjection(Criteria criteria) {
        //System.out.println("apply list projection");
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id"))
                .add(Projections.property("cantidad").as("cantidad"))               
                .add(Projections.property("movimiento.fecha").as("fecha"))
                .add(Projections.property("movimiento.id").as("movimientoId"))
                .add(Projections.property("producto.name").as("producto"))
                .add(Projections.property("producto.clave").as("productoClave"))
                .add(Projections.property("producto.descripcion").as("descripcion"))
                .add(Projections.property("producto.precio_max").as("precio"))
                .add(Projections.property("producto.id").as("productoId"));
        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(Mov_prodDTO.class));
    }
    
    public Long exist(Long idProd, Long idMov) {
        return (Long) buildCriteria()
                .add(Restrictions.eq("producto.id", idProd))
                .add(Restrictions.eq("movimiento.id", idMov))
                .setProjection(Projections.property("id"))
                .setMaxResults(1)
                .uniqueResult();
    }
    
}
