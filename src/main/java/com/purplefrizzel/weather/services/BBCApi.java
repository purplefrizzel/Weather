package com.purplefrizzel.weather.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.purplefrizzel.weather.core.utils.Lang;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BBCApi {

    private static final HttpClient httpClient = HttpClient.newHttpClient();

    public static <T> T observationsClient(String location, Lang lang, Class<T> clazz) throws IOException, InterruptedException, URISyntaxException {
        HttpRequest httpRequest = HttpRequest
                .newBuilder(new URI("https://weather-broker-cdn.api.bbci.co.uk/" + lang.getLang() + "/observation/" + location))
                .GET()
                .header("User-Agent", "weather.purplefrizzel.com/" + clazz.getPackage().getImplementationVersion())
                .build();

        HttpResponse<InputStream> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofInputStream());

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(response.body(), clazz);
    }
}
