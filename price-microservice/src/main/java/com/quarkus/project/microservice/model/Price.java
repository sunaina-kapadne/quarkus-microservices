package com.quarkus.project.microservice.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="price")
public class Price extends PanacheEntity {
    @Column(nullable = false)
    public double amount;

    @Column(nullable = false)
    public String currency;

    public Price(){}

    public Price(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public String toString() {
        return "Price{amount='" + amount + "', currency=" + currency + "}";
    }

}

