package com.quarkus.project.microservice.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonPropertyOrder({ "id", "description", "price", "discount", "currency" })
@Data
public class OfferWithPrice {
    private Long id;
    private String description;
    private double discount;
    private double price;
    private String currency;

    public OfferWithPrice() {}

    public OfferWithPrice(Long id, String description, double discount, double price, String currency) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.currency = currency;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
