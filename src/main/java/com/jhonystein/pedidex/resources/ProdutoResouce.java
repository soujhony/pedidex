package com.jhonystein.pedidex.resources;

import com.jhonystein.pedidex.models.Produto;
import com.jhonystein.pedidex.service.AbstractService;
import com.jhonystein.pedidex.service.ProdutoService;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/produtos")
public class ProdutoResouce extends AbstractResource<Produto>{

    @Inject
    private ProdutoService service;
    
    @Override
    protected AbstractService<Produto> getService() {
        return service;
    }
    
}
