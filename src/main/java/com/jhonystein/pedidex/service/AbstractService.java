package com.jhonystein.pedidex.service;

import com.jhonystein.pedidex.models.Entidade;
import com.jhonystein.pedidex.utils.GenericDao;
import java.util.List;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.validation.Valid;

public abstract class AbstractService<T extends Entidade> {
    
    public List<T> findAll(Integer pageSize, Integer pageNumber, String filterField, String filterData, String order) {
        return getDao().findAll(pageSize, pageNumber, filterField, filterData, order);
    }
    
    public List<T> findAll(String filterField, String filterData, String order) {
        return getDao().findAll(filterField, filterData, order);
    }
    
    public Long getCount(String filterField, String filterData) {
        return getDao().getCount(filterField, filterData);
    }
    
    public T findOne(Long id) {
        return getDao().find(id);
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public T insert(@Valid T bean) {
        return getDao().insert(bean);
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public T update(@Valid T bean) {
        return getDao().update(bean);
    }
    
    public void remove(Long id) {
        getDao().delete(id);
    }
    
    protected abstract GenericDao<T> getDao();
    
}
