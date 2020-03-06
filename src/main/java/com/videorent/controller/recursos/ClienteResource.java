package com.videorent.controller.recursos;

import com.videorent.business.model.Cliente;
import com.videorent.business.service.IClienteService;
import com.videorent.exception.BusinessException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cliente")
public class ClienteResource {

    private static final Logger logger = LogManager.getLogger(ClienteResource.class);

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
            logger.error("Erro {}", e);
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
