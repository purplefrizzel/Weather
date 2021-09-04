package com.purplefrizzel.weather.api.resources.weather;

import com.purplefrizzel.weather.api.models.ApiResponse;
import com.purplefrizzel.weather.api.models.weather.WeatherForecast;
import com.purplefrizzel.weather.core.utils.Lang;
import com.purplefrizzel.weather.services.weather.WeatherForecastService;
import io.dropwizard.logback.shaded.checkerframework.checker.nullness.qual.Nullable;

import javax.ws.rs.*;

@Path("/api/weather/")
public class WeatherForecastResource {

    private final WeatherForecastService weatherForecastService;

    public WeatherForecastResource(WeatherForecastService weatherForecastService) {
        this.weatherForecastService = weatherForecastService;
    }

    @Path("/{location}")
    @GET
    public ApiResponse<WeatherForecast> getWeatherForecast(@PathParam("location") String location, @QueryParam("lang") @DefaultValue("en") @Nullable Lang langQuery, @HeaderParam("X-Lang") @DefaultValue("en") Lang langHeader) {
        Lang lang = Lang.en;

        if (langHeader != null) {
            lang = langHeader;
        } else if (langQuery != null) {
            lang = langQuery;
        }

        return null;
    }
}
