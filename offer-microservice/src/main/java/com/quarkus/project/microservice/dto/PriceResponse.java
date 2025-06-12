package com.quarkus.project.microservice.dto;

public class PriceResponse {
    public int id;
    public double amount;
    public String currency;

    public PriceResponse() {}

    public PriceResponse(int id, double amount, String currency) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "PriceResponse{" +
                "id=" + id +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
