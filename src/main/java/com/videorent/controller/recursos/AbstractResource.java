package com.videorent.controller.recursos;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

public abstract class AbstractResource {

    @GET
    @Path("/ping")
    public Response ping(){
        return Response.ok().entity("Serviço online").build();
    }

}
