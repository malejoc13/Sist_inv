/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontams.persistence.manager;

/**
 *
 * @author Sistemas
 */
import com.frontams.common.dao.AbstractBaseDAO;
import com.frontams.common.manager.AbstractManager; 
import com.frontams.common.util.response.WebResponseData;
import com.frontams.persistence.dao.CompraDAO;
import com.frontams.persistence.dto.CompraDTO;
import com.frontams.persistence.model.Compra;
import com.frontams.persistence.security.dao.UserDAO;
import com.frontams.persistence.security.model.User;

import java.util.Date;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompraManager extends AbstractManager<Compra, CompraDTO>{
    
    @Autowired
    private CompraDAO compraDAO;
    
     @Autowired
    private UserDAO userDAO;
      
    @Override
    public AbstractBaseDAO dao() {
        return compraDAO;
    }
    
    @Override
    protected Compra create(Map<String, Object> data) throws Exception {
        Compra compra = new Compra(); 
        update(compra, data);

        return compra;
    }

    @Override
    protected void update(Compra entity, Map<String, Object> data) {
                 
        entity.setDescripcion((String) data.get("descripcion"));
        entity.setFecha_compra((Date) data.get("fecha_compra"));
                
        User user = userDAO.findById((Long) data.get("userId"));
        entity.setUser(user);
           
    }
}
