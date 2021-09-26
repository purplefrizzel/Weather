package com.purplefrizzel.weather.api.models.dto;

import com.fasterxml.jackson.core.JsonProcessingException;

public class WeatherAggregatedForecasts implements DTO<WeatherAggregatedForecasts> {

    private WeatherAggregatedForecasts[] forecasts;
    private Boolean isNight;
    private Boolean night;
    private String issueDate;
    private String lastUpdated;
    private WeatherLocationAggregated location;

    public static class WeatherLocationAggregated {}

    public static class WeatherForecastAggregated {}

    @Override
    public String toJsonString() throws JsonProcessingException {
        return null;
    }

    @Override
    public WeatherAggregatedForecasts convert() {
        return null;
    }
}
