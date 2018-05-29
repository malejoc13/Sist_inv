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
import com.frontams.persistence.dao.ProductoDAO;
import com.frontams.persistence.dao.ProveedorDAO;
import com.frontams.persistence.dao.Tipo_prodDAO;
import com.frontams.persistence.dao.Un_medidaDAO;
import com.frontams.persistence.security.dto.Principal;
import com.frontams.persistence.dto.ProductoDTO; 
import com.frontams.persistence.model.Producto;
import com.frontams.persistence.model.Proveedor;
import com.frontams.persistence.model.Tipo_prod;
import com.frontams.persistence.model.Un_medida;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductoManager extends AbstractManager<Producto, ProductoDTO>{
    
    @Autowired
    private ProductoDAO productoDAO;
    
    @Autowired
    private ProveedorDAO proveedorDAO;
    
    @Autowired
    private Tipo_prodDAO tipo_prodDAO;
    
    @Autowired
    private Un_medidaDAO un_medidaDAO;
      
    @Override
    public AbstractBaseDAO dao() {
        return productoDAO;
    }
    
    @Override
    protected Producto create(Map<String, Object> data, Principal principal) throws Exception {
        Producto tp = new Producto(); 
        if (productoDAO.exist((String) data.get("clave"))) {
             throw new RuntimeException("Ya existe un Producto con esta clave");
        } else {
            update(tp, data, principal);
        }
        return tp;
    }

    @Override
    protected void update(Producto entity, Map<String, Object> data, Principal principal) { 
        if (entity.getClave() != null) {
            if (productoDAO.exist((String) data.get("clave")) && !entity.getClave().equals((String) data.get("clave"))) {
                 throw new RuntimeException("Ya existe un Producto con esta clave");
            }
        }
        entity.setName((String) data.get("name"));
        entity.setClave((String) data.get("clave"));
        entity.setClave_sat((String) data.get("clave_sat"));
        entity.setDescripcion((String) data.get("descripcion"));
        entity.setFecha_alta((Date) data.get("fecha_alta"));
        entity.setPrecio_max((Double) data.get("precio_max"));
        entity.setPrecio_min((Double) data.get("precio_min"));
        entity.setPrecio_costo((Double) data.get("precio_costo"));
        
        Long idprov = (Long) data.get("proveedorId");         
        Proveedor proveedor = proveedorDAO.findById(idprov);         
        entity.setProveedor(proveedor);
        
        Tipo_prod tipo_prod = tipo_prodDAO.findById((Long) data.get("tipo_prodId"));
        entity.setTipo_prod(tipo_prod);
        
        Un_medida un_medida = un_medidaDAO.findById((Long) data.get("un_medidaId"));
        entity.setUn_medida(un_medida);
    }
    
    @Override
    protected boolean inUse(Producto entity) { 
        if (entity.getInventario().isEmpty()) {
             return false;
        }
        System.out.println("lista llena...");
        return true;  
    }
    
    private boolean inMovUse(Producto entity) { 
        if (entity.getMov_prod().isEmpty()) {
             return false;
        }        
        return true;  
    }
    
    @Override
     protected WebResponseData del(Producto entity, Principal principal) throws Exception{ 
        if (inUse(entity)) {                
             return new WebResponseData(450, "El producto "+entity.getName()+" no se puede eliminar, a&uacute;n cuenta con existencia en el inventario");
        } 
        if (inMovUse(entity)) {                
             return new WebResponseData(450, "El producto "+entity.getName()+" no se puede eliminar, a&uacute;n se le hace referencia en los movimientos");
        }
        dao().delete(entity);
            return new WebResponseData();
        
     }
    
}
