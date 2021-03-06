package com.purplefrizzel.weather.services.weather;

import com.purplefrizzel.weather.api.models.dto.WeatherObservationsDTO;
import com.purplefrizzel.weather.api.models.weather.WeatherStation;
import com.purplefrizzel.weather.core.utils.Lang;
import com.purplefrizzel.weather.services.BBCApi;

import java.io.IOException;
import java.net.URISyntaxException;

public class WeatherStationService {

    public WeatherStation getWeatherStation(String location, Lang lang) throws URISyntaxException, InterruptedException, IOException {
        WeatherObservationsDTO observations = BBCApi.observationsClient(location, lang, WeatherObservationsDTO.class);

        return observations.getStation().convert();
    }
}
