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
import com.frontams.persistence.dao.MovimientoDAO;
import com.frontams.persistence.dao.Tipo_movDAO;
import com.frontams.persistence.dto.MovimientoDTO;
import com.frontams.persistence.model.Movimiento;

import com.frontams.persistence.security.dto.Principal;

import java.util.Date;
import java.util.Map;
import org.mockito.cglib.beans.BulkBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MovimientoManager extends AbstractManager<Movimiento, MovimientoDTO>{
    
    @Autowired
    private MovimientoDAO movimientoDAO;
    
   @Override
    public AbstractBaseDAO dao() {
        return movimientoDAO;
    }
    
    @Override
    protected Movimiento create(Map<String, Object> data, Principal principal) throws Exception {
        Movimiento mov = new Movimiento(); 
        update(mov, data, principal);

        return mov;
    }
    
    @Override
    protected void update(Movimiento entity, Map<String, Object> data, Principal principal) {
              
        entity.setFecha((Date) data.get("fecha"));
        entity.setSaldo((Double) data.get("saldo"));
        entity.setTipo_mov((Integer) data.get("tipo_mov"));
    }
    
    @Override
    protected boolean inUse(Movimiento entity) { 
        if (entity.getMov_prod().isEmpty()) {
             return false; 
        }
        System.out.println("lista llena...");
        return true;
    }
    
    @Override
     protected WebResponseData del(Movimiento entity, Principal principal) throws Exception{ 
        if (!inUse(entity)) {                
            dao().delete(entity);
            return new WebResponseData();
        }       
         return new WebResponseData(450, "El movimiento no se puede eliminar");
     }
    
}
