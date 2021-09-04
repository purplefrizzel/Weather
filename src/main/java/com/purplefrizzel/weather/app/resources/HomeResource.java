package com.purplefrizzel.weather.app.resources;

import com.purplefrizzel.weather.app.views.HomeView;
import com.purplefrizzel.weather.core.resources.ResourceFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class HomeResource {

    @GET
    public HomeView getHome() {
        return new HomeView();
    }

    public static class Factory implements ResourceFactory<HomeResource> {

        @Override
        public HomeResource create() {
            return new HomeResource();
        }
    }
}
