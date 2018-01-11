/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontams.persistence.security.dao;

/**
 *
 * @author Sistemas
 */
import com.frontams.common.dao.AbstractBaseDAO;
import com.frontams.persistence.security.dto.Page_accessDTO;
import com.frontams.persistence.security.model.Page_access;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

@Repository
public class Page_accessDAO extends AbstractBaseDAO<Page_access, Page_accessDTO>{
    
    public void addOrder(Criteria criteria) {
        criteria.addOrder(Order.asc("name"));
    } 

    @Override
    public void applyListProjection(Criteria criteria) {
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id"))
                .add(Projections.property("name").as("name"))
                .add(Projections.property("idPage").as("idPage"));

        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(Page_accessDTO.class));
    }
    
    public Long getIdByPageId(String idPage) {
        return (Long) getCriteria()
                .add(Restrictions.eq("idPage", idPage))
                .setProjection(Projections.property("id"))
                .setMaxResults(1)
                .uniqueResult();
    }
    
}
