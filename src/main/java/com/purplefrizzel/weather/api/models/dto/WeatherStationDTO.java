package com.purplefrizzel.weather.api.models.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.purplefrizzel.weather.api.models.weather.WeatherStation;

@SuppressWarnings("ClassCanBeRecord")
public class WeatherStationDTO implements DTO<WeatherStation> {

    private final String name;
    private final Distance distance;
    private final Double latitude;
    private final Double longitude;

    @JsonCreator
    public WeatherStationDTO(@JsonProperty("name") String name, @JsonProperty("distance") Distance distance, @JsonProperty("latitude") Double latitude, @JsonProperty("longitude") Double longitude) {
        this.name = name;
        this.distance = distance;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public Distance getDistance() {
        return distance;
    }

    @JsonProperty
    public Double getLatitude() {
        return latitude;
    }

    @JsonProperty
    public Double getLongitude() {
        return longitude;
    }

    @Override
    public WeatherStation convert() {
        WeatherStation.Distance distance = new WeatherStation.Distance(this.distance.km, this.distance.miles);
        WeatherStation.Location location = new WeatherStation.Location(latitude, longitude);

        return new WeatherStation(name, location, distance);
    }

    @Override
    public String toJsonString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(this);
    }

    @SuppressWarnings("ClassCanBeRecord")
    private static class Distance {

        private final Float km;
        private final Float miles;

        @JsonCreator
        public Distance(@JsonProperty("km") Float km, @JsonProperty("miles") Float miles) {
            this.km = km;
            this.miles = miles;
        }

        @JsonProperty
        public Float getKm() {
            return km;
        }

        @JsonProperty
        public Float getMiles() {
            return miles;
        }
    }
}
