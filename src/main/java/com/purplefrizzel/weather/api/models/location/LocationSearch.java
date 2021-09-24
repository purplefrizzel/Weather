package com.purplefrizzel.weather.api.models.location;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.purplefrizzel.weather.api.models.JSONRecord;

public class LocationSearch implements JSONRecord {

    private final WeatherLocation[] locations;

    @JsonCreator
    public LocationSearch(@JsonProperty("locations") WeatherLocation[] locations) {
        this.locations = locations;
    }

    @JsonProperty
    public WeatherLocation[] getLocations() {
        return locations;
    }

    @Override
    public String toJsonString() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(this);
    }
}
