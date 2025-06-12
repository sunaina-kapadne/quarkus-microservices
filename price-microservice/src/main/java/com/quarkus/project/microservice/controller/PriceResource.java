package com.quarkus.project.microservice.controller;

import com.quarkus.project.microservice.model.Price;
import com.quarkus.project.microservice.repository.PriceRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/prices")
public class PriceResource {

    @Inject
    PriceRepository priceRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Price> getAllPrices() {
        return priceRepository.listAll();
    }
}

