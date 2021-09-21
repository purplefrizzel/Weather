package com.purplefrizzel.weather.core.utils;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PressureDirection {
    Rising("Rising"),
    Falling("Falling"),
    Steady("Steady"),
    NotAvailable("Not available");

    private final String pressureDirection;

    PressureDirection(String pressureDirection) {
        this.pressureDirection = pressureDirection;
    }

    @JsonValue
    public String getPressureDirection() {
        return pressureDirection;
    }

    @Override
    public String toString() {
        return this.getPressureDirection();
    }
}
