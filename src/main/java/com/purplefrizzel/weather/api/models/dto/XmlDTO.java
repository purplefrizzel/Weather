package com.purplefrizzel.weather.api.models.dto;

import com.purplefrizzel.weather.api.models.XmlRecord;

public interface XmlDTO<T> extends XmlRecord {

    T convert();
}
