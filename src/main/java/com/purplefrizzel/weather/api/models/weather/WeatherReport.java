package com.purplefrizzel.weather.api.models.weather;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.purplefrizzel.weather.api.models.JSONRecord;
import com.purplefrizzel.weather.core.utils.PressureDirection;
import com.purplefrizzel.weather.core.utils.WindDirection;

public class WeatherReport implements JSONRecord {

    private Temperature temperature;
    private Wind wind;
    private Pressure pressure;
    private Weather weather;
    private Rain rain;
    private String visibility;
    private Integer humidity;
    private Updates updates;
    private TimeDate timeDate;

    @JsonProperty
    public Rain getRain() {
        return rain;
    }

    @JsonProperty
    public void setRain(Rain rain) {
        this.rain = rain;
    }

    @JsonProperty
    public Updates getUpdates() {
        return updates;
    }

    @JsonProperty
    public void setUpdates(Updates updates) {
        this.updates = updates;
    }

    @JsonProperty
    public TimeDate getTimeDate() {
        return timeDate;
    }

    @JsonProperty
    public void setTimeDate(TimeDate timeDate) {
        this.timeDate = timeDate;
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

    @JsonProperty
    public Pressure getPressure() {
        return pressure;
    }

    @JsonProperty
    public void setPressure(Pressure pressure) {
        this.pressure = pressure;
    }

    @JsonProperty
    public Weather getWeather() {
        return weather;
    }

    @JsonProperty
    public void setWeather(Weather weather) {
        this.weather = weather;
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
    public Integer getHumidity() {
        return humidity;
    }

    @JsonProperty
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toJsonString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(this);
    }

    public static class Temperature {

        private final Integer C;
        private final Integer F;

        private FeelsLike feelsLike;

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

        @JsonProperty
        public FeelsLike getFeelsLike() {
            return feelsLike;
        }

        @JsonProperty
        public void setFeelsLike(FeelsLike feelsLike) {
            this.feelsLike = feelsLike;
        }

        public static class FeelsLike {

            private final Integer C;
            private final Integer F;

            @JsonCreator
            public FeelsLike(@JsonProperty("C") Integer c, @JsonProperty("F") Integer f) {
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
    }

    public static class Wind {

        private final Speed speed;
        private final WindDirection direction;
        private final String directionFull;
        private final String description;

        @JsonCreator
        public Wind(@JsonProperty("speed") Speed speed, @JsonProperty("direction") WindDirection direction, @JsonProperty("directionFull") String directionFull, @JsonProperty("description") String description) {
            this.speed = speed;
            this.direction = direction;
            this.directionFull = directionFull;
            this.description = description;
        }

        @JsonProperty
        public Speed getSpeed() {
            return speed;
        }

        @JsonProperty
        public WindDirection getDirection() {
            return direction;
        }

        @JsonProperty
        public String getDirectionFull() {
            return directionFull;
        }

        @JsonProperty
        public String getDescription() {
            return description;
        }

        public static class Speed {

            private final Integer mph;
            private final Integer kph;

            @JsonCreator
            public Speed(@JsonProperty("mph") Integer mph, @JsonProperty("kph") Integer kph) {
                this.mph = mph;
                this.kph = kph;
            }

            @JsonProperty
            public Integer getMph() {
                return mph;
            }

            @JsonProperty
            public Integer getKph() {
                return kph;
            }
        }
    }

    public static class Pressure {

        private final Integer mb;
        private final PressureDirection pressureDirection;

        @JsonCreator
        public Pressure(@JsonProperty("mb") Integer mb, @JsonProperty("pressureDirection") PressureDirection pressureDirection) {
            this.mb = mb;
            this.pressureDirection = pressureDirection;
        }

        @JsonProperty
        public Integer getMb() {
            return mb;
        }

        @JsonProperty
        public PressureDirection getPressureDirection() {
            return pressureDirection;
        }
    }

    public static class Weather {

        private final Integer weatherType;
        private final String weatherTypeText;
        private final String weatherDescription;

        @JsonCreator
        public Weather(@JsonProperty("weatherType") Integer weatherType, @JsonProperty("weatherTypeText") String weatherTypeText, @JsonProperty("weatherDescription") String weatherDescription) {
            this.weatherType = weatherType;
            this.weatherTypeText = weatherTypeText;
            this.weatherDescription = weatherDescription;
        }

        @JsonProperty
        public Integer getWeatherType() {
            return weatherType;
        }

        @JsonProperty
        public String getWeatherTypeText() {
            return weatherTypeText;
        }

        @JsonProperty
        public String getWeatherDescription() {
            return weatherDescription;
        }
    }

    public static class Updates {

        private final String issueDate;
        private final String lastUpdateDate;

        @JsonCreator
        public Updates(@JsonProperty("issueDate") String issueDate, @JsonProperty("lastUpdateDate") String lastUpdateDate) {
            this.issueDate = issueDate;
            this.lastUpdateDate = lastUpdateDate;
        }

        @JsonProperty
        public String getIssueDate() {
            return issueDate;
        }

        @JsonProperty
        public String getLastUpdateDate() {
            return lastUpdateDate;
        }
    }

    public static class TimeDate {

        private final String weatherTime;
        private final Integer weatherTimeLength;
        private final String localDate;

        @JsonCreator
        public TimeDate(@JsonProperty("weatherTime") String weatherTime, @JsonProperty("weatherTimeLength") Integer weatherTimeLength, @JsonProperty("localDate") String localDate) {
            this.weatherTime = weatherTime;
            this.weatherTimeLength = weatherTimeLength;
            this.localDate = localDate;
        }

        @JsonProperty
        public String getWeatherTime() {
            return weatherTime;
        }

        @JsonProperty
        public Integer getWeatherTimeLength() {
            return weatherTimeLength;
        }

        @JsonProperty
        public String getLocalDate() {
            return localDate;
        }
    }

    public static class Rain {

        private final Integer chance;
        private final String description;

        @JsonCreator
        public Rain(@JsonProperty("chance") Integer chance, @JsonProperty("description") String description) {
            this.chance = chance;
            this.description = description;
        }

        @JsonProperty
        public Integer getChance() {
            return chance;
        }

        @JsonProperty
        public String getDescription() {
            return description;
        }
    }
}
