package com.purplefrizzel.weather.api.resources.location;

import com.purplefrizzel.weather.api.models.ApiResponse;
import com.purplefrizzel.weather.api.models.location.WeatherLocation;
import com.purplefrizzel.weather.core.resources.ResourceFactory;
import com.purplefrizzel.weather.core.utils.Lang;
import com.purplefrizzel.weather.services.location.WeatherLocationService;
import io.dropwizard.logback.shaded.checkerframework.checker.nullness.qual.Nullable;
import io.swagger.v3.oas.annotations.Operation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URISyntaxException;

@Path("/api/location/")
@Produces(MediaType.APPLICATION_JSON)
public class WeatherLocationResource {

    private final WeatherLocationService weatherLocationService;

    public WeatherLocationResource(WeatherLocationService weatherLocationService) {
        this.weatherLocationService = weatherLocationService;
    }

    @Path("/{location}")
    @GET
    @Operation(
            summary = "Gets location information.",
            description = "This endpoint gets location information. For example the weather warning ID and geo ID for the location",
            tags = {"Location"}
    )
    public ApiResponse<WeatherLocation> getWeatherLocation(@PathParam("location") String location, @QueryParam("lang") @DefaultValue("en") @Nullable Lang langQuery, @HeaderParam("X-Lang") @DefaultValue("en") Lang langHeader) throws URISyntaxException, IOException, InterruptedException {
        Lang lang = Lang.en;

        if (langHeader != null) {
            lang = langHeader;
        } else if (langQuery != null) {
            lang = langQuery;
        }

        WeatherLocation weatherLocation = weatherLocationService.getWeatherLocation(location, lang);

        return new ApiResponse<>(weatherLocation, new ApiResponse.Metadata());
    }

    public static class Factory implements ResourceFactory<WeatherLocationResource> {

        @Override
        public WeatherLocationResource create() {
            return new WeatherLocationResource(new WeatherLocationService());
        }
    }
}
