package com.reali.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.reali.model.ListingDetails;
import lombok.Data;

@Data
public class Properties {
    @JsonProperty("id")
    Integer id;
    @JsonProperty("price")
    int price;
    @JsonProperty("street")
    String street;
    @JsonProperty("bedrooms")
    int bedrooms;
    @JsonProperty("bathrooms")
    int bathrooms;
    @JsonProperty("sq_ft")
    int sq_ft;

    public Properties(ListingDetails detail) {
        this.id = detail.getId();
        this.price = detail.getPrice();
        this.street = detail.getStreet();
        this.bedrooms = detail.getBedrooms();
        this.bathrooms = detail.getBathrooms();
    }
}
