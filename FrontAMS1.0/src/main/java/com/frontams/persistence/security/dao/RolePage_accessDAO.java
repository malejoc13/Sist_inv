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
import com.frontams.persistence.security.dto.RolePage_accessDTO;
import com.frontams.persistence.security.model.RolePage_access;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RolePage_accessDAO extends AbstractBaseDAO<RolePage_access, RolePage_accessDTO>{
    
        public Criteria buildCriteria() {
        return getCriteria()
                .createAlias("role", "role")
                .createAlias("page_access", "page_access");
    }

   /* public void addOrder(Criteria criteria) {
        criteria.addOrder(Order.asc("role.name"));
    } */

    @Override
    public void applyListProjection(Criteria criteria) {
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id"))          
                .add(Projections.property("role.id").as("roleId"))
                .add(Projections.property("role.name").as("role"))
                .add(Projections.property("page_access.id").as("page_accessId"))
                .add(Projections.property("page_access.name").as("page_access"));

        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(RolePage_accessDTO.class));
    }
    
    @Transactional
    public List<String> getPageAccessByRole(Long appRole) {
        System.out.println("RolePageAccessDAO -> getPageAccessByAppRole:: appRole = " + appRole);
        return getCriteria()
                .createAlias("role", "role")
                .createAlias("page_access", "page_access")
                .add(Restrictions.eq("role.id", appRole))
                .setProjection(Projections.property("page_access.idPage").as("idPage"))
                .list();
    }

    public Long exist(Long idRole, Long idPageAccess) {
        return (Long) buildCriteria()
                .add(Restrictions.eq("role.id", idRole))
                .add(Restrictions.eq("page_access.id", idPageAccess))
                .setProjection(Projections.property("id"))
                .setMaxResults(1)
                .uniqueResult();
    }
    
}
