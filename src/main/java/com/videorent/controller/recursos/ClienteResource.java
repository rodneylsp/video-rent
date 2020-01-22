package com.videorent.controller.recursos;

import com.videorent.business.model.Cliente;
import com.videorent.business.service.IClienteService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

        service.inserir(cliente);

        return Response.status(Response.Status.OK).build();
    }


}
