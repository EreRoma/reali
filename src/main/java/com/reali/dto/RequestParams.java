package com.reali.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RequestParams {
    Integer minPrice;
    Integer maxPrice;
    Integer minBed;
    Integer maxBed;
    Integer minBath;
    Integer maxBath;
}
