package com.purplefrizzel.weather.api.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ApiResponse<T> implements JSONRecord {

    private final T data;
    private final Metadata metadata;

    @JsonCreator
    public ApiResponse(@JsonProperty("data") T data, @JsonProperty("metadata") Metadata metadata) {
        this.data = data;
        this.metadata = metadata;
    }

    @JsonProperty
    public T getData() {
        return data;
    }

    @JsonProperty
    public Metadata getMetadata() {
        return metadata;
    }

    @Override
    public String toJsonString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(this);
    }

    public static class Metadata {

        private final String timestamp = LocalDateTime.now().toString();
        private final Map<String, Object> responseMetadata = new HashMap<>();

        @JsonProperty
        public String getTimestamp() {
            return timestamp;
        }

        @JsonProperty
        public Map<String, Object> getResponseMetadata() {
            return responseMetadata;
        }
    }
}
