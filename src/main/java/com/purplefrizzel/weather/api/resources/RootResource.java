package com.purplefrizzel.weather.api.resources;

import com.codahale.metrics.annotation.Timed;
import com.purplefrizzel.weather.core.resources.ResourceFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class RootResource {

    @GET
    @Timed
    public String root() {
        return "{ \"name\": \"weather-api\", \"versions\": \"0.0.1\", \"docs\": \"/api/docs\" }";
    }

    public static class Factory implements ResourceFactory<RootResource> {

        @Override
        public RootResource create() {
            return new RootResource();
        }
    }
}
