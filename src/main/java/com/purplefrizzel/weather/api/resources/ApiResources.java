package com.purplefrizzel.weather.api.resources;

import com.purplefrizzel.weather.api.OpenAPIConfiguration;
import com.purplefrizzel.weather.api.resources.weather.WeatherReportResource;
import com.purplefrizzel.weather.api.resources.weather.WeatherStationResource;
import io.dropwizard.setup.Environment;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;

public class ApiResources {

    public static void register(Environment environment) {
        environment.jersey().register(rootResource());
        environment.jersey().register(weatherStationResource());
        environment.jersey().register(weatherReportResource());
        environment.jersey().register(new OpenApiResource().openApiConfiguration(OpenAPIConfiguration.configuration()));
    }

    private static RootResource rootResource() {
        return new RootResource.Factory().create();
    }

    private static WeatherStationResource weatherStationResource() {
        return new WeatherStationResource.Factory().create();
    }

    private static WeatherReportResource weatherReportResource() {
        return new WeatherReportResource.Factory().create();
    }
}
