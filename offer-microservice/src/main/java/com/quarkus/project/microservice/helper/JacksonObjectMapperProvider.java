package com.quarkus.project.microservice.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;

@Provider
public class JacksonObjectMapperProvider implements ContextResolver<ObjectMapper> {

    private final ObjectMapper objectMapper;

    public JacksonObjectMapperProvider() {
        objectMapper = new ObjectMapper();
        // Enable pretty print
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return objectMapper;
    }
}
