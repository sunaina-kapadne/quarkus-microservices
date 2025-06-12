package com.quarkus.project.microservice.repository;

import com.quarkus.project.microservice.model.Offer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OfferRepository implements PanacheRepository<Offer> {
    // Custom query methods can be added here
}


