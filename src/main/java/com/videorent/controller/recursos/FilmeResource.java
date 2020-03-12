package com.videorent.controller.recursos;

import com.videorent.business.model.Filme;
import com.videorent.business.service.IFilmeService;
import com.videorent.exception.BusinessException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/filme")
public class FilmeResource {

    private static final Logger logger = LogManager.getLogger(FilmeResource.class);

    @Inject
    IFilmeService service;

    @POST
    @Path("/inserir")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response inserir(Filme filme){

        try {
            service.inserir(filme);
        } catch (BusinessException e) {
            logger.error("Erro {}", e);
        }
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        return Response.ok().entity(service.findAll()).build();
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id){
        return Response.ok().entity(service.findById(id)).build();
    }

    @DELETE
    @Path("/remover/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response remover(@PathParam("id")Long id){
        try {
            service.remover(id);
        } catch (BusinessException e) {
            logger.error("Erro {}", e);
        }
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Path("/atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(Filme filme){
        try {
            return Response.ok().entity(service.atualizar(filme)).build();
        } catch (BusinessException e) {
            logger.error("Erro {}", e);
        }
        return Response.status(Response.Status.OK).build();
    }
}
