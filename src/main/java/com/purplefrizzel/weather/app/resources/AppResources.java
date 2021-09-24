package com.purplefrizzel.weather.app.resources;

import io.dropwizard.setup.Environment;

public class AppResources  {

    public static void register(Environment environment) {
        environment.jersey().register(homeResource());
        environment.jersey().register(searchResource());
    }

    private static HomeResource homeResource() {
        return new HomeResource.Factory().create();
    }

    private static SearchResource searchResource() {
        return new SearchResource.Factory().create();
    }
}
