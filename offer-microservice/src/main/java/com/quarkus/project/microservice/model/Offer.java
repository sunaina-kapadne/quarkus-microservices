package com.quarkus.project.microservice.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="offer")
public class Offer extends PanacheEntity {
    @Column(nullable = false)
    public String description;

    @Column(nullable = false)
    public double discount;

    public Offer(){}

    public Offer(String description, double discount) {
        this.description = description;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Offer{description='" + description + "', discount=" + discount + "}";
    }

}


