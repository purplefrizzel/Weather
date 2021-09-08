package com.purplefrizzel.weather.api.models.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.purplefrizzel.weather.api.models.location.WeatherLocation;

public class WeatherLocationDTO implements DTO<WeatherLocation> {

    private String name;
    private Double latitude;
    private Double longitude;
    private Object pressureArea;
    private Object nearby;
    private String timezone;
    private String county;
    private String tvRegion;
    private Boolean isCountry;
    private String container;
    private String gssId;
    private Forecast forecast;
    private Country country;

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
    public Object getPressureArea() {
        return pressureArea;
    }

    @JsonProperty
    public void setPressureArea(Object pressureArea) {
        this.pressureArea = pressureArea;
    }

    @JsonProperty
    public Object getNearby() {
        return nearby;
    }

    @JsonProperty
    public void setNearby(Object nearby) {
        this.nearby = nearby;
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
    public String getCounty() {
        return county;
    }

    @JsonProperty
    public void setCounty(String county) {
        this.county = county;
    }

    @JsonProperty
    public String getTvRegion() {
        return tvRegion;
    }

    @JsonProperty
    public void setTvRegion(String tvRegion) {
        this.tvRegion = tvRegion;
    }

    @JsonProperty
    public Boolean getIsCountry() {
        return isCountry;
    }

    @JsonProperty
    public void setIsCountry(Boolean country) {
        isCountry = country;
    }

    @JsonProperty
    public String getContainer() {
        return container;
    }

    @JsonProperty
    public void setContainer(String container) {
        this.container = container;
    }

    @JsonProperty
    public String getGssId() {
        return gssId;
    }

    @JsonProperty
    public void setGssId(String gssId) {
        this.gssId = gssId;
    }

    @JsonProperty
    public Forecast getForecast() {
        return forecast;
    }

    @JsonProperty
    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    @JsonProperty
    public void setCountry(Country country) {
        this.country = country;
    }

    @JsonProperty
    public Boolean getCountry() {
        return isCountry;
    }

    public static class Forecast {

        private final String geoId;
        private final String name;
        private final String latitude;
        private final String longitude;

        @JsonCreator
        public Forecast(@JsonProperty("geoId") String geoId, @JsonProperty("name") String name, @JsonProperty("latitude") String latitude, @JsonProperty("longitude") String longitude) {
            this.geoId = geoId;
            this.name = name;
            this.latitude = latitude;
            this.longitude = longitude;
        }

        @JsonProperty
        public String getGeoId() {
            return geoId;
        }

        @JsonProperty
        public String getName() {
            return name;
        }

        @JsonProperty
        public String getLatitude() {
            return latitude;
        }

        @JsonProperty
        public String getLongitude() {
            return longitude;
        }
    }

    public static class Country {

        private final String code;
        private final String name;
        private final String geoId;
        private final Double latitude;
        private final Double longitude;
        private final Nearby nearby;

        @JsonCreator
        public Country(@JsonProperty("code") String code, @JsonProperty("name") String name, @JsonProperty("geoId") String geoId, @JsonProperty("latitude") Double latitude, @JsonProperty("longitude") Double longitude, @JsonProperty("nearby") Nearby nearby) {
            this.code = code;
            this.name = name;
            this.geoId = geoId;
            this.latitude = latitude;
            this.longitude = longitude;
            this.nearby = nearby;
        }

        @JsonProperty
        public String getCode() {
            return code;
        }

        @JsonProperty
        public String getName() {
            return name;
        }

        @JsonProperty
        public String getGeoId() {
            return geoId;
        }

        @JsonProperty
        public Double getLatitude() {
            return latitude;
        }

        @JsonProperty
        public Double getLongitude() {
            return longitude;
        }

        @JsonProperty
        public Nearby getNearby() {
            return nearby;
        }

        public static class Nearby {

            private final Integer zoomLevel;
            private final WeatherLocationDTO[] locations;

            @JsonCreator
            public Nearby(@JsonProperty("zoomLevel") Integer zoomLevel, @JsonProperty("locations") WeatherLocationDTO[] locations) {
                this.zoomLevel = zoomLevel;
                this.locations = locations;
            }

            @JsonProperty
            public Integer getZoomLevel() {
                return zoomLevel;
            }

            @JsonProperty
            public WeatherLocationDTO[] getLocations() {
                return locations;
            }
        }
    }

    @Override
    public String toJsonString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(this);
    }

    @Override
    public WeatherLocation convert() {
        WeatherLocation weatherLocation = new WeatherLocation();
        weatherLocation.setName(this.forecast.getName());
        weatherLocation.setGeoId(this.forecast.getGeoId());
        weatherLocation.setLatitude(this.getLatitude());
        weatherLocation.setLongitude(this.getLongitude());
        weatherLocation.setTimezone(this.getTimezone());
        weatherLocation.setWarningId(this.getGssId());
        weatherLocation.setMetadata(new WeatherLocation.Metadata(this.getIsCountry(), this.getContainer()));

        return weatherLocation;
    }
}
