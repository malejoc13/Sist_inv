/*
 @Autor: Roberto Rodriguez
 Email: robertoSoftwareEngineer@gmail.com

 @Copyright 2016 
 */
package com.frontams.common.manager;

import com.frontams.common.dao.AbstractBaseDAO; 
import com.frontams.common.dto.ListRequestDTO;
import com.frontams.common.dto.NomenclatorDTO;
import com.frontams.common.model.BaseEntity;
import com.frontams.common.util.response.WebResponse;
import com.frontams.common.util.response.WebResponseData;
import com.frontams.persistence.security.dto.Principal;
import java.util.List;
import java.util.Map;
import org.hibernate.criterion.Criterion;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rrodriguez
 */
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public abstract class AbstractManager<T extends BaseEntity, D> {

    public Map pageList(ListRequestDTO request) {
        return dao().pageList(request);
    }

    public List<NomenclatorDTO> nomenclatorList(List<Criterion> expressions) {
        System.out.println("Expressions ..."+expressions.toString());
        return dao().nomenclatorList(expressions);
    }

    public D load(List<Criterion> expressions) {
        D entity = (D) dao().load(expressions);
        completeLoad(entity);
        return entity;
    }

    public D load(Long id) {
        D entity = (D) dao().load(id);
        completeLoad(entity);
        return entity;
    }

    protected void completeLoad(D dto) {
        // override this method if need add more things to the DTO
    }

    public abstract AbstractBaseDAO dao();
    //reimplementar en todas las Manager
    protected T create(Map<String, Object> data, Principal principal) throws Exception{ return null;}
    protected void update(T entity, Map<String, Object> data, Principal principal) throws Exception{}    
    protected boolean inUse(T entity) throws Exception{ return false;}
    protected WebResponseData del(T entity, Principal principal) throws Exception{ 
        dao().delete(entity);
        return new WebResponseData();
    }
    
    public WebResponseData delete(Map<String, Object> data, Principal principal) throws Exception{
        T entity;
        Long id = (Long) data.get("id");
        entity = (T) dao().findById(id);
        
        return del(entity, principal);        
    }

    public Long save(Map<String, Object> data, Principal principal) throws Exception {
        System.out.println("AbstractManager -> creating...");
        System.out.println(data);
        T entity;
        Boolean creating = (data == null || !data.containsKey("id"));
        System.out.println("AbstractManager -> creating = " + creating);
       
        if (creating) {
            
            entity = create(data, principal);
           
        } else {
            Long id = (Long) data.get("id");
            entity = (T) dao().findById(id); 
            if (entity != null) {
                update(entity, data, principal);
            }
        }

        entity = (T) dao().saveOrUpdate(entity);

        if (creating) {
            afterCreate(entity);
        }

        return entity.getId();
       
    }

    public T findById(Long id) {
        return (T) dao().findById(id);
    }
    //devuelve el valor del campo propertyName dado su ID
    public Object getPropertyValueFromEntityId(Long entityId, String propertyName) {
        return dao().getPropertyValueFromEntityId(entityId, propertyName);
    }

    protected void afterCreate(T entity) {
    } //Redefine if need to do something after save
}
