package com.purplefrizzel.weather.api.models.time;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.purplefrizzel.weather.api.models.JSONRecord;

public class Time implements JSONRecord {

    private final String dateTime;
    private final String time;
    private final String date;
    private final String timeZone;
    private final String dayOfWeek;

    @JsonCreator
    public Time(@JsonProperty("dateTime") String dateTime, @JsonProperty("time") String time, @JsonProperty("date") String date, @JsonProperty("timeZone") String timeZone, @JsonProperty("dayOfWeek") String dayOfWeek) {
        this.dateTime = dateTime;
        this.time = time;
        this.date = date;
        this.timeZone = timeZone;
        this.dayOfWeek = dayOfWeek;
    }

    @JsonProperty
    public String getDateTime() {
        return dateTime;
    }

    @JsonProperty
    public String getTime() {
        return time;
    }

    @JsonProperty
    public String getDate() {
        return date;
    }

    @JsonProperty
    public String getTimeZone() {
        return timeZone;
    }

    @JsonProperty
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    @Override
    public String toJsonString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(this);
    }
}
