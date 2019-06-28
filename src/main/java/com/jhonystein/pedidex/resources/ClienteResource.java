package com.jhonystein.pedidex.resources;

import com.jhonystein.pedidex.models.Cliente;
import com.jhonystein.pedidex.service.AbstractService;
import com.jhonystein.pedidex.service.ClienteService;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/clientes")
public class ClienteResource extends AbstractResource<Cliente> {

    @Inject
    private ClienteService service;

    @Override
    protected AbstractService<Cliente> getService() {
        return service;
    }

}
