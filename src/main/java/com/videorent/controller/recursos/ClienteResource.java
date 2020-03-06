package com.videorent.controller.recursos;

import com.videorent.business.model.Cliente;
import com.videorent.business.service.IClienteService;
import com.videorent.exception.BusinessException;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cliente")
public class ClienteResource {

    @Inject
    IClienteService service;

    @POST
    @Path("/inserir")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response inserir(Cliente cliente){

        try {
            service.inserir(cliente);
        } catch (BusinessException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientes(){
        return Response.ok().entity(service.findAll()).build();
    }


}
