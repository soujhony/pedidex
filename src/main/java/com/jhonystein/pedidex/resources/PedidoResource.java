package com.jhonystein.pedidex.resources;

import com.jhonystein.pedidex.models.Pedido;
import com.jhonystein.pedidex.service.AbstractService;
import com.jhonystein.pedidex.service.PedidoService;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/pedidos")
public class PedidoResource extends AbstractResource<Pedido>{

    @Inject
    private PedidoService service;

    @Override
    protected AbstractService<Pedido> getService() {
        return service;
    }
    
}
