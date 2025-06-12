package com.quarkus.project.microservice.proxy;

import jakarta.enterprise.context.ApplicationScoped;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@ApplicationScoped
public class PriceServiceClient {

    public String getPrices() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8082/prices"))
                    .GET()
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            return "Failed to fetch prices: " + e.getMessage();
        }
    }
}
