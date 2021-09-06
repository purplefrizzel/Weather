package com.purplefrizzel.weather.api.resources;

import com.codahale.metrics.annotation.Timed;
import com.purplefrizzel.weather.core.resources.ResourceFactory;
import io.swagger.v3.oas.annotations.Operation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/")
@Produces(MediaType.APPLICATION_JSON)
public class RootResource {

    @GET
    @Timed
    @Operation(
            summary = "The API root returns information about the API.",
            description = "The API root returns information about the API. " +
                    "For example it returns the current running version, the name of the API and links to docs.",
            tags = {"Meta"}
    )
    public String root() {
        return "{ \"name\": \"weather-api\", \"versions\": \"0.0.1.1-SNAPSHOT\", \"docs\": \"/api/docs/index.html\", \"openapi\": { \"json\": \"/openapi.json\", \"yaml\": \"/openapi.yaml\" } }";
    }

    public static class Factory implements ResourceFactory<RootResource> {

        @Override
        public RootResource create() {
            return new RootResource();
        }
    }
}
