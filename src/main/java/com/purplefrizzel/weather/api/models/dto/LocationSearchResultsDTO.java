package com.purplefrizzel.weather.api.models.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.purplefrizzel.weather.api.models.location.LocationSearch;
import com.purplefrizzel.weather.api.models.location.WeatherLocation;

import java.util.ArrayList;
import java.util.List;

public class LocationSearchResultsDTO implements XmlDTO<LocationSearch> {

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
    public LocationSearch convert() {
        List<WeatherLocation> locations = new ArrayList<>();

        for (LocationSearchDTO location : results) {
            locations.add(location.convert());
        }

        return new LocationSearch(locations.toArray(new WeatherLocation[0]));
    }
}
