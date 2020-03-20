package com.videorent.controller.cors;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {

        //definindo o dominio(protocolo + host + porta)de origem. Poderia ter colocado apenas '*'
        containerResponseContext.getHeaders().add(
                "Access-Control-Allow-Origin", "http://localhost:4200");
        containerResponseContext.getHeaders().add(
                "Access-Control-Allow-Credentials", "true");
        containerResponseContext.getHeaders().add(
                "Access-Control-Allow-Headers",
                "origin, content-type, accept, authorization");
        containerResponseContext.getHeaders().add(
                "Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS, HEAD");
    }
}
