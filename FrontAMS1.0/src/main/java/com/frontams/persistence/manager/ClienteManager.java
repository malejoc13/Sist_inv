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
import com.frontams.persistence.dao.ClienteDAO;
import com.frontams.persistence.dto.ClienteDTO;
import com.frontams.persistence.security.dto.Principal;
import com.frontams.persistence.model.Cliente;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClienteManager extends AbstractManager<Cliente, ClienteDTO>{
    
    @Autowired
    private ClienteDAO cliente;
      
    @Override
    public AbstractBaseDAO dao() {
        return cliente;
    }
    
    @Override
    protected Cliente create(Map<String, Object> data) throws Exception {
        Cliente tp = new Cliente(); 
        update(tp, data);

        return tp;
    }
    
    @Override
    protected void update(Cliente entity, Map<String, Object> data) { 
        entity.setName((String) data.get("name"));
        entity.setLastName((String) data.get("lastName"));
        entity.setDireccion((String) data.get("direccion"));
        entity.setTelefono((String) data.get("telefono"));       
        entity.setEmail((String) data.get("email"));
        entity.setFecha_nac((Date) data.get("fecha_nac"));
        entity.setCredito_max((Double) data.get("credito_max"));
    }
    
    @Override
     protected WebResponseData del(Cliente entity, Principal principal) throws Exception{ 
        //if (!inUse(entity)) {                
            dao().delete(entity);
            return new WebResponseData();
        //}       
        // return new WebResponseData(450, "El proveedor "+entity.getName()+" no se puede eliminar, existen produtos que son suministrados por &eacute;l");
     }
}
