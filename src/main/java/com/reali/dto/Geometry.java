package com.reali.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.reali.enumiration.Type;
import com.reali.model.ListingDetails;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class Geometry {
    @JsonProperty("type")
    String type;
    @JsonProperty("coordinates")
    List<Double> coordinates;

    public Geometry(ListingDetails detail) {
        this.type = Type.GEOMETRY.getLabel();
        this.coordinates = Arrays.asList(detail.getLat(), detail.getLng());
    }
}
