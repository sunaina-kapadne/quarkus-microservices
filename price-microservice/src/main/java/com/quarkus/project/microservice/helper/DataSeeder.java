package com.quarkus.project.microservice.helper;

import com.quarkus.project.microservice.model.Price;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.transaction.Transactional;

import java.time.LocalDate;

@ApplicationScoped
public class DataSeeder {
    @Transactional
    void onStart(@Observes StartupEvent event) {
        Price alice = new Price(20.5, "USD");
        alice.persist();

        Price bob = new Price(25.0, "USD");
        bob.persist();
    }
}
