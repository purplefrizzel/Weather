package com.purplefrizzel.weather.api.resources.weather;

import com.purplefrizzel.weather.api.models.ApiResponse;
import com.purplefrizzel.weather.api.models.dto.WeatherObservationsDTO;
import com.purplefrizzel.weather.api.models.weather.WeatherStation;
import com.purplefrizzel.weather.core.resources.ResourceFactory;
import com.purplefrizzel.weather.core.utils.Lang;
import com.purplefrizzel.weather.services.BBCApi;
import com.purplefrizzel.weather.services.weather.WeatherStationService;
import io.dropwizard.logback.shaded.checkerframework.checker.nullness.qual.Nullable;
import io.swagger.v3.oas.annotations.Operation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URISyntaxException;

@Path("/api/weather/")
@Produces(MediaType.APPLICATION_JSON)
public class WeatherStationResource {

    private final WeatherStationService weatherStationService;

    private WeatherStationResource(WeatherStationService weatherStationService) {
        this.weatherStationService = weatherStationService;
    }

    @Path("/{location}/station")
    @GET
    @Operation(
            summary = "This endpoint returns the current weather station for a given location.",
            description = "This endpoint returns the current weather station for a given location. "
                    + "A weather station updates every hour, a field is returned in the metadata with the last update timestamp.",
            tags = {"Weather"}
    )
    public ApiResponse<WeatherStation> getWeatherStation(@PathParam("location") String location, @QueryParam("lang") @DefaultValue("en") @Nullable Lang langQuery, @HeaderParam("X-Lang") @DefaultValue("en") Lang langHeader) throws IOException, URISyntaxException, InterruptedException {
        Lang lang = Lang.en;

        if (langHeader != null) {
            lang = langHeader;
        } else if (langQuery != null) {
            lang = langQuery;
        }

        WeatherStation weatherStation = weatherStationService.getWeatherStation(location, lang);

        WeatherObservationsDTO weatherObservationsDTO = BBCApi.observationsClient(location, lang, WeatherObservationsDTO.class);
        ApiResponse.Metadata metadata = new ApiResponse.Metadata();
        metadata.getResponseMetadata().put("lastStationUpdate", weatherObservationsDTO.getObservations()[0].getUpdateTimestamp());

        return new ApiResponse<>(weatherStation, metadata);
    }

    public static class Factory implements ResourceFactory<WeatherStationResource> {

        @Override
        public WeatherStationResource create() {
            WeatherStationService weatherStationService = new WeatherStationService();

            return new WeatherStationResource(weatherStationService);
        }
    }
}
