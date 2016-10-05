package com.todorov.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * Created by Alex on 05.10.2016.
 */

@Path("/injectdemo")
@Consumes (MediaType.TEXT_PLAIN)
@Produces (MediaType.TEXT_PLAIN)
public class InjectDemoResource {

    @GET
    @Path("/annotations")
    public String getParams(@MatrixParam("param") String param,
                            @HeaderParam("sessionID") String header,
                            @CookieParam("name") String name){
        return param + "\n" + header + "\n" + name;
    }

    @GET
    @Path("/context")
    public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders){
        return uriInfo.getBaseUri().toString() + "\n"
                + uriInfo.getAbsolutePath().toString() + "\n"
                + httpHeaders.getDate().toString() + "\n";

    }
}
