package com.purplefrizzel.weather.core.configurations;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotEmpty;
import java.util.Collections;
import java.util.Map;

public class WeatherApplicationConfiguration extends Configuration {

    private BBCWeatherEndpoints bbcWeatherEndpoints;

    @NotEmpty
    private Map<String, Map<String, String>> views = Collections.emptyMap();

    @JsonProperty
    public BBCWeatherEndpoints getBbcWeatherEndpoints() {
        return bbcWeatherEndpoints;
    }

    @JsonProperty
    public void setBbcWeatherEndpoints(BBCWeatherEndpoints bbcWeatherEndpoints) {
        this.bbcWeatherEndpoints = bbcWeatherEndpoints;
    }

    @JsonProperty
    public Map<String, Map<String, String>> getViews() {
        return views;
    }

    @JsonProperty
    public void setViews(Map<String, Map<String, String>> views) {
        this.views = views;
    }

    public static class BBCWeatherEndpoints extends Configuration {

        @NotEmpty
        private String observationsEndpoint = "https://weather-broker-cdn.api.bbci.co.uk/en/observation/";
        private String locationEndpoint = "https://weather-broker-cdn.api.bbci.co.uk/locator/en/locations/";

        @JsonProperty
        public String getLocationEndpoint() {
            return locationEndpoint;
        }

        @JsonProperty
        public void setLocationEndpoint(String locationEndpoint) {
            this.locationEndpoint = locationEndpoint;
        }

        @JsonProperty
        public String getObservationsEndpoint() {
            return observationsEndpoint;
        }

        @JsonProperty
        public void setObservationsEndpoint(String observationsEndpoint) {
            this.observationsEndpoint = observationsEndpoint;
        }
    }
}
