package com.purplefrizzel.weather.app.resources;

import io.dropwizard.setup.Environment;

public class AppResources  {

    public static void register(Environment environment) {
        environment.jersey().register(homeResource());
    }

    private static HomeResource homeResource() {
        return new HomeResource.Factory().create();
    }
}
