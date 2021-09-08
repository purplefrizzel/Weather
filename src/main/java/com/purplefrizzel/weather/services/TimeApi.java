package com.purplefrizzel.weather.services;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public final class TimeApi {

    private static final HttpClient httpClient = HttpClient.newHttpClient();

    public static <T> T timeClient(String timeZone, Class<T> clazz) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest
                .newBuilder(new URI("https://www.timeapi.io/api/Time/current/zone?timeZone=" + timeZone))
                .GET()
                .header("User-Agent", "weather.purplefrizzel.com/" + clazz.getPackage().getImplementationVersion())
                .build();

        HttpResponse<InputStream> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofInputStream());

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(response.body(), clazz);
    }
}
