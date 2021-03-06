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
import com.frontams.common.dto.NomenclatorClaveDTO;
import com.frontams.persistence.dto.Tipo_prodDTO; 
import com.frontams.persistence.model.Tipo_prod;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

@Repository
public class Tipo_prodDAO extends AbstractBaseDAO<Tipo_prod, Tipo_prodDTO> {
    
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
                .add(Projections.property("descripcion").as("descripcion"))
                .add(Projections.property("clave").as("clave"));
         
        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(Tipo_prodDTO.class));
    }
    
    public Boolean exist(String clave) {
        return buildCriteria()
                .add(Restrictions.eq("clave", clave))                
                .setMaxResults(1)
                .uniqueResult() != null;
    }
    
    @Override
    protected void applyNomenclatorProjection(Criteria criteria) {
        criteria.addOrder(Order.asc("clave"));
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id"))
                .add(Projections.property("name").as("name"))
                .add(Projections.property("clave").as("clave"));
                                          //atribUM       //atrib Nomencator
        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(NomenclatorClaveDTO.class));

    }
    
}
