package com.reali.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.reali.enumiration.Type;
import com.reali.model.ListingDetails;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Feature {
    @JsonProperty("type")
    String type;
    @JsonProperty("geometry")
    Geometry geometry;
    @JsonProperty("properties")
    Properties properties;

    public Feature(ListingDetails detail) {
        this.type = Type.FEATURE.getLabel();
        this.geometry = new Geometry(detail);
        this.properties = new Properties(detail);
    }
}
