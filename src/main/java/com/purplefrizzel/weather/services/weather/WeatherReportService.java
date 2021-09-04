package com.purplefrizzel.weather.services.weather;

import com.purplefrizzel.weather.api.models.dto.WeatherObservationsDTO;
import com.purplefrizzel.weather.api.models.weather.WeatherReport;
import com.purplefrizzel.weather.core.utils.Lang;
import com.purplefrizzel.weather.services.BBCApi;

import java.io.IOException;
import java.net.URISyntaxException;

public class WeatherReportService {

    public WeatherReport getWeatherReport(String location, Lang lang) throws URISyntaxException, IOException, InterruptedException {
        WeatherObservationsDTO observations = BBCApi.observationsClient(location, lang, WeatherObservationsDTO.class);

        return observations.getObservations()[0].convert();
    }
}
