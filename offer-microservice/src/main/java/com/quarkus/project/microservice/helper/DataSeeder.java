package com.quarkus.project.microservice.helper;

import com.quarkus.project.microservice.model.Offer;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DataSeeder {
    @Transactional
    void onStart(@Observes StartupEvent event) {
        Offer offer1 = new Offer("Special Offer", 15.5);
        offer1.persist();

        Offer offer2 = new Offer("Flash Sale", 10.0);
        offer2.persist();
    }
}

