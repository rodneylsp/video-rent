package com.videorent.controller.recursos;

import com.videorent.business.model.Aluguel;
import com.videorent.business.service.IAluguelService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/box")
public class BoxResource {

    @Inject
    IAluguelService service;

    @POST
    @Path("/inserir")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response inserir(Aluguel aluguel){

        service.inserir(aluguel);

        return Response.status(Response.Status.OK).build();
    }

}
