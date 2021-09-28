package com.purplefrizzel.weather.api.models.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.purplefrizzel.weather.api.models.weather.WeatherReport;
import com.purplefrizzel.weather.core.utils.PressureDirection;
import com.purplefrizzel.weather.core.utils.WindDirection;

import java.util.ArrayList;
import java.util.List;

public class WeatherAggregatedForecastsDTO implements DTO<WeatherReport[]> {

    private WeatherForecastAggregated[] forecasts;
    private Boolean isNight;
    private Boolean night;
    private String issueDate;
    private String lastUpdated;
    private WeatherLocationAggregated location;

    @JsonProperty
    public WeatherForecastAggregated[] getForecasts() {
        return forecasts;
    }

    @JsonProperty
    public void setForecasts(WeatherForecastAggregated[] forecasts) {
        this.forecasts = forecasts;
    }

    @JsonProperty
    public Boolean getIsNight() {
        return isNight;
    }

    @JsonProperty
    public void setIsNight(Boolean night) {
        isNight = night;
    }

    @JsonProperty
    public Boolean getNight() {
        return night;
    }

    @JsonProperty
    public void setNight(Boolean isNight) {
        night = isNight;
    }

    @JsonProperty
    public String getIssueDate() {
        return issueDate;
    }

    @JsonProperty
    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    @JsonProperty
    public String getLastUpdated() {
        return lastUpdated;
    }

    @JsonProperty
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @JsonProperty
    public WeatherLocationAggregated getLocation() {
        return location;
    }

    @JsonProperty
    public void setLocation(WeatherLocationAggregated location) {
        this.location = location;
    }

    public static class WeatherLocationAggregated {

        private final String id;
        private final String name;
        private final String container;
        private final Double latitude;
        private final Double longitude;

        @JsonCreator
        public WeatherLocationAggregated(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("container") String container, @JsonProperty("latitude") Double latitude, @JsonProperty("longitude") Double longitude) {
            this.id = id;
            this.name = name;
            this.container = container;
            this.latitude = latitude;
            this.longitude = longitude;
        }

        @JsonProperty
        public String getId() {
            return id;
        }

        @JsonProperty
        public String getName() {
            return name;
        }

