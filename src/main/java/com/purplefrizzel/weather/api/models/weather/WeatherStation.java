package com.purplefrizzel.weather.api.models.weather;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.purplefrizzel.weather.api.models.JSONRecord;

@SuppressWarnings("ClassCanBeRecord")
public class WeatherStation implements JSONRecord {

    private final String name;
    private final Location location;
    private final Distance distance;

    @JsonCreator
    public WeatherStation(String name, Location location, Distance distance) {
        this.name = name;
        this.location = location;
        this.distance = distance;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public Location getLocation() {
        return location;
    }

    @JsonProperty
    public Distance getDistance() {
        return distance;
    }

    @Override
    public String toJsonString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(this);
    }

    @SuppressWarnings("ClassCanBeRecord")
    public static class Distance {

        private final Float km;
        private final Float miles;

        @JsonCreator
        public Distance(Float km, Float miles) {
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

    @SuppressWarnings("ClassCanBeRecord")
    public static class Location {

        private final Double latitude;
        private final Double longitude;

        @JsonCreator
        public Location(Double latitude, Double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }

        @JsonProperty
        public Double getLatitude() {
            return latitude;
        }

        @JsonProperty
        public Double getLongitude() {
            return longitude;
        }
    }
}
