package com.purplefrizzel.weather.api.models.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.purplefrizzel.weather.api.models.weather.WeatherForecast;
import com.purplefrizzel.weather.api.models.weather.WeatherReport;
import com.purplefrizzel.weather.api.models.weather.WeatherStation;

public class WeatherObservationsDTO implements DTO<WeatherForecast> {

    private final WeatherStationDTO station;
    private final WeatherObservationDTO[] observations;

    @JsonCreator
    public WeatherObservationsDTO(@JsonProperty("station") WeatherStationDTO station, @JsonProperty("observations") WeatherObservationDTO[] observations) {
        this.station = station;
        this.observations = observations;
    }

    @JsonProperty
    public WeatherStationDTO getStation() {
        return station;
    }

    @JsonProperty
    public WeatherObservationDTO[] getObservations() {
        return observations;
    }

    @Override
    public WeatherForecast convert() {
        WeatherStation weatherStation = station.convert();
        WeatherReport weatherReport = observations[0].convert();

        return new WeatherForecast(weatherStation, weatherReport);
    }

    @Override
    public String toJsonString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(this);
    }
}
