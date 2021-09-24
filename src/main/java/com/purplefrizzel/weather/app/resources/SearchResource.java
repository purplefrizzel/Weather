package com.purplefrizzel.weather.app.resources;

import com.purplefrizzel.weather.api.models.location.WeatherLocation;
import com.purplefrizzel.weather.app.views.SearchView;
import com.purplefrizzel.weather.core.resources.ResourceFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/search")
@Produces(MediaType.TEXT_HTML)
public class SearchResource {

    @POST
    public SearchView search(@FormParam("query") String query) {
        WeatherLocation[] locations = {};

        return new SearchView(query, locations);
    }

    public static class Factory implements ResourceFactory<SearchResource> {

        @Override
        public SearchResource create() {
            return new SearchResource();
        }
    }
}
