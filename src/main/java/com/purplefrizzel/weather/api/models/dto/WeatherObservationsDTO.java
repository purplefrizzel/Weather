package com.purplefrizzel.weather.api.models.dto;

import com.purplefrizzel.weather.api.models.weather.WeatherForecast;

public class WeatherObservationDTO implements DTO<WeatherForecast> {

    private WeatherStationDTO station;
    
    @Override
    public WeatherForecast convert() {
        return null;
    }
}
