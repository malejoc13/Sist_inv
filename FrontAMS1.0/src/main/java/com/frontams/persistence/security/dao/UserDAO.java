package com.frontams.persistence.security.dao;

import com.frontams.common.dao.AbstractBaseDAO;
import com.frontams.common.dto.NomenclatorDTO;
import com.frontams.persistence.security.dto.Principal; 
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

    public Boolean exist(String username) {
        return buildCriteria()
                .add(Restrictions.eq("username", username))
                .setMaxResults(1)
                .uniqueResult() != null;
    }
    
    public UserDTO getActive(String username, String password) {
        Criteria criteria = buildCriteria()
                .add(Restrictions.eq("username", username))
                .add(Restrictions.eq("password", password))
                .setMaxResults(1);
        
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("active").as("active"));
        
        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(UserDTO.class));
        
        return (UserDTO) criteria.uniqueResult();
    }
    
    public Principal getPrincipal(String username, String password)throws Exception {
           
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
                .add(Projections.property("unidad.id").as("entityId")) 
                .add(Projections.property("unidad.name").as("unidad"))
                .add(Projections.property("role.id").as("roleId"))
                .add(Projections.property("role.access_all").as("accessAll"));

        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(Principal.class));

        return (Principal) criteria.uniqueResult();
    }
    
    @Override
    protected void applyNomenclatorProjection(Criteria criteria) {
        criteria.addOrder(Order.asc("name"));
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id"))
                .add(Projections.property("username").as("name"));
                                          //atribUM       //atrib Nomencator
        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(NomenclatorDTO.class));

    }

}
