package com.purplefrizzel.weather.api.models.weather;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.purplefrizzel.weather.api.models.JSONRecord;

public class WeatherForecast implements JSONRecord {

    private final WeatherStation station;
    private final WeatherReport report;

    @JsonCreator
    public WeatherForecast(@JsonProperty("station") WeatherStation station, @JsonProperty("report") WeatherReport report) {
        this.station = station;
        this.report = report;
    }

    @JsonProperty
    public WeatherReport getReport() {
        return report;
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
