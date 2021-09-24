package com.purplefrizzel.weather.app.views;

import io.dropwizard.views.View;

public class SearchView extends View {

    private final String query;

    public SearchView(String query) {
        super("search.ftl");
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
