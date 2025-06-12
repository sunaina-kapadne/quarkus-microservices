package com.quarkus.project.microservice.repository;

import com.quarkus.project.microservice.model.Price;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PriceRepository implements PanacheRepository<Price> {
    // Custom query methods can be added here
}

