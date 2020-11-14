package com.reali.service;

import com.reali.dto.GeoJson;

import java.util.Map;

public interface Ilisting {
    GeoJson filterListings(Map<String, String> requestParams);
}
