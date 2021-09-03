package com.purplefrizzel.weather;

import com.purplefrizzel.weather.api.resources.ApiResources;
import com.purplefrizzel.weather.core.configurations.WeatherApplicationConfiguration;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class WeatherApplication extends Application<WeatherApplicationConfiguration> {

    public static void main(String[] args) throws Exception {
        new WeatherApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<WeatherApplicationConfiguration> bootstrap) {
        super.initialize(bootstrap);
    }

    @Override
    public void run(WeatherApplicationConfiguration weatherApplicationConfiguration, Environment environment) throws Exception {
        ApiResources.register(environment);
    }
}
