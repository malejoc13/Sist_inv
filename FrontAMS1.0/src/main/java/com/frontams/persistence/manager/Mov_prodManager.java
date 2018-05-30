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
import com.frontams.persistence.dao.Mov_prodDAO;
import com.frontams.persistence.dao.MovimientoDAO;
import com.frontams.persistence.dao.ProductoDAO;
import com.frontams.persistence.dto.Mov_prodDTO;
import com.frontams.persistence.model.Mov_prod;
import com.frontams.persistence.model.Movimiento;
import com.frontams.persistence.model.Producto;

import com.frontams.persistence.security.dto.Principal;
import java.util.Date;
import java.util.Map;
import org.mockito.cglib.beans.BulkBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Mov_prodManager extends AbstractManager<Mov_prod, Mov_prodDTO>{
    
    @Autowired
    private Mov_prodDAO mov_prodDAO;
    
    @Autowired
    private MovimientoDAO movimientoDAO;
    
    @Autowired
    private ProductoDAO productoDAO;
    
    @Override
    public AbstractBaseDAO dao() {
        return mov_prodDAO;
    }
    
    @Override
    protected Mov_prod create(Map<String, Object> data, Principal principal) throws Exception {
             
        Mov_prod mov_prod = new Mov_prod(); 
        if (mov_prodDAO.exist((Long) data.get("productoId"), (Long) data.get("movimientoId")) != null) {
                throw new RuntimeException("Este producto ya se encuentra registrado en el movimiento.");
            }
        update(mov_prod, data, principal);

        return mov_prod;
    }
    
    @Override
    protected void update(Mov_prod entity, Map<String, Object> data, Principal principal) {
        Long productoId = (Long) data.get("productoId");
        Long movimientoId = (Long) data.get("movimientoId");       
                 
        entity.setCantidad((Double) data.get("cantidad"));
        
        Producto prod = productoDAO.findById(productoId);
        entity.setProducto(prod);     
        
        Movimiento mov = movimientoDAO.findById(movimientoId);
        entity.setMovimiento(mov); 
    }
    
}
