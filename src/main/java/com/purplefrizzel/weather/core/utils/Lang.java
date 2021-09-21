package com.purplefrizzel.weather.core.utils;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Lang {
    en("en"),
    cy("cy"),
    gd("gd"),
    ga("ga");

    private final String lang;

    Lang(String lang) {
        this.lang = lang;
    }

    @JsonValue
    public String getLang() {
        return lang;
    }
}
