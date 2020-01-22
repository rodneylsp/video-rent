package com.videorent.controller.recursos;

import com.videorent.business.model.Filme;
import com.videorent.business.service.IFilmeService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/filme")
public class FilmeResource {

    @Inject
    IFilmeService service;

    @POST
    @Path("/inserir")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response inserir(Filme filme){

        service.inserir(filme);

        return Response.status(Response.Status.OK).build();
    }
}
