package com.purplefrizzel.weather.api.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.purplefrizzel.weather.api.models.time.Time;

public class TimeDTO implements DTO<Time> {

    private String dateTime;
    private String date;
    private String time;
    private String timeZone;
    private String dayOfWeek;
    private Boolean dstActive;
    private Integer milliSeconds;
    private Integer seconds;
    private Integer minute;
    private Integer hour;
    private Integer day;
    private Integer month;
    private Integer year;

    @JsonProperty
    public String getDateTime() {
        return dateTime;
    }

    @JsonProperty
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @JsonProperty
    public String getDate() {
        return date;
    }

    @JsonProperty
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty
    public String getTime() {
        return time;
    }

    @JsonProperty
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty
    public String getTimeZone() {
        return timeZone;
    }

    @JsonProperty
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @JsonProperty
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    @JsonProperty
    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @JsonProperty
    public Boolean getDstActive() {
        return dstActive;
    }

    @JsonProperty
    public void setDstActive(Boolean dstActive) {
        this.dstActive = dstActive;
    }

    @JsonProperty
    public Integer getMilliSeconds() {
        return milliSeconds;
    }

    @JsonProperty
    public void setMilliSeconds(Integer milliSeconds) {
        this.milliSeconds = milliSeconds;
    }

    @JsonProperty
    public Integer getMinute() {
        return minute;
    }

    @JsonProperty
    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    @JsonProperty
    public Integer getHour() {
        return hour;
    }

    @JsonProperty
    public void setHour(Integer hour) {
        this.hour = hour;
    }

    @JsonProperty
    public Integer getDay() {
        return day;
    }

    @JsonProperty
    public void setDay(Integer day) {
        this.day = day;
    }

    @JsonProperty
    public Integer getMonth() {
        return month;
    }

    @JsonProperty
    public void setMonth(Integer month) {
        this.month = month;
    }

    @JsonProperty
    public Integer getYear() {
        return year;
    }

    @JsonProperty
    public void setYear(Integer year) {
        this.year = year;
    }

    @JsonProperty
    public Integer getSeconds() {
        return seconds;
    }

    @JsonProperty
    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toJsonString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(this);
    }

    @Override
    public Time convert() {
        return new Time(getDateTime(), getTime(), getDate(), getTimeZone(), getDayOfWeek());
    }
}
