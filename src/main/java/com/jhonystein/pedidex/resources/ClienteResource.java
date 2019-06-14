package com.jhonystein.pedidex.resources;

import com.jhonystein.pedidex.models.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {
    
    @PersistenceContext
    private EntityManager em;
    
    @GET
    public List<Cliente> findAll() {
        TypedQuery<Cliente> query = em.createQuery("select c from Cliente c", Cliente.class);
        return query.getResultList();
    }
    
    @POST
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Response insert(Cliente cliente) {
        em.persist(cliente);
        return Response
                .status(Response.Status.CREATED)
                .entity(cliente).build();
    }
    
    @PUT
    @Path("/{id}")
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Response update(@PathParam("id") Long id, Cliente cliente) {
        if (!id.equals(cliente.getId())){
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("ID do objeto difere do ID da URL")
                    .build();
        }
        em.merge(cliente);
        return Response.ok(cliente).build();
    }
    
    @GET
    @Path("/{id}")
    public Response find(@PathParam("id") Long id) {
        Cliente cliente = em.find(Cliente.class, id);
        return Response.ok(cliente).build();
    }
    
    @DELETE
    @Path("/{id}")
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Response remove(@PathParam("id") Long id) {
        Cliente cliente = em.getReference(Cliente.class, id);
        em.remove(cliente);
        return Response
                .status(Response.Status.NO_CONTENT)
                .build();
    }
}
