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
import com.frontams.common.dto.NomenclatorDTO;
import com.frontams.persistence.dto.Un_medidaDTO; 
import com.frontams.persistence.model.Un_medida;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

@Repository
public class Un_medidaDAO extends AbstractBaseDAO<Un_medida, Un_medidaDTO> {

    //criterio para ordenar
    public void addOrder(Criteria criteria) {
        criteria.addOrder(Order.asc("nombre_um"));
    } 
     
    //campos a devolver en la consulta
    @Override
    public void applyListProjection(Criteria criteria) {
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id"))
                .add(Projections.property("nombre_um").as("nombre_um"))
                .add(Projections.property("descipcion_um").as("descipcion_um"));
         
        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(Un_medidaDTO.class));
    }
    //reimplemento la funcion de su padre para adaptarlo a los atributos de esta clase
    @Override
    protected void applyNomenclatorProjection(Criteria criteria) {
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id"))
                .add(Projections.property("nombre_um").as("name"));
                                          //atribUM       //atrib Nomencator
        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(NomenclatorDTO.class));

    }
    
}
