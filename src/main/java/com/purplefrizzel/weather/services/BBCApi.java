package com.purplefrizzel.weather.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.purplefrizzel.weather.core.utils.Lang;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public final class BBCApi {

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

    public static <T> T locationClient(String location, Lang lang, Class<T> clazz) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest
                .newBuilder(new URI("https://weather-broker-cdn.api.bbci.co.uk/locator/" + lang.getLang() + "/locations/" + location + "/location.json"))
                .GET()
                .header("User-Agent", "weather.purplefrizzel.com/" + clazz.getPackage().getImplementationVersion())
                .build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(response.body(), clazz);
    }

    public static <T> T locationSearchClient(String query, Lang lang, Class<T> clazz) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest
                .newBuilder(new URI("https://locator-service.api.bbci.co.uk/locations?api_key=AGbFAKx58hyjQScCXIYrxuEwJh2W2cmv&&locale=" + lang.getLang() + "&filter=international&place-types=settlement%2Cairport%2Cdistrict&order=importance&s=" + query + "&a=true&format=xml"))
                .GET()
                .header("User-Agent", "weather.purplefrizzel.com/" + clazz.getPackage().getImplementationVersion())
                .build();

        XmlMapper mapper = new XmlMapper();

        HttpResponse<InputStream> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofInputStream());

        return mapper.readValue(response.body(), clazz);
    }
}
