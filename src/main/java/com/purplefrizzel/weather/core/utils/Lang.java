package com.purplefrizzel.weather.core.utils;

public enum Lang {
    en("en"),
    cy("cy"),
    gd("gd"),
    ga("ga");

    private final String lang;

    Lang(String lang) {
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }
}
