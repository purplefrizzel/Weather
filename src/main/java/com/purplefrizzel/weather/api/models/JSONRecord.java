package com.purplefrizzel.weather.api.models;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface JSONRecord {

    String toJsonString() throws JsonProcessingException;
}
