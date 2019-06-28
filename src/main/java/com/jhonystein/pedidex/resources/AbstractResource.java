package com.jhonystein.pedidex.resources;

import com.jhonystein.pedidex.models.Entidade;
import com.jhonystein.pedidex.service.AbstractService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public abstract class AbstractResource<T extends Entidade> {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(
            @DefaultValue("20") @QueryParam("pageSize") Integer pageSize,
            @DefaultValue("1") @QueryParam("page") Integer page,
            @QueryParam("filterField") String filterField,
            @QueryParam("filterData") String filterData,
            @QueryParam("sort") String sort
    ) {
        Long total = getService().getCount(filterField, filterData);
        Response.Status responseStatus = (page * pageSize < total) ? Response.Status.PARTIAL_CONTENT : Response.Status.OK; 
        Response response = Response.status(responseStatus)
                .entity(getService().findAll(pageSize, page, filterField, filterData, sort)).build();
        response.getHeaders().add("X-Total-Length", total);
        response.getHeaders().add("X-Page-Size", pageSize);
        response.getHeaders().add("X-Current-Page", page);
                
        return response;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(T bean) {
        return Response
                .status(Response.Status.CREATED)
                .entity(getService().insert(bean)).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, T bean) {
        if (!id.equals(bean.getId())) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("ID do objeto difere do ID da URL")
                    .build();
        }
        return Response.ok(getService().update(bean)).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") Long id) {
        return Response.ok(getService().findOne(id)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response remove(@PathParam("id") Long id) {
        getService().remove(id);
        return Response
                .status(Response.Status.NO_CONTENT)
                .build();
    }

    protected abstract AbstractService<T> getService();
}
