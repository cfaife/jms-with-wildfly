package com.clerio.jmsinwildfly;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/generics")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class GenericResource {

    @Inject
    private JMSService jmsService;

    @GET
    public Response getString(){
        jmsService.send("one more clerio message");
        return Response.ok("Clerio's String").build();
    }
}
