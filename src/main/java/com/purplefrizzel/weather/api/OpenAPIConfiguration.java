package com.purplefrizzel.weather.api;

import io.swagger.v3.oas.integration.SwaggerConfiguration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OpenAPIConfiguration {

    private static OpenAPI info() {
        OpenAPI openAPI = new OpenAPI();
        Info info = new Info()
                .title("Weather API")
                .description("The Weather REST API")
                .version("0.0.1");

        openAPI.info(info);
        return openAPI;
    }

    public static SwaggerConfiguration configuration() {
        return new SwaggerConfiguration()
                .openAPI(info())
                .prettyPrint(true)
                .resourcePackages(Stream.of("com.purplefrizzel.weather").collect(Collectors.toSet()));
    }
}
