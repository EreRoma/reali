package com.reali.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeoJson{
    @JsonProperty("type")
    String type;
    @JsonProperty("features")
    List<Feature> features;
}