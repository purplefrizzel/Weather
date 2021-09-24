package com.purplefrizzel.weather.api.models.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.purplefrizzel.weather.core.utils.Lang;

public class LocationSearchDTO implements XmlDTO<LocationSearchDTO> {

    private String id;
    private String name;
    private String container;
    private String containerId;
    private Lang language;
    private String timezone;
    private String country;
    private Double latitude;
    private Double longitude;
    private String placeType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getContainerId() {
        return containerId;
    }

    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    public Lang getLanguage() {
        return language;
    }

    public void setLanguage(Lang lang) {
        this.language = lang;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    @Override
    public String toXmlString() throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();

        return mapper.writeValueAsString(this);
    }

    @Override
    public LocationSearchDTO convert() {
        return null;
    }
}
