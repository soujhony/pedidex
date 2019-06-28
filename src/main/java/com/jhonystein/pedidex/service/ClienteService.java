package com.jhonystein.pedidex.service;

import com.jhonystein.pedidex.models.Cliente;
import com.jhonystein.pedidex.utils.GenericDao;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ClienteService extends AbstractService<Cliente> {
    
    @Inject
    private GenericDao<Cliente> dao;

    @Override
    protected GenericDao<Cliente> getDao() {
        return dao;
    }
}
