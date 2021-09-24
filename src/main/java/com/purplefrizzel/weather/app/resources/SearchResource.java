package com.purplefrizzel.weather.app.resources;

import com.purplefrizzel.weather.api.models.location.WeatherLocation;
import com.purplefrizzel.weather.app.views.SearchView;
import com.purplefrizzel.weather.core.resources.ResourceFactory;
import com.purplefrizzel.weather.core.utils.Lang;
import com.purplefrizzel.weather.services.location.WeatherLocationService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URISyntaxException;

@Path("/search")
@Produces(MediaType.TEXT_HTML)
public class SearchResource {

    private final WeatherLocationService locationService;

    public SearchResource(WeatherLocationService locationService) {
        this.locationService = locationService;
    }

    @POST
    public SearchView search(@FormParam("query") String query) {
        WeatherLocation[] locations = new WeatherLocation[0];

        try {
            locations = locationService.getWeatherLocations(query, Lang.en);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new SearchView(query, locations);
    }

    public static class Factory implements ResourceFactory<SearchResource> {

        @Override
        public SearchResource create() {
            return new SearchResource(new WeatherLocationService());
        }
    }
}
