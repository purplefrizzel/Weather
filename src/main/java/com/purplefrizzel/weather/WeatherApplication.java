package com.purplefrizzel.weather;

import com.purplefrizzel.weather.api.resources.ApiResources;
import com.purplefrizzel.weather.app.resources.AppResources;
import com.purplefrizzel.weather.core.configurations.WeatherApplicationConfiguration;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

import java.util.Map;

public class WeatherApplication extends Application<WeatherApplicationConfiguration> {

    public static void main(String[] args) throws Exception {
        new WeatherApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<WeatherApplicationConfiguration> bootstrap) {
        super.initialize(bootstrap);

        bootstrap.addBundle(new AssetsBundle("/assets", "/assets"));
        bootstrap.addBundle(new AssetsBundle("/assets/robots.txt", "/robots.txt"));
        bootstrap.addBundle(new AssetsBundle("/assets/favicon.ico", "/favicon.ico"));

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
    }
}
