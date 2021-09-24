package com.purplefrizzel.weather.services.location;

import com.purplefrizzel.weather.api.models.dto.LocationSearchResultsDTO;
import com.purplefrizzel.weather.api.models.dto.WeatherLocationDTO;
import com.purplefrizzel.weather.api.models.location.WeatherLocation;
import com.purplefrizzel.weather.core.utils.Lang;
import com.purplefrizzel.weather.services.BBCApi;

import java.io.IOException;
import java.net.URISyntaxException;

public class WeatherLocationService {

    public WeatherLocation getWeatherLocation(String location, Lang lang) throws URISyntaxException, IOException, InterruptedException {
        WeatherLocationDTO weatherLocationDTO = BBCApi.locationClient(location, lang, WeatherLocationDTO.class);

        return weatherLocationDTO.convert();
    }

    public WeatherLocation[] getWeatherLocations(String query, Lang lang) throws URISyntaxException, IOException, InterruptedException {
        LocationSearchResultsDTO resultsDTO = BBCApi.locationSearchClient(query, lang, LocationSearchResultsDTO.class);

        return resultsDTO.convert().getLocations();
    }
}
