package com.purplefrizzel.weather.app.views;

import com.purplefrizzel.weather.api.models.location.WeatherLocation;
import io.dropwizard.views.View;

public class SearchView extends View {

    private final String query;
    private final WeatherLocation[] locations;
    private final Integer locationsLength;

    public SearchView(String query, WeatherLocation[] locations) {
        super("search.ftl");
        this.query = query;
        this.locations = locations;
        this.locationsLength = locations.length;
    }

    public String getQuery() {
        return query;
    }

    public WeatherLocation[] getLocations() {
        return locations;
    }

    public Integer getLocationsLength() {
        return locationsLength;
    }
}
