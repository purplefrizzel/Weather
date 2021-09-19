package com.purplefrizzel.weather;

import com.purplefrizzel.weather.api.resources.ApiResources;
import com.purplefrizzel.weather.app.resources.AppResources;
import com.purplefrizzel.weather.core.configurations.WeatherApplicationConfiguration;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import io.swagger.v3.oas.integration.SwaggerConfiguration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WeatherApplication extends Application<WeatherApplicationConfiguration> {

    public static void main(String[] args) throws Exception {
        new WeatherApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<WeatherApplicationConfiguration> bootstrap) {
        super.initialize(bootstrap);

        bootstrap.addBundle(new AssetsBundle("/assets/js", "/assets/js", null, "js"));
        bootstrap.addBundle(new AssetsBundle("/assets/imgs", "/assets/imgs", null, "images"));
        bootstrap.addBundle(new AssetsBundle("/assets/css/", "/assets/css", null, "css"));
        bootstrap.addBundle(new AssetsBundle("/assets/robots.txt", "/robots.txt", null, "robots-txt"));
        bootstrap.addBundle(new AssetsBundle("/assets/favicon.ico", "/favicon.ico", null, "favicon"));
        bootstrap.addBundle(new AssetsBundle("/swagger-ui", "/api/docs", "index.html", "swagger-ui"));

        bootstrap.addBundle(new ViewBundle<>() {

            @Override
            public Map<String, Map<String, String>> getViewConfiguration(WeatherApplicationConfiguration configuration) {
                return configuration.getViews();
            }
        });
    }

    @Override
    public void run(WeatherApplicationConfiguration weatherApplicationConfiguration, Environment environment) throws Exception {
        ApiResources.register(environment);
        AppResources.register(environment);

        OpenAPI openAPI = new OpenAPI();
        Info info = new Info()
                .title("Weather API")
                .version(getClass().getPackage().getImplementationVersion());

        openAPI.info(info);

        SwaggerConfiguration swaggerConfiguration = new SwaggerConfiguration()
                .openAPI(openAPI)
                .prettyPrint(true)
                .resourcePackages(Stream.of("com.purplefrizzel.weather.api").collect(Collectors.toSet()));

        environment.jersey().register(new OpenApiResource().openApiConfiguration(swaggerConfiguration));
    }

    @Override
    public String getName() {
        return "Weather";
    }
}
