package com.purplefrizzel.weather.api.models.weather;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.purplefrizzel.weather.api.models.JSONRecord;

public class WeatherForecast implements JSONRecord {

    private final WeatherStation station;
    private final WeatherReport[] reports;

    @JsonCreator
    public WeatherForecast(@JsonProperty("station") WeatherStation station, @JsonProperty("reports") WeatherReport[] reports) {
        this.station = station;
        this.reports = reports;
    }

    @JsonProperty
    public WeatherReport[] getReport() {
        return reports;
    }

    @JsonProperty
    public WeatherStation getStation() {
        return station;
    }

    @Override
    public String toJsonString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(this);
    }
}
