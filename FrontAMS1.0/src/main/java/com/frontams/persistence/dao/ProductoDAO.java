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
import com.frontams.persistence.dto.ProductoDTO;  
import com.frontams.persistence.model.Producto;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoDAO extends AbstractBaseDAO<Producto, ProductoDTO>{
    
    //alias de las otras entidades pra cuando indexas datos de otra tabla
   
    public Criteria buildCriteria() {
        return getCriteria()  //entidad   //alias
                .createAlias("proveedor", "proveedor")
                .createAlias("un_medida", "un_medida")
                .createAlias("tipo_prod", "tipo_prod");
    }

    //criterio para ordenar
    public void addOrder(Criteria criteria) {
        criteria.addOrder(Order.asc("name"));
    } 

    //campos a devolver en la consulta
    @Override
    public void applyListProjection(Criteria criteria) {
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id"))                                                
                .add(Projections.property("name").as("name"))
                .add(Projections.property("clave").as("clave"))
                .add(Projections.property("descripcion").as("descripcion"))
                .add(Projections.property("fecha_alta").as("fecha_alta"))   
                .add(Projections.property("precio_max").as("precio_max"))
                .add(Projections.property("precio_min").as("precio_min"))
                .add(Projections.property("precio_costo").as("precio_costo"))
                .add(Projections.property("proveedor.name").as("proveedor"))                
                .add(Projections.property("proveedor.id").as("proveedorId"))
                .add(Projections.property("un_medida.nombre_um").as("un_medida"))
                .add(Projections.property("un_medida.id").as("un_medidaId"))
                .add(Projections.property("tipo_prod.name").as("tipo_prod"))
                .add(Projections.property("tipo_prod.id").as("tipo_prodId"));
                                           //alias[.atrib]   //atributo en el DTO
        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(ProductoDTO.class));
    }
    
}
