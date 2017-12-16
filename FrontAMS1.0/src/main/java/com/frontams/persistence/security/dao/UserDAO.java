package com.frontams.persistence.security.dao;

import com.frontams.common.dao.AbstractBaseDAO;
import com.frontams.common.dto.NomenclatorDTO;
import com.frontams.persistence.dto.Principal; 
import com.frontams.persistence.security.dto.UserDTO; 
import com.frontams.persistence.security.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO extends AbstractBaseDAO<User, UserDTO> {

    public Criteria buildCriteria() {
        return getCriteria()
                .createAlias("unidad", "unidad")
                .createAlias("role", "role");
    }

    public void addOrder(Criteria criteria) {
        criteria.addOrder(Order.asc("firstName"));
    } 

    @Override
    public void applyListProjection(Criteria criteria) {
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id"))
                .add(Projections.property("firstName").as("firstName"))
                .add(Projections.property("lastName").as("lastName"))
                .add(Projections.property("username").as("username"))
                .add(Projections.property("password").as("password"))  
                .add(Projections.property("email").as("email"))
                .add(Projections.property("active").as("active"))
                .add(Projections.property("unidad.name").as("unidad"))
                .add(Projections.property("unidad.id").as("unidadId"))
                .add(Projections.property("role.id").as("roleId"))
                .add(Projections.property("role.name").as("role"));

        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(UserDTO.class));
    }

    public Principal getPrincipal(String username, String password) {
        //criterio de busqueda
        Criteria criteria = buildCriteria()
                .add(Restrictions.eq("username", username))
                .add(Restrictions.eq("password", password))
                .setMaxResults(1);
//datos a devolver
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id"))
                .add(Projections.property("firstName").as("name"))
                .add(Projections.property("lastName").as("lastName")) 
                //.add(Projections.property("role.id").as("roleId"))
                ;
        //Ignore for this version
//                .add(Projections.property("role.accessAll").as("accessAll"));

        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(Principal.class));

        return (Principal) criteria.uniqueResult();
    }
    
    @Override
    protected void applyNomenclatorProjection(Criteria criteria) {
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id"))
                .add(Projections.property("username").as("name"));
                                          //atribUM       //atrib Nomencator
        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(NomenclatorDTO.class));

    }

}
