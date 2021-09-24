package com.purplefrizzel.weather.api.models;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface XmlRecord {

    String toXmlString() throws JsonProcessingException;
}
