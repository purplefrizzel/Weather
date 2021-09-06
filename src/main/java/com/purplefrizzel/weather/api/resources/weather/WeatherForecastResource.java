package com.purplefrizzel.weather.api.resources.weather;

import com.purplefrizzel.weather.api.models.ApiResponse;
import com.purplefrizzel.weather.api.models.dto.WeatherObservationsDTO;
import com.purplefrizzel.weather.api.models.weather.WeatherForecast;
import com.purplefrizzel.weather.core.resources.ResourceFactory;
import com.purplefrizzel.weather.core.utils.Lang;
import com.purplefrizzel.weather.services.BBCApi;
import com.purplefrizzel.weather.services.weather.WeatherForecastService;
import io.dropwizard.logback.shaded.checkerframework.checker.nullness.qual.Nullable;
import io.swagger.v3.oas.annotations.Operation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URISyntaxException;

@Path("/api/weather/")
@Produces(MediaType.APPLICATION_JSON)
public class WeatherForecastResource {

    private final WeatherForecastService weatherForecastService;

    public WeatherForecastResource(WeatherForecastService weatherForecastService) {
        this.weatherForecastService = weatherForecastService;
    }

    @Path("/{location}")
    @GET
    @Operation(
            summary = "This endpoint returns the current weather forecast for a given location.",
            description = "This endpoint returns the current weather forecast for a given location. "
                    + "A weather forecast is more detailed compared to a report.",
            tags = {"Weather"}
    )
    public ApiResponse<WeatherForecast> getWeatherForecast(@PathParam("location") String location, @QueryParam("lang") @DefaultValue("en") @Nullable Lang langQuery, @HeaderParam("X-Lang") @DefaultValue("en") Lang langHeader) throws IOException, URISyntaxException, InterruptedException {
        Lang lang = Lang.en;

        if (langHeader != null) {
            lang = langHeader;
        } else if (langQuery != null) {
            lang = langQuery;
        }

        WeatherForecast weatherForecast = weatherForecastService.getWeatherForecast(location, lang);

        WeatherObservationsDTO weatherObservationsDTO = BBCApi.observationsClient(location, lang, WeatherObservationsDTO.class);
        ApiResponse.Metadata metadata = new ApiResponse.Metadata();
        metadata.getResponseMetadata().put("lastStationUpdate", weatherObservationsDTO.getObservations()[0].getUpdateTimestamp());

        return new ApiResponse<>(weatherForecast, metadata);
    }

    public static class Factory implements ResourceFactory<WeatherForecastResource> {

        @Override
        public WeatherForecastResource create() {
            return new WeatherForecastResource(new WeatherForecastService());
        }
    }
}
