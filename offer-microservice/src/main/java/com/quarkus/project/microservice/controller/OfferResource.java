package com.quarkus.project.microservice.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quarkus.project.microservice.dto.OfferWithPrice;
import com.quarkus.project.microservice.dto.PriceResponse;
import com.quarkus.project.microservice.model.Offer;
import com.quarkus.project.microservice.proxy.PriceServiceClient;
import com.quarkus.project.microservice.repository.OfferRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.openapi.annotations.Operation;
import java.util.ArrayList;
import java.util.List;

@Path("/offers")
public class OfferResource {

    @Inject
    OfferRepository offerRepository;

   @Inject
   PriceServiceClient priceServiceClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Offer> getAllOffers() {
       return offerRepository.listAll();
    }

    @GET
    @Path("/offer-prices")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "Returns offer prices",
            description = "Price retrieval API")
    @Fallback(fallbackMethod = "fallBack_getOfferPrice")
    @Retry(maxRetries = 3, delay = 3000)
    @CircuitBreaker(
            requestVolumeThreshold = 5,
            failureRatio = 0.3,
            successThreshold = 3,
            failOn =RuntimeException.class
    )
    public List<OfferWithPrice> getAllOffersWithPrices()  {
        List<Offer> offers = offerRepository.listAll();
        return offers.stream().map(this::combineOfferWithPrice).toList();
    }


    private OfferWithPrice combineOfferWithPrice(Offer offer) {
        String priceResponse = priceServiceClient.getPrices();
        ObjectMapper mapper = new ObjectMapper();
        List<PriceResponse> prices = new ArrayList<>();

        try{
            prices = mapper.readValue(priceResponse, new TypeReference<List<PriceResponse>>() {});
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

        OfferWithPrice offerWithPrice = new OfferWithPrice();
        offerWithPrice.setId(offer.id);
        offerWithPrice.setDescription(offer.description);
        offerWithPrice.setDiscount(offer.discount);
        offerWithPrice.setPrice(prices.get(0).getAmount());
        offerWithPrice.setCurrency(prices.get(0).getCurrency());

        return offerWithPrice;
    }

    public List<OfferWithPrice> fallBack_getOfferPrice() {
        // To send Default values
        OfferWithPrice fallback = new OfferWithPrice(0L, "Please, Try again later.", 0.0, 0.0, "USD");
        return List.of(fallback);
    }
}

