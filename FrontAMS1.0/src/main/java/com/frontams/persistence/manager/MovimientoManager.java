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
    
    
    
}
