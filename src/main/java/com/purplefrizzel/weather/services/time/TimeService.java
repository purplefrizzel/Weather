package com.purplefrizzel.weather.services.time;

import com.purplefrizzel.weather.api.models.dto.TimeDTO;
import com.purplefrizzel.weather.api.models.time.Time;
import com.purplefrizzel.weather.services.TimeApi;

import java.io.IOException;
import java.net.URISyntaxException;

public class TimeService {

    public Time getTime(String timeZone) throws URISyntaxException, IOException, InterruptedException {
        return TimeApi.timeClient(timeZone, TimeDTO.class).convert();
    }
}