        @JsonProperty
        public String getContainer() {
            return container;
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

    public static class WeatherForecastAggregated {

        private final Detailed detailed;
        private final Summary summary;

        @JsonCreator
        public WeatherForecastAggregated(@JsonProperty("detailed") Detailed detailed, @JsonProperty("summary") Summary summary) {
            this.detailed = detailed;
            this.summary = summary;
        }

        @JsonProperty
        public Detailed getDetailed() {
            return detailed;
        }

        @JsonProperty
        public Summary getSummary() {
            return summary;
        }

        public static class Detailed {

            private final String issueDate;
            private final String lastUpdated;
            private final Report[] reports;

            @JsonCreator
            public Detailed(@JsonProperty("issueDate") String issueDate, @JsonProperty("lastUpdated") String lastUpdated, @JsonProperty("reports") Report[] reports) {
                this.issueDate = issueDate;
                this.lastUpdated = lastUpdated;
                this.reports = reports;
            }

            @JsonProperty
            public String getIssueDate() {
                return issueDate;
            }

            @JsonProperty
            public String getLastUpdated() {
                return lastUpdated;
            }

            @JsonProperty
            public Report[] getReports() {
                return reports;
            }

            public static class Report {

                private String enhancedWeatherDescription;
                private Integer extendedWeatherType;
                private Integer feelsLikeTemperatureC;
                private Integer feelsLikeTemperatureF;
                private Integer gustSpeedKph;
                private Integer gustSpeedMph;
                private Integer humidity;
                private String localDate;
                private Integer precipitationProbabilityInPercent;
                private String precipitationProbabilityText;
                private Integer pressure;
                private Integer temperatureC;
                private Integer temperatureF;
                private String timeslot;
                private Integer timeslotLength;
                private String visibility;
                private Integer weatherType;
                private String weatherTypeText;
                private String windDescription;
                private String windDirection;
                private String windDirectionAbbreviation;
                private String windDirectionFull;
                private Integer windSpeedMph;
                private Integer windSpeedKph;

                @JsonProperty
                public String getEnhancedWeatherDescription() {
                    return enhancedWeatherDescription;
                }

                @JsonProperty
                public void setEnhancedWeatherDescription(String enhancedWeatherDescription) {
                    this.enhancedWeatherDescription = enhancedWeatherDescription;
                }

                @JsonProperty
                public Integer getExtendedWeatherType() {
                    return extendedWeatherType;
                }

                @JsonProperty
                public void setExtendedWeatherType(Integer extendedWeatherType) {
                    this.extendedWeatherType = extendedWeatherType;
                }

                @JsonProperty
                public Integer getFeelsLikeTemperatureC() {
                    return feelsLikeTemperatureC;
                }

                @JsonProperty
                public void setFeelsLikeTemperatureC(Integer feelsLikeTemperatureC) {
                    this.feelsLikeTemperatureC = feelsLikeTemperatureC;
                }

                @JsonProperty
                public Integer getFeelsLikeTemperatureF() {
                    return feelsLikeTemperatureF;
                }

                @JsonProperty
                public void setFeelsLikeTemperatureF(Integer feelsLikeTemperatureF) {
                    this.feelsLikeTemperatureF = feelsLikeTemperatureF;
                }

                @JsonProperty
                public Integer getGustSpeedKph() {
                    return gustSpeedKph;
                }

                @JsonProperty
                public void setGustSpeedKph(Integer gustSpeedKph) {
                    this.gustSpeedKph = gustSpeedKph;
                }

                @JsonProperty
                public Integer getGustSpeedMph() {
                    return gustSpeedMph;
                }

                @JsonProperty
                public void setGustSpeedMph(Integer gustSpeedMph) {
                    this.gustSpeedMph = gustSpeedMph;
                }

                @JsonProperty
                public Integer getHumidity() {
                    return humidity;
                }

                @JsonProperty
                public void setHumidity(Integer humidity) {
                    this.humidity = humidity;
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
                public Integer getPrecipitationProbabilityInPercent() {
                    return precipitationProbabilityInPercent;
                }

                @JsonProperty
                public void setPrecipitationProbabilityInPercent(Integer precipitationProbabilityInPercent) {
                    this.precipitationProbabilityInPercent = precipitationProbabilityInPercent;
                }

                @JsonProperty
                public String getPrecipitationProbabilityText() {
                    return precipitationProbabilityText;
                }

                @JsonProperty
                public void setPrecipitationProbabilityText(String precipitationProbabilityText) {
                    this.precipitationProbabilityText = precipitationProbabilityText;
                }

                @JsonProperty
                public Integer getPressure() {
                    return pressure;
                }

                @JsonProperty
                public void setPressure(Integer pressure) {
                    this.pressure = pressure;
                }

                @JsonProperty
                public Integer getTemperatureC() {
                    return temperatureC;
                }

                @JsonProperty
                public void setTemperatureC(Integer temperatureC) {
                    this.temperatureC = temperatureC;
                }

                @JsonProperty
                public Integer getTemperatureF() {
                    return temperatureF;
                }

                @JsonProperty
                public void setTemperatureF(Integer temperatureF) {
                    this.temperatureF = temperatureF;
                }

                @JsonProperty
                public String getTimeslot() {
                    return timeslot;
                }

                @JsonProperty
                public void setTimeslot(String timeslot) {
                    this.timeslot = timeslot;
                }

                @JsonProperty
                public Integer getTimeslotLength() {
                    return timeslotLength;
                }

                @JsonProperty
                public void setTimeslotLength(Integer timeslotLength) {
                    this.timeslotLength = timeslotLength;
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
                public String getWindDescription() {
                    return windDescription;
                }

                @JsonProperty
                public void setWindDescription(String windDescription) {
                    this.windDescription = windDescription;
                }

                @JsonProperty
                public String getWindDirection() {
                    return windDirection;
                }

                @JsonProperty
                public void setWindDirection(String windDirection) {
                    this.windDirection = windDirection;
                }

                @JsonProperty
                public String getWindDirectionAbbreviation() {
                    return windDirectionAbbreviation;
                }

                @JsonProperty
                public void setWindDirectionAbbreviation(String windDirectionAbbreviation) {
                    this.windDirectionAbbreviation = windDirectionAbbreviation;
                }

                @JsonProperty
                public String getWindDirectionFull() {
                    return windDirectionFull;
                }

                @JsonProperty
                public void setWindDirectionFull(String windDirectionFull) {
                    this.windDirectionFull = windDirectionFull;
                }

                @JsonProperty
                public Integer getWindSpeedMph() {
                    return windSpeedMph;
                }

                @JsonProperty
                public void setWindSpeedMph(Integer windSpeedMph) {
                    this.windSpeedMph = windSpeedMph;
                }

                @JsonProperty
                public Integer getWindSpeedKph() {
                    return windSpeedKph;
                }

                @JsonProperty
                public void setWindSpeedKph(Integer windSpeedKph) {
                    this.windSpeedKph = windSpeedKph;
                }
            }

        }

        private static class Summary {

            private final String issueDate;
            private final String lastUpdated;
            private final Report report;

            @JsonCreator
            public Summary(@JsonProperty("issueDate") String issueDate, @JsonProperty("lastUpdated") String lastUpdated, @JsonProperty("report") Report report) {
                this.issueDate = issueDate;
                this.lastUpdated = lastUpdated;
                this.report = report;
            }

            @JsonProperty
            public String getIssueDate() {
                return issueDate;
            }

            @JsonProperty
            public String getLastUpdated() {
                return lastUpdated;
            }

            @JsonProperty
            public Report getReport() {
                return report;
            }

            public static class Report {

                private String enhancedWeatherDescription;
                private Integer gustSpeedKph;
                private Integer gustSpeedMph;
                private String localDate;
                private Integer lowermaxTemperatureC;
                private Integer lowermaxTemperatureF;
                private Integer lowerminTemperatureC;
                private Integer lowerminTemperatureF;
                private Integer maxTempC;
                private Integer maxTempF;
                private Integer minTempC;
                private Integer minTempF;
                private Integer mostLikelyHighTemperatureC;
                private Integer mostLikelyHighTemperatureF;
                private Integer mostLikelyLowTemperatureC;
                private Integer mostLikelyLowTemperatureF;
                private Integer pollenIndex;
                private String pollenIndexBand;
                private String pollenIndexIconText;
                private String pollenIndexText;
                private Integer pollutionIndex;
                private String pollutionIndexBand;
                private String pollutionIndexIconText;
                private String pollutionIndexText;
                private Integer precipitationProbabilityInPercent;
                private String precipitationProbabilityText;
                private String sunrise;
                private String sunset;
                private Integer uppermaxTemperatureC;
                private Integer uppermaxTemperatureF;
                private Integer upperminTemperatureC;
                private Integer upperminTemperatureF;
                private Integer uvIndex;
                private String uvIndexBand;
                private String uvIndexIconText;
                private String uvIndexText;
                private Integer weatherType;
                private String weatherTypeText;
                private String windDescription;
                private String windDirection;
                private String windDirectionAbbreviation;
                private String windDirectionFull;
                private Integer windSpeedKph;
                private Integer windSpeedMph;

                @JsonProperty
                public String getEnhancedWeatherDescription() {
                    return enhancedWeatherDescription;
                }

                @JsonProperty
                public void setEnhancedWeatherDescription(String enhancedWeatherDescription) {
                    this.enhancedWeatherDescription = enhancedWeatherDescription;
                }

                @JsonProperty
                public Integer getGustSpeedKph() {
                    return gustSpeedKph;
                }

                @JsonProperty
                public void setGustSpeedKph(Integer gustSpeedKph) {
                    this.gustSpeedKph = gustSpeedKph;
                }

                @JsonProperty
                public Integer getGustSpeedMph() {
                    return gustSpeedMph;
                }

                @JsonProperty
                public void setGustSpeedMph(Integer gustSpeedMph) {
                    this.gustSpeedMph = gustSpeedMph;
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
                public Integer getLowermaxTemperatureC() {
                    return lowermaxTemperatureC;
                }

                @JsonProperty
                public void setLowermaxTemperatureC(Integer lowermaxTemperatureC) {
                    this.lowermaxTemperatureC = lowermaxTemperatureC;
                }

                @JsonProperty
                public Integer getLowermaxTemperatureF() {
                    return lowermaxTemperatureF;
                }

                @JsonProperty
                public void setLowermaxTemperatureF(Integer lowermaxTemperatureF) {
                    this.lowermaxTemperatureF = lowermaxTemperatureF;
                }

                @JsonProperty
                public Integer getLowerminTemperatureC() {
                    return lowerminTemperatureC;
                }

                @JsonProperty
                public void setLowerminTemperatureC(Integer lowerminTemperatureC) {
                    this.lowerminTemperatureC = lowerminTemperatureC;
                }

                @JsonProperty
                public Integer getLowerminTemperatureF() {
                    return lowerminTemperatureF;
                }

                @JsonProperty
                public void setLowerminTemperatureF(Integer lowerminTemperatureF) {
                    this.lowerminTemperatureF = lowerminTemperatureF;
                }

                @JsonProperty
                public Integer getMaxTempC() {
                    return maxTempC;
                }

                @JsonProperty
                public void setMaxTempC(Integer maxTempC) {
                    this.maxTempC = maxTempC;
                }

                @JsonProperty
                public Integer getMaxTempF() {
                    return maxTempF;
                }

                @JsonProperty
                public void setMaxTempF(Integer maxTempF) {
                    this.maxTempF = maxTempF;
                }

                @JsonProperty
                public Integer getMinTempC() {
                    return minTempC;
                }

                @JsonProperty
                public void setMinTempC(Integer minTempC) {
                    this.minTempC = minTempC;
                }

                @JsonProperty
                public Integer getMinTempF() {
                    return minTempF;
                }

                @JsonProperty
                public void setMinTempF(Integer minTempF) {
                    this.minTempF = minTempF;
                }

                @JsonProperty
                public Integer getMostLikelyHighTemperatureC() {
                    return mostLikelyHighTemperatureC;
                }

                @JsonProperty
                public void setMostLikelyHighTemperatureC(Integer mostLikelyHighTemperatureC) {
                    this.mostLikelyHighTemperatureC = mostLikelyHighTemperatureC;
                }

                @JsonProperty
                public Integer getMostLikelyHighTemperatureF() {
                    return mostLikelyHighTemperatureF;
                }

                @JsonProperty
                public void setMostLikelyHighTemperatureF(Integer mostLikelyHighTemperatureF) {
                    this.mostLikelyHighTemperatureF = mostLikelyHighTemperatureF;
                }

                @JsonProperty
                public Integer getMostLikelyLowTemperatureC() {
                    return mostLikelyLowTemperatureC;
                }

                @JsonProperty
                public void setMostLikelyLowTemperatureC(Integer mostLikelyLowTemperatureC) {
                    this.mostLikelyLowTemperatureC = mostLikelyLowTemperatureC;
                }

                @JsonProperty
                public Integer getMostLikelyLowTemperatureF() {
                    return mostLikelyLowTemperatureF;
                }

                @JsonProperty
                public void setMostLikelyLowTemperatureF(Integer mostLikelyLowTemperatureF) {
                    this.mostLikelyLowTemperatureF = mostLikelyLowTemperatureF;
                }

                @JsonProperty
                public Integer getPollenIndex() {
                    return pollenIndex;
                }

                @JsonProperty
                public void setPollenIndex(Integer pollenIndex) {
                    this.pollenIndex = pollenIndex;
                }

                @JsonProperty
                public String getPollenIndexBand() {
                    return pollenIndexBand;
                }

                @JsonProperty
                public void setPollenIndexBand(String pollenIndexBand) {
                    this.pollenIndexBand = pollenIndexBand;
                }

                @JsonProperty
                public String getPollenIndexIconText() {
                    return pollenIndexIconText;
                }

                @JsonProperty
                public void setPollenIndexIconText(String pollenIndexIconText) {
                    this.pollenIndexIconText = pollenIndexIconText;
                }

                @JsonProperty
                public String getPollenIndexText() {
                    return pollenIndexText;
                }

                @JsonProperty
                public void setPollenIndexText(String pollenIndexText) {
                    this.pollenIndexText = pollenIndexText;
                }

                @JsonProperty
                public Integer getPollutionIndex() {
                    return pollutionIndex;
                }

                @JsonProperty
                public void setPollutionIndex(Integer pollutionIndex) {
                    this.pollutionIndex = pollutionIndex;
                }

                @JsonProperty
                public String getPollutionIndexBand() {
                    return pollutionIndexBand;
                }

                @JsonProperty
                public void setPollutionIndexBand(String pollutionIndexBand) {
                    this.pollutionIndexBand = pollutionIndexBand;
                }

                @JsonProperty
                public String getPollutionIndexIconText() {
                    return pollutionIndexIconText;
                }

                @JsonProperty
                public void setPollutionIndexIconText(String pollutionIndexIconText) {
                    this.pollutionIndexIconText = pollutionIndexIconText;
                }

                @JsonProperty
                public String getPollutionIndexText() {
                    return pollutionIndexText;
                }

                @JsonProperty
                public void setPollutionIndexText(String pollutionIndexText) {
                    this.pollutionIndexText = pollutionIndexText;
                }

                @JsonProperty
                public Integer getPrecipitationProbabilityInPercent() {
                    return precipitationProbabilityInPercent;
                }

                @JsonProperty
                public void setPrecipitationProbabilityInPercent(Integer precipitationProbabilityInPercent) {
                    this.precipitationProbabilityInPercent = precipitationProbabilityInPercent;
                }

                @JsonProperty
                public String getPrecipitationProbabilityText() {
                    return precipitationProbabilityText;
                }

                @JsonProperty
                public void setPrecipitationProbabilityText(String precipitationProbabilityText) {
                    this.precipitationProbabilityText = precipitationProbabilityText;
                }

                @JsonProperty
                public String getSunrise() {
                    return sunrise;
                }

                @JsonProperty
                public void setSunrise(String sunrise) {
                    this.sunrise = sunrise;
                }

                @JsonProperty
                public String getSunset() {
                    return sunset;
                }

                @JsonProperty
                public void setSunset(String sunset) {
                    this.sunset = sunset;
                }

                @JsonProperty
                public Integer getUppermaxTemperatureC() {
                    return uppermaxTemperatureC;
                }

                @JsonProperty
                public void setUppermaxTemperatureC(Integer uppermaxTemperatureC) {
                    this.uppermaxTemperatureC = uppermaxTemperatureC;
                }

                @JsonProperty
                public Integer getUppermaxTemperatureF() {
                    return uppermaxTemperatureF;
                }

                @JsonProperty
                public void setUppermaxTemperatureF(Integer uppermaxTemperatureF) {
                    this.uppermaxTemperatureF = uppermaxTemperatureF;
                }

                @JsonProperty
                public Integer getUpperminTemperatureC() {
                    return upperminTemperatureC;
                }

                @JsonProperty
                public void setUpperminTemperatureC(Integer upperminTemperatureC) {
                    this.upperminTemperatureC = upperminTemperatureC;
                }

                @JsonProperty
                public Integer getUpperminTemperatureF() {
                    return upperminTemperatureF;
                }

                @JsonProperty
                public void setUpperminTemperatureF(Integer upperminTemperatureF) {
                    this.upperminTemperatureF = upperminTemperatureF;
                }

                @JsonProperty
                public Integer getUvIndex() {
                    return uvIndex;
                }

                @JsonProperty
                public void setUvIndex(Integer uvIndex) {
                    this.uvIndex = uvIndex;
                }

                @JsonProperty
                public String getUvIndexBand() {
                    return uvIndexBand;
                }

                @JsonProperty
                public void setUvIndexBand(String uvIndexBand) {
                    this.uvIndexBand = uvIndexBand;
                }

                @JsonProperty
                public String getUvIndexIconText() {
                    return uvIndexIconText;
                }

                @JsonProperty
                public void setUvIndexIconText(String uvIndexIconText) {
                    this.uvIndexIconText = uvIndexIconText;
                }

                @JsonProperty
                public String getUvIndexText() {
                    return uvIndexText;
                }

                @JsonProperty
                public void setUvIndexText(String uvIndexText) {
                    this.uvIndexText = uvIndexText;
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
                public String getWindDescription() {
                    return windDescription;
                }

                @JsonProperty
                public void setWindDescription(String windDescription) {
                    this.windDescription = windDescription;
                }

                @JsonProperty
                public String getWindDirection() {
                    return windDirection;
                }

                @JsonProperty
                public void setWindDirection(String windDirection) {
                    this.windDirection = windDirection;
                }

                @JsonProperty
                public String getWindDirectionAbbreviation() {
                    return windDirectionAbbreviation;
                }

                @JsonProperty
                public void setWindDirectionAbbreviation(String windDirectionAbbreviation) {
                    this.windDirectionAbbreviation = windDirectionAbbreviation;
                }

                @JsonProperty
                public String getWindDirectionFull() {
                    return windDirectionFull;
                }

                @JsonProperty
                public void setWindDirectionFull(String windDirectionFull) {
                    this.windDirectionFull = windDirectionFull;
                }

                @JsonProperty
                public Integer getWindSpeedKph() {
                    return windSpeedKph;
                }

                @JsonProperty
                public void setWindSpeedKph(Integer windSpeedKph) {
                    this.windSpeedKph = windSpeedKph;
                }

                @JsonProperty
                public Integer getWindSpeedMph() {
                    return windSpeedMph;
                }

                @JsonProperty
                public void setWindSpeedMph(Integer windSpeedMph) {
                    this.windSpeedMph = windSpeedMph;
                }
            }
        }
    }

    @Override
    public String toJsonString() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(this);
    }

    @Override
    public WeatherReport[] convert() {
        List<WeatherReport> reports = new ArrayList<>();

        for (WeatherForecastAggregated forecastAggregated : forecasts) {
            WeatherReport weatherReport = new WeatherReport();

            for (int i = 0; i < forecastAggregated.detailed.reports.length; i++) {
                WeatherForecastAggregated.Detailed.Report report = forecastAggregated.detailed.reports[i];

                WeatherReport.Temperature temperature = new WeatherReport.Temperature(report.getTemperatureC(), report.getFeelsLikeTemperatureF());
                WeatherReport.Temperature.FeelsLike feelsLike = new WeatherReport.Temperature.FeelsLike(report.getFeelsLikeTemperatureC(), report.getFeelsLikeTemperatureF());
                temperature.setFeelsLike(feelsLike);
                weatherReport.setTemperature(temperature);

                WeatherReport.Weather weather = new WeatherReport.Weather(report.getWeatherType(), report.getWeatherTypeText(), report.getEnhancedWeatherDescription());
                weatherReport.setWeather(weather);

                weatherReport.setHumidity(report.getHumidity());

                WeatherReport.TimeDate timeDate = new WeatherReport.TimeDate(report.getTimeslot(), report.getTimeslotLength(), report.getLocalDate());
                weatherReport.setTimeDate(timeDate);

                weatherReport.setVisibility(report.getVisibility());

                WeatherReport.Wind.Speed speed = new WeatherReport.Wind.Speed(report.getWindSpeedMph(), report.getWindSpeedKph());
                WeatherReport.Wind wind = new WeatherReport.Wind(speed, WindDirection.valueOf(report.getWindDirection()), report.getWindDirectionFull(), report.getWindDescription());
                weatherReport.setWind(wind);

                WeatherReport.Pressure pressure = new WeatherReport.Pressure(report.getPressure(), PressureDirection.NotAvailable);
                weatherReport.setPressure(pressure);
            }

            WeatherReport.Rain rain = new WeatherReport.Rain(forecastAggregated.summary.report.precipitationProbabilityInPercent, forecastAggregated.summary.report.precipitationProbabilityText);
            weatherReport.setRain(rain);

            WeatherReport.Updates updates = new WeatherReport.Updates(forecastAggregated.detailed.issueDate, forecastAggregated.detailed.lastUpdated);
            weatherReport.setUpdates(updates);

            reports.add(weatherReport);
        }

        return reports.toArray(new WeatherReport[0]);
    }
}
