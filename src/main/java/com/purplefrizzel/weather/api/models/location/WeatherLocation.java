package com.purplefrizzel.weather.api.models.location;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.purplefrizzel.weather.api.models.JSONRecord;

public class WeatherLocation implements JSONRecord {

    private String name;
    private Double latitude;
    private Double longitude;
    private String timezone;
    private String geoId;
    private String warningId;
    private Metadata metadata;

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    public Double getLatitude() {
        return latitude;
    }

    @JsonProperty
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @JsonProperty
    public Double getLongitude() {
        return longitude;
    }

    @JsonProperty
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonProperty
    public String getGeoId() {
        return geoId;
    }

    @JsonProperty
    public void setGeoId(String geoId) {
        this.geoId = geoId;
    }

    @JsonProperty
    public String getWarningId() {
        return warningId;
    }

    @JsonProperty
    public void setWarningId(String warningId) {
        this.warningId = warningId;
    }

    @JsonProperty
    public Metadata getMetadata() {
        return metadata;
    }

    @JsonProperty
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public static class Metadata implements JSONRecord {

        private final Boolean isCountry;
        private final String container;

        @JsonCreator
        public Metadata(@JsonProperty("isCountry") Boolean isCountry, @JsonProperty("container") String container) {
            this.isCountry = isCountry;
            this.container = container;
        }

        @JsonProperty
        public Boolean getCountry() {
            return isCountry;
        }

        @JsonProperty
        public String getContainer() {
            return container;
        }

        @Override
        public String toJsonString() throws JsonProcessingException {
            ObjectMapper objectMapper = new ObjectMapper();

            return objectMapper.writeValueAsString(this);
        }
    }

    @Override
    public String toJsonString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(this);
    }
}
