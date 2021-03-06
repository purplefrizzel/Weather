package com.purplefrizzel.weather.api.resources.weather;

import com.purplefrizzel.weather.api.models.ApiResponse;
import com.purplefrizzel.weather.api.models.weather.WeatherReport;
import com.purplefrizzel.weather.core.resources.ResourceFactory;
import com.purplefrizzel.weather.core.utils.Lang;
import com.purplefrizzel.weather.services.weather.WeatherReportService;
import io.dropwizard.logback.shaded.checkerframework.checker.nullness.qual.Nullable;
import io.swagger.v3.oas.annotations.Operation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URISyntaxException;

@Path("/api/weather/")
@Produces(MediaType.APPLICATION_JSON)
public class WeatherReportResource {

    private final WeatherReportService weatherReportService;

    public WeatherReportResource(WeatherReportService weatherReportService) {
        this.weatherReportService = weatherReportService;
    }

    @Path("/{location}/report")
    @GET
    @Operation(
            summary = "This endpoint returns the current weather report for a given location.",
            description = "This endpoint returns the current weather report for a given location. "
                    + "A weather report is less detailed compared to a forecast.",
            tags = {"Weather"}
    )
    public ApiResponse<WeatherReport> getWeatherReport(@PathParam("location") String location, @QueryParam("lang") @DefaultValue("en") @Nullable Lang langQuery, @HeaderParam("X-Lang") @DefaultValue("en") Lang langHeader) throws IOException, URISyntaxException, InterruptedException {
        Lang lang = Lang.en;

        if (langHeader != null) {
            lang = langHeader;
        } else if (langQuery != null) {
            lang = langQuery;
        }

        WeatherReport weatherReport = weatherReportService.getWeatherReport(location, lang);

        return new ApiResponse<>(weatherReport, new ApiResponse.Metadata());
    }

    @GET
    @Path("/{location}/forecast")
    public ApiResponse<WeatherReport[]> getWeatherForecast(@PathParam("location") String location, @QueryParam("lang") @DefaultValue("en") @Nullable Lang langQuery, @HeaderParam("X-Lang") @DefaultValue("en") Lang langHeader) throws IOException, URISyntaxException, InterruptedException {
        Lang lang = Lang.en;

        if (langHeader != null) {
            lang = langHeader;
        } else if (langQuery != null) {
            lang = langQuery;
        }

        WeatherReport[] weatherReports = weatherReportService.getWeatherReports(location, lang);

        return new ApiResponse<>(weatherReports, new ApiResponse.Metadata());
    }

    public static class Factory implements ResourceFactory<WeatherReportResource> {

        @Override
        public WeatherReportResource create() {
            WeatherReportService weatherReportService = new WeatherReportService();

            return new WeatherReportResource(weatherReportService);
        }
    }
}
