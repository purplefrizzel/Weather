package com.purplefrizzel.weather.api.resources;

import io.dropwizard.setup.Environment;

public class ApiResources {

    public static void register(Environment environment) {
        environment.jersey().register(rootResource());
    }

    private static RootResource rootResource() {
        return new RootResource.Factory().create();
    }
}
