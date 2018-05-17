/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frontams.persistence.dao;

/**
 *
 * @author Sistemas
 */
import com.frontams.common.dao.AbstractBaseDAO;
import com.frontams.common.dto.NomenclatorClaveDTO;
import com.frontams.persistence.dto.Inv_historicoDTO;
import com.frontams.persistence.dto.ProductoDTO;  
import com.frontams.persistence.model.Inv_historico;
import com.frontams.persistence.model.Producto;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

@Repository
public class Inv_historicoDAO extends AbstractBaseDAO<Inv_historico, Inv_historicoDTO>{
    
    public Criteria buildCriteria() {
        return getCriteria()  //entidad   //alias
                .createAlias("inventario", "inventario")
                .createAlias("inventario.producto", "producto")
                .createAlias("producto.un_medida", "un_medida")
                .createAlias("inventario.unidad", "unidad");
    }
    
    public void addOrder(Criteria criteria) {
        criteria.addOrder(Order.asc("producto.clave"));
    }
    
    @Override
    public void applyListProjection(Criteria criteria) {
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id")) 
                .add(Projections.property("inventario.id").as("inventarioId")) 
                .add(Projections.property("cantidad_old").as("cantidad_old"))
                .add(Projections.property("cantidad_new").as("cantidad_new"))
                .add(Projections.property("fecha").as("fecha"))
                .add(Projections.property("producto.name").as("producto"))
                .add(Projections.property("producto.clave").as("productoClave"))
                .add(Projections.property("producto.descripcion").as("descripcion"))
                .add(Projections.property("un_medida.clave").as("umClave"))
                .add(Projections.property("un_medida.nombre_um").as("umNombre"))
                .add(Projections.property("unidad.name").as("unidad"))
                .add(Projections.property("unidad.id").as("unidadId"));
                                           //alias[.atrib]   //atributo en el DTO
        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(Inv_historicoDTO.class));
    }
    
}
