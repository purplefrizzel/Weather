package com.purplefrizzel.weather.services.weather;

import com.purplefrizzel.weather.api.models.dto.WeatherObservationsDTO;
import com.purplefrizzel.weather.api.models.weather.WeatherForecast;
import com.purplefrizzel.weather.core.utils.Lang;
import com.purplefrizzel.weather.services.BBCApi;

import java.io.IOException;
import java.net.URISyntaxException;

public class WeatherForecastService {

    public WeatherForecast getWeatherForecast(String location, Lang lang) throws IOException, URISyntaxException, InterruptedException {
        WeatherObservationsDTO weatherObservationsDTO = BBCApi.observationsClient(location, lang, WeatherObservationsDTO.class);

        return weatherObservationsDTO.convert();
    }
}

