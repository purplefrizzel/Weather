package com.purplefrizzel.weather.core.configurations;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotEmpty;

public class WeatherApplicationConfiguration extends Configuration {

    @NotEmpty
    private BBCWeatherEndpoints bbcWeatherEndpoints;

    @JsonProperty
    public BBCWeatherEndpoints getBbcWeatherEndpoints() {
        return bbcWeatherEndpoints;
    }

    @JsonProperty
    public void setBbcWeatherEndpoints(BBCWeatherEndpoints bbcWeatherEndpoints) {
        this.bbcWeatherEndpoints = bbcWeatherEndpoints;
    }

    private static class BBCWeatherEndpoints extends Configuration {

        @NotEmpty
        private String observationsEndpoint = "https://weather-broker-cdn.api.bbci.co.uk/en/observation/";

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
