package com.purplefrizzel.weather.api.models.dto;

import com.purplefrizzel.weather.api.models.JSONRecord;

public interface DTO<T> extends JSONRecord {

    T convert();
}
