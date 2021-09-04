package com.purplefrizzel.weather.api.models.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.purplefrizzel.weather.api.models.weather.WeatherReport;
import com.purplefrizzel.weather.core.utils.PressureDirection;
import com.purplefrizzel.weather.core.utils.WindDirection;

public class WeatherObservationDTO implements DTO<WeatherReport> {

    private String localTime;
    private String localDate;
    private Integer weatherType;
    private String weatherTypeText;
    private Integer humidityPercent;
    private Integer pressureMb;
    private String pressureDirection;
    private String visibility;
    private String updateTimestamp;
    private Temperature temperature;
    private Wind wind;

    public String getLocalTime() {
        return localTime;
    }

    @JsonProperty
    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    @JsonProperty
    public String getLocalDate() {
        return localDate;
    }

    @JsonProperty
    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    @JsonProperty
    public Integer getWeatherType() {
        return weatherType;
    }

    @JsonProperty
    public void setWeatherType(Integer weatherType) {
        this.weatherType = weatherType;
    }

    @JsonProperty
    public String getWeatherTypeText() {
        return weatherTypeText;
    }

    @JsonProperty
    public void setWeatherTypeText(String weatherTypeText) {
        this.weatherTypeText = weatherTypeText;
    }

    @JsonProperty
    public Integer getHumidityPercent() {
        return humidityPercent;
    }

    @JsonProperty
    public void setHumidityPercent(Integer humidityPercent) {
        this.humidityPercent = humidityPercent;
    }

    @JsonProperty
    public Integer getPressureMb() {
        return pressureMb;
    }

    @JsonProperty
    public void setPressureMb(Integer pressureMb) {
        this.pressureMb = pressureMb;
    }

    @JsonProperty
    public String getPressureDirection() {
        return pressureDirection;
    }

    @JsonProperty
    public void setPressureDirection(String pressureDirection) {
        this.pressureDirection = pressureDirection;
    }

    @JsonProperty
    public String getVisibility() {
        return visibility;
    }

    @JsonProperty
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    @JsonProperty
    public String getUpdateTimestamp() {
        return updateTimestamp;
    }

    @JsonProperty
    public void setUpdateTimestamp(String updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    @JsonProperty
    public Temperature getTemperature() {
        return temperature;
    }

    @JsonProperty
    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    @JsonProperty
    public Wind getWind() {
        return wind;
    }

    @JsonProperty
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    @Override
    public String toJsonString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(this);
    }

    @Override
    public WeatherReport convert() {
        WeatherReport weatherReport = new WeatherReport();

        WeatherReport.Temperature temperature = new WeatherReport.Temperature(this.temperature.C, this.temperature.F);
        WeatherReport.Wind wind = new WeatherReport.Wind(new WeatherReport.Wind.Speed(this.wind.windSpeedMph, this.wind.windSpeedKph), WindDirection.valueOf(this.wind.windDirection), this.wind.windDirectionFull);
        WeatherReport.Pressure pressure = new WeatherReport.Pressure(pressureMb, PressureDirection.valueOf(pressureDirection));
        WeatherReport.Weather weather = new WeatherReport.Weather(weatherType, weatherTypeText);

        weatherReport.setTemperature(temperature);
        weatherReport.setWind(wind);
        weatherReport.setPressure(pressure);
        weatherReport.setWeather(weather);
        weatherReport.setVisibility(visibility);
        weatherReport.setHumidity(humidityPercent);

        return weatherReport;
    }

    private static class Temperature {

        private final Integer C;
        private final Integer F;

        @JsonCreator
        public Temperature(@JsonProperty("C") Integer c, @JsonProperty("F") Integer f) {
            C = c;
            F = f;
        }

        @JsonProperty
        public Integer getC() {
            return C;
        }

        @JsonProperty
        public Integer getF() {
            return F;
        }
    }

    @SuppressWarnings("ClassCanBeRecord")
    private static class Wind {

        private final Integer windSpeedMph;
        private final Integer windSpeedKph;
        private final String windDirection;
        private final String windDirectionFull;
        private final String windDirectionAbbreviation;

        @JsonCreator
        public Wind(@JsonProperty("windSpeedMph") Integer windSpeedMph, @JsonProperty("windSpeedKph") Integer windSpeedKph, @JsonProperty("windDirection") String windDirection, @JsonProperty("windDirectionFull") String windDirectionFull, @JsonProperty("windDirectionAbbreviation") String windDirectionAbbreviation) {
            this.windSpeedMph = windSpeedMph;
            this.windSpeedKph = windSpeedKph;
            this.windDirection = windDirection;
            this.windDirectionFull = windDirectionFull;
            this.windDirectionAbbreviation = windDirectionAbbreviation;
        }

        @JsonProperty
        public Integer getWindSpeedMph() {
            return windSpeedMph;
        }

        @JsonProperty
        public Integer getWindSpeedKph() {
            return windSpeedKph;
        }

        @JsonProperty
        public String getWindDirection() {
            return windDirection;
        }

        @JsonProperty
        public String getWindDirectionFull() {
            return windDirectionFull;
        }

        @JsonProperty
        public String getWindDirectionAbbreviation() {
            return windDirectionAbbreviation;
        }
    }
}
