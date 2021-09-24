package com.purplefrizzel.weather.api.models.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class LocationSearchResultsDTO implements XmlDTO<LocationSearchResultsDTO> {

    private LocationSearchDTO[] results;

    public LocationSearchDTO[] getResults() {
        return results;
    }

    public void setResults(LocationSearchDTO[] results) {
        this.results = results;
    }

    @Override
    public String toXmlString() throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();

        return mapper.writeValueAsString(this);
    }

    @Override
    public LocationSearchResultsDTO convert() {
        return null;
    }
}
